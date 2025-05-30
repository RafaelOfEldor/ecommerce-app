terraform {
  required_version = ">= 1.0.0"
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 5.0"
    }
  }
}

provider "aws" {
  region = "eu-west-1"
}

terraform {
  backend "s3" {
    bucket = "mock-ecommerce-state-bucket"
    key    = "mock-ecommerce/terraform.tfstate"
    region = "eu-west-1"
    encrypt = true
  }
}


