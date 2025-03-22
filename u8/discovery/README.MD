### Introduction

This a demo to illustrate the Service Discovery capability provided by Netflix Eureka. 

### How to test run
1. Open 4 different terminal
2. In terminal 1, run the Spring Boot Application under server project. Make sure the Eureka Server is started when no further log message generated.
3. In terminal 2 & 3, run the Spring Boot Application under client project. Make sure the 1st client is started when no further log message generated, and then run the 2nd client.
4. In terminal 4, run the Spring Boot Application under consumer project.

### Architecture

The __Eureka Server__ provides registration and discovery services for microservices. 

The __Demo Service__ provide a simple web service that returns a string. Two instances of the demo service are registered with the Eureka server.

The __Demo Consumer__ consumes the web service provided by the Demo Service. It retrieves the address of the Demo Service from the Eureka server and makes a call to it. It consumes Demo Service in a ***round robin*** fashion.

![microservices-arch](./images/eureka.drawio.png "Microservices Architecture")
![Eureka Server](./images/eureka.PNG "Eureka Server")

### The Effect

As shown in below diagram, the Demo Consumer is able to consume the Demo Service in a ***round robin*** fashion.

![Output](./images/outcome.png "Output")
