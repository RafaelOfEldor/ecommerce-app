resource "aws_cloudwatch_log_group" "backend" {
  name              = "/ecs/mock-ecommerce-backend"
  retention_in_days = 7
}

resource "aws_cloudwatch_log_group" "frontend" {
  name              = "/ecs/mock-ecommerce-frontend"
  retention_in_days = 7
}
