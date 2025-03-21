output "aks_name" {
  value = azurerm_kubernetes_cluster.aks.name
}

output "acr_admin_username" {
  value = azurerm_container_registry.acr.admin_username
}

output "acr_admin_password" {
  value = azurerm_container_registry.acr.admin_password
  sensitive = true
}

output "acr_name"{
  value = azurerm_container_registry.acr.name
}

output "rg_name"{
  value = var.resource_group_name
}