
Spring Cloud Config Server & Client

This project consists of two parts:
	1.	Spring Cloud Config Server: A server that serves configuration files.
	2.	Spring Cloud Config Client: A client that uses these configuration files.


 Before you begin, make sure you have the following installed:
	•	JDK 21
	•	Maven (for building the projects)
	•	Spring Boot (for running the projects)

Setting Up the Config Server
  1.	First, set up the Config Server.
  2.	To do this, navigate to the Spring Cloud Config Server project and build it:

mvn clean install
mvn spring-boot:run

  3.	The configuration files are located in src/main/resources/config.
  4.	You can access the configuration using the following URL:

 http://localhost:8888/spring-cloud-config/{profile}


 Setting Up the Config Client
	1.	Build the Spring Cloud Config Client project:
 
 mvn clean install
mvn spring-boot:run

Using the API

GET /fetch-config

This API retrieves the configuration for the specified profile from the Config Server.

Inputs:
	•	profile (optional): The profile for which you want to fetch the configuration. The default is dev.

Example:
GET http://localhost:9192/fetch-config?profile=dev

Response:

The response will contain the configuration JSON received from the Config Server.
