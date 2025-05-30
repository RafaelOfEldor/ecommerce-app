resource "aws_service_discovery_private_dns_namespace" "mock" {
  name = "mock.local"
  vpc  = aws_vpc.main.id
}
