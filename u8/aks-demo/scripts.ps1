# Login in and get the subscription Id for later user
az login --use-device-code
Set-Variable -Name "subId" $(az account list --query "[?isDefault].id" -otsv)
az account set -s $subId

# Assign some variable assignment for later user
Set-Variable -Name "k8sNS" -Value "comp4680sed-demo"
Set-Variable -Name "k8sSA" -Value "comp4680sed-demo-sa"
Set-Variable -Name "k8sSvc" -Value "comp4680sed-demo"
Set-Variable -Name "dir" -Value "k8s-yaml"

# Provision all the Azure Resource like RG, ACR, AKS
terraform -chdir=tf init
terraform -chdir=tf plan -out main.tfplan
terraform -chdir=tf apply main.tfplan

# Assign variable which is the output for terraform.
Set-Variable -Name "acr_admin_username" $(terraform -chdir=tf output --raw acr_admin_username)
Set-Variable -Name "acr_admin_password" $(terraform -chdir=tf output --raw acr_admin_password)
Set-Variable -Name "aks_name" $(terraform -chdir=tf output --raw aks_name)
Set-Variable -Name "acr_name" $(terraform -chdir=tf output --raw acr_name)
Set-Variable -Name "rg_name" $(terraform -chdir=tf output --raw rg_name)

# Get access to AKS created so that we can deploy service and SA by kubectl later
az aks get-credentials -n "${aks_name}" -g "${rg_name}"

# Compile the application code
mvn -f code/pom.xml clean package -D maven.test.skip=true

# Login to ACR and build the docker image, push the image to the ACR
docker login "${acr_admin_username}.azurecr.io" -u "${acr_admin_username}" -p "${acr_admin_password}"
docker image build -t "${acr_admin_username}.azurecr.io/comp4680sed-demo" code/.
docker push "${acr_admin_username}.azurecr.io/comp4680sed-demo"

# Just clean up the local build and code
mvn -f code/pom.xml clean
docker rmi "${acr_admin_username}.azurecr.io/comp4680sed-demo"

### This part is for creating the K8S yaml file, especially for the ServiceAccount.yaml
# Create the temp folder for the k8s yam file
if (-not (Test-Path -Path $dir -PathType Container)) {
    New-Item -ItemType Directory -Path $dir
}

# Namespace and Deployment yaml
echo @"
apiVersion: v1
kind: Namespace
metadata:
  name: comp4680sed-demo
---
apiVersion: apps/v1
kind: Deployment
metadata:
  name: comp4680sed-demo
  labels:
    app: comp4680sed-demo
  namespace: ${k8sNS}
spec:
  replicas: 1
  selector:
    matchLabels:
      app: comp4680sed-demo
  template:
    metadata:
      labels:
        app: comp4680sed-demo
    spec:
      containers:
        - name: comp4680sed-demo
          image: ${acr_admin_username}.azurecr.io/comp4680sed-demo:latest
          ports:
            - containerPort: 8080
"@ > ${dir}/Deployment.yaml

# Service yaml
echo @"
apiVersion: v1
kind: Service
metadata:
  name: ${k8sSvc}
  namespace: ${k8sNS}
  labels:
    app: comp4680sed-demo   
spec:
  selector:
    app: comp4680sed-demo
  ports:
    - protocol: TCP
      port: 80
      targetPort: 8080
  type: LoadBalancer
"@ > ${dir}\Service.yaml
#Apply the YAML to AKS
kubectl apply -f ${dir}\.

### Get the output URL, and test for it
Set-Variable -Name "SvcUrl" $(kubectl get service ${k8sSvc} -n ${k8sNS} -o jsonpath='{.status.loadBalancer.ingress[0].ip}')
echo "http://${SvcUrl}/"

### Clean up the resource
<#
  kubectl delete -f ${dir}\.
  terraform -chdir=tf apply -destroy -auto-approve

  Remove-Item -Path ${dir} -Recurse -Force
  Get-ChildItem -Path tf -Recurse | Where-Object { $_.Extension -ne '.tf' } | Remove-Item -Force -Recurse
  
#>
