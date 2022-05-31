terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 3.0"
    }
  }
  required_version = ">= 1.1.4"
  cloud {
    organization = "everest-app"
    workspaces {
      name = "employee-app"
    }
  }
}

provider "aws" {
  region = var.aws_region
}

resource "aws_instance" "employee_app_server" {
  ami                    = var.aws_ami_id
  instance_type          = "t2.micro"
  key_name               = "ec2-deployer-key-pair"
  vpc_security_group_ids = [aws_security_group.main.id]

  tags = {
    Name = "employee_app_server"
  }
  connection {
    type        = "ssh"
    host        = self.public_ip
    port        = 22
    user        = "ec2-user"
    private_key = file("keys/aws_ssh_key")
    timeout     = "4m"
    agent       = false
  }
}

resource "aws_security_group" "main" {
  egress = [
    {
      cidr_blocks      = ["0.0.0.0/0", ]
      description      = ""
      from_port        = 0
      ipv6_cidr_blocks = []
      prefix_list_ids  = []
      protocol         = "-1"
      security_groups  = []
      self             = false
      to_port          = 0
    }
  ]
  ingress                = [
    {
      cidr_blocks      = [ "0.0.0.0/0", ]
      description      = ""
      from_port        = 22
      ipv6_cidr_blocks = []
      prefix_list_ids  = []
      protocol         = "tcp"
      security_groups  = []
      self             = false
      to_port          = 22
    },
    {
      cidr_blocks      = [
        "0.0.0.0/0",
      ]
      description      = ""
      from_port        = 3000
      ipv6_cidr_blocks = []
      prefix_list_ids  = []
      protocol         = "tcp"
      security_groups  = []
      self             = false
      to_port          = 3000
    },
    {
      cidr_blocks      = [
        "0.0.0.0/0",
      ]
      description      = ""
      from_port        = 8080
      ipv6_cidr_blocks = []
      prefix_list_ids  = []
      protocol         = "tcp"
      security_groups  = []
      self             = false
      to_port          = 8080
    }
  ]
}

resource "aws_eip" "ec2-user" {
  vpc      = true
  instance = aws_instance.employee_app_server.id
}

resource "aws_key_pair" "deployer" {
  key_name   = "ec2-deployer-key-pair"
  public_key = file("keys/aws_ssh_key.pub")
}

output "public_ip" {
  value = aws_instance.employee_app_server.public_ip
}