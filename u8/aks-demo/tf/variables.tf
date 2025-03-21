variable "resource_group_name" {
  default = "wi-demo-rg"
}

variable "location" {
  default = "eastasia"
}

variable "acr_name" {
  default = "widemoacr"
}

variable "acr_sku" {
  default = "Basic"
}

variable "aks_name" {
  default = "wi-demo-aks"
}

variable "aks_node_count" {
  default = 1
}

variable "aks_vm_size" {
  default = "Standard_B2s"
}