### Introduction

This is a demo project to illustrate how to containerize your application as a container image and eventually deploy to Kubernetes. We choose Azure as our platform which is different from our course COMP4680SED. However, the underlying technology and procedure are the same. Therefore it won't affect your learning.

We will learn how to use Infrastructure as Code (IaC) to provision all the cloud resource needed (refer to tech stack), and we build the container image by using Dockerfile, push the image to a container registry, and eventually deploy the application by the container image to Kubernetes cluster, which is a container orchestration PaaS service on cloud. And expose the application to Internet.

As mentioned above, you may have other options when choosing the tech stack. For example you can use GKS (Google Kubernetes Service) or Azure Container Instance (ACI) instead of Azure Kubernetes Service (AKS) we used.

### Project structure

| Folder / Files  | Description                                                                                                                 |
|-----------------|-----------------------------------------------------------------------------------------------------------------------------|
| code            | Folder containing the Spring Boot project                                                                                   |
| code/Dockerfile | File that contains instruction when build the container image                                                               |
| tf              | Folder containing all Terraform script                                                                                      |
| tf/main.tf      | The Terraform definition file that contains all the Azure Resource that will be provisioned and theirs final configurations |
| tf/variables.tf | The Terraform script the hold all the variables which will apply when provisioning                                          |
| scripts.ps1     | The script that will execute the provisioning, compile, build and deployment                                                |

### Tech Stack
Application Framework : Spring Boot, Maven, Bootstrap
IaC : Terraform
Application Platform : Azure Kubernetes Service (PaaS)
Container Registry : Azure Container Registry

### URL
[Course URL https://www.hkmu.edu.hk/admissions/course-info/comp-4680sed/](https://www.hkmu.edu.hk/admissions/course-info/comp-4680sed/)

[Course Guide https://www.hkmu.edu.hk/ALTO/course_guide/current/COMP_4680SED_CG.pdf](https://www.hkmu.edu.hk/ALTO/course_guide/current/COMP_4680SED_CG.pdf)
