variable "aws_region" {
  description = "The AWS region to create things in."
  default     = "ap-south-1"
}

variable "aws_ami_id" {
  description = "AWS EC2 Instance AMI ID"
  default = "ami-079b5e5b3971bd10d"
}

variable "ssh_key_public" {
  description = "SSH Public Key to connect EC2"
  default = "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQDYdecKG6lvaRnJ2oSyR+Aj7Z2HwzHeGOESF6dfpd/qkJGvZIFPK2h/1ehx+rUND57uT53h2AqhmSaJ+EzMYdvtxt82tLjIUwTRtUbOqg/lJeEZ8FZStOcPUBMHbd0NIsLMi8zyCguawkl0RkmJ65xulorbxaeY91U0DalxQ29v+4V0P0GTloxGGwK7wVyVK+wRzOYmXXnRPdDK75LpTkpIRtKE5qq4ozzUT8SD3dFcnAmVDte+a35WHRbgAdVHXDvNJuUHhm4m7bdGzgx/i8bKg2AW3WplTSSUMOXlNMSIi+B90go8GchFTwSRnicyS+eTuA9FZwRtrvpMOwOD9m3T/VaxDbzapbNSpJsfEdg0wMzZkK0uW2RwRH/Qlv7S9y8bfctxuishrAZ5GeTzxU6fJdvjsLzUnw5RsfXyLpZX7LYaiTn2R+C6A+e8VpBo2aBynJJrztdbyxiGaThPb3qbHdn5M9chRLb7do0vj5besitrmdoRuVfZauo4hxVyv1M= charan@Charans-MacBook-Pro.local"
}