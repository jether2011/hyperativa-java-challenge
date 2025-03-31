# Getting Started

## Running the application
This project is a Spring Boot application that uses Gradle as the build tool. It is designed to be run in a Docker container, but it can also be run locally using Gradle.
Additionally, it uses Spring Security for authentication and authorization, and Spring Data JPA for database access and is using Java 21 and Spring Boot 3.4.4.
The application is configured to use a PostgreSQL MySQL, and it uses Flyway for database migrations. The application also includes a REST API for managing users and cards.

## Docker
To run the application in a Docker container, you need to have Docker installed on your machine. You can find instructions for installing Docker [here](https://docs.docker.com/get-docker/).
Running the database container:

```bash
docker compose -f docker/mysql.yml up -d
```

## Java application
To run the application, you can use the following command (under the project root folder):

```bash
 ./gradlew bootRun
```        
After the application is running, you can access the API using a Postman collection (`HyperativaChallenge.postman_collection.json`) that is included in the project. 

## Final Considerations

The application is designed to be a simple example of how to use Spring Boot, Spring Security, and Spring Data JPA to create a REST API. It is not intended to be a complete or production-ready application.
### Future Improvements