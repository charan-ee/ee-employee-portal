variable "aws_region" {
  description = "The AWS region to create things in."
  default     = "ap-south-1"
}

variable "aws_ami_id" {
  description = "AWS EC2 Instance AMI ID"
  default = "ami-079b5e5b3971bd10d"
}