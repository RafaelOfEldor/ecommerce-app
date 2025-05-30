variable "react_app_base_url" {
  type    = string
}
variable "backend_api_base_url" {
  type    = string
}
variable "postgres_db" {
  type    = string
}
variable "postgres_user" {
  type    = string
}
variable "postgres_password" {
  type    = string
}
variable "google_discovery_url" {
  type    = string
}
variable "google_client_id" {
  type    = string
}
variable "mongodb_url" {
  type    = string
}
variable "secret_cookie" {
  type    = string
}
variable "react_app_environment_base_url" {
  type    = string
}
variable "microsoft_discovery_url" {
  type    = string
}
variable "microsoft_client_id" {
  type    = string
}

variable "route53_zone_id" {
  description = "The ID of the Route53 hosted zone for mock-ecommerce.com"
  type = string
}

variable "ssl_cert_arn" {
  description = "The ID of the Route53 hosted zone for mock-ecommerce.com"
  type = string
}
variable "frontend_service_name" {
  description = "Service name of frontend"
  type = string
}



