resource "aws_ecs_task_definition" "backend" {
  family                   = "mock-ecommerce-backend"
  requires_compatibilities = ["FARGATE"]
  network_mode             = "awsvpc"
  cpu                      = "512"
  memory                   = "1024"
  execution_role_arn       = aws_iam_role.ecs_task_execution.arn

  container_definitions = jsonencode(local.backend_container)
}


resource "aws_service_discovery_service" "backend" {
  name         = "backend"
  namespace_id = aws_service_discovery_private_dns_namespace.mock.id

  dns_config {
    namespace_id   = aws_service_discovery_private_dns_namespace.mock.id
    routing_policy = "MULTIVALUE"

    dns_records {
      type = "A"
      ttl  = 10
    }
  }

  health_check_custom_config {
    failure_threshold = 1
  }
}

resource "aws_ecs_service" "backend" {
  name            = "backend"
  cluster         = aws_ecs_cluster.main.id
  task_definition = aws_ecs_task_definition.backend.arn
  desired_count   = 1
  launch_type     = "FARGATE"

  network_configuration {
    subnets          = [aws_subnet.private_a.id, aws_subnet.private_b.id]
    security_groups  = [aws_security_group.ecs_service.id]
    assign_public_ip = false
  }

  service_registries {
    registry_arn = aws_service_discovery_service.backend.arn
  }

  load_balancer {
    target_group_arn = aws_lb_target_group.backend.arn
    container_name   = "backend"
    container_port   = 8080
  }

}

locals {
  backend_container = [
    {
      name  = "backend"
      image = "975050009463.dkr.ecr.eu-west-1.amazonaws.com/mock-ecommerce-backend:latest"
      portMappings = [
        {
          containerPort = 8080
          hostPort      = 8080
        }
      ]
      environment = [
        {
          name  = "SPRING_DATASOURCE_URL"
          value = "jdbc:postgresql://${aws_db_instance.mock.address}:${aws_db_instance.mock.port}/${var.postgres_db}"
        },
        {
          name  = "SPRING_DATASOURCE_USERNAME"
          value = var.postgres_user
        },
        {
          name  = "SPRING_DATASOURCE_PASSWORD"
          value = var.postgres_password
        },
        {
          name  = "REACT_APP_BASE_URL"
          value = var.react_app_base_url
        },
        {
          name  = "GOOGLE_DISCOVERY_URL"
          value = var.google_discovery_url
        },
        {
          name  = "GOOGLE_CLIENT_ID"
          value = var.google_client_id
        }
      ]
      logConfiguration = {
        logDriver = "awslogs"
        options = {
          awslogs-group         = aws_cloudwatch_log_group.backend.name
          awslogs-region        = "eu-west-1"
          awslogs-stream-prefix = "ecs"
        }
      }
    }
  ]
}


