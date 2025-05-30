resource "aws_ecs_task_definition" "frontend" {
  family                   = "mock-ecommerce-frontend"
  requires_compatibilities = ["FARGATE"]
  network_mode             = "awsvpc"
  cpu                      = "256"
  memory                   = "512"
  execution_role_arn       = aws_iam_role.ecs_task_execution.arn

  container_definitions = jsonencode(local.frontend_container_definition)
}


resource "aws_ecs_service" "frontend" {
  name            = "frontend"
  cluster         = aws_ecs_cluster.main.id
  task_definition = aws_ecs_task_definition.frontend.arn
  desired_count   = 1
  launch_type     = "FARGATE"

  network_configuration {
    subnets         = [aws_subnet.private_a.id, aws_subnet.private_b.id]
    security_groups = [aws_security_group.ecs_service.id]
  }

  load_balancer {
    target_group_arn = aws_lb_target_group.frontend.arn
    container_name   = "frontend"
    container_port   = 80
  }

  depends_on = [aws_lb_listener.https]
}

locals {
  frontend_environment = [
    { name = "MONGODB_URL", value = var.mongodb_url },
    { name = "SECRET_COOKIE", value = var.secret_cookie },
    { name = "REACT_APP_ENVIRONMENT_BASE_URL", value = var.react_app_environment_base_url },
    { name = "GOOGLE_DISCOVERY_URL", value = var.google_discovery_url },
    { name = "MICROSOFT_DISCOVERY_URL", value = var.microsoft_discovery_url },
    { name = "GOOGLE_CLIENT_ID", value = var.google_client_id },
    { name = "MICROSOFT_CLIENT_ID", value = var.microsoft_client_id },
    { name = "BACKEND_API_BASE_URL", value = var.backend_api_base_url }
  ]

  frontend_container_definition = [
    {
      name  = "frontend"
      image = "975050009463.dkr.ecr.eu-west-1.amazonaws.com/mock-ecommerce-frontend:latest"
      portMappings = [
        {
          containerPort = 80
        }
      ]
      environment = local.frontend_environment
      logConfiguration = {
        logDriver = "awslogs"
        options = {
          awslogs-group         = "/ecs/${var.frontend_service_name}"
          awslogs-region        = "eu-west-1"
          awslogs-stream-prefix = "ecs"
        }
      }
    }
  ]
}

