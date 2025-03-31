# Getting Started

## Running the application
This project is a Spring Boot application that uses Gradle as the build tool. It is designed to be run in a Docker container, but it can also be run locally using Gradle.
Additionally, it uses Spring Security for authentication and authorization and Spring Data JPA for database access and is using Java 21 and Spring Boot 3.4.4.
The application is configured to use a PostgreSQL MySQL, and it uses Flyway for database migrations. It also includes a REST API for managing users and cards.
Finally, the application doesn't use the profiling mode, such as develop, homologation, and production, however, it uses the default profile, and in production, the configuration should be externalized.

## Docker
To run the application in a Docker container, you need to have Docker installed on your machine. You can find instructions for installing Docker: [here](https://docs.docker.com/get-docker/).
Running the database container:

```bash
docker compose -f docker/mysql.yml up -d
```

## Java application
To run the application, you can use the following command (under the project root folder):

```bash
 ./gradlew bootRun
```        
After the application runs, you can access the API using a Postman collection (`HyperativaChallenge.postman_collection.json`) included in the project. 

## Final Considerations
The application is designed to be a simple example of how to use Spring Boot, Spring Security, and Spring Data JPA to create a REST API. It is not intended to be a complete or production-ready application.

### Future Improvements
- Security
 - Add Authorities for the User
 - Add the ROLEs to the generated JWT token
 - When the token gonna be validated, get the ROLE on it and add to the Spring Security Autenticad Context
 - Add the annotations `@Secured` on top of the method to prevent incorrect roles to use some API's
- Webfkux (using async requests)
- Actuator + Prometheus to improve observability and metrics
- Apply cache using some profider like Redis and use distributed hibernate second level cache, both of those, improve the application performance
- Add mappers for DTO to Entity or Entity to DTO
- Scalling X using Docker Swarm or K8S and Y using both also 
- Using a load balancer, calling, and discoveries, the application will achieve High Availability
- For the cards upload file, for production mode, I'd like to refactor to use async processors consuming buckets like S3
- For the current version, it's possíble to change the embedded webserver from `tomcat` to `undertow` (improves the thread requesting pool)
- Using blocking requesting (Spring MVC) we can improve the high throuput using a Spring Event Driven JVM (Application Event Context) or messageing brokers such as RabbitMQ, Kafka, or other
