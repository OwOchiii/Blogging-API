# Blogging API

A Spring Boot application providing a RESTful API for managing blog posts.

## Project Overview

This project is a single-module Spring Boot application configured to handle blog posts. It provides complete CRUD operations (Create, Read, Update, Delete) via a straightforward and documented REST API. The underlying data management is handled by Spring Data JPA and connects to a PostgreSQL database.

## Features

- **RESTful API:** Predictable resource-oriented endpoints.
- **Spring Data JPA:** Easily manages database operations.
- **Swagger Documentation:** Integrated using `springdoc-openapi` to test your API directly from the browser without needing Postman.
- **Automated Timestamps:** Automatically tracks creation and update dates for all posts.

## Prerequisites

- **Java 17**
- **Maven** (A Maven wrapper is included in the project)
- **PostgreSQL** database instance (credentials will need to be configured inside `application.properties`)

## API Endpoints

The API is served under `/blogs`.

| Method   | Endpoint       | Action                                      |
| -------- | -------------- | ------------------------------------------- |
| `GET`    | `/blogs`       | Fetch all blog posts                        |
| `GET`    | `/blogs/{id}`  | Fetch a specific blog post by ID            |
| `POST`   | `/blogs`       | Create a newly mapped blog post             |
| `PUT`    | `/blogs/{id}`  | Update an existing blog post entirely       |
| `DELETE` | `/blogs/{id}`  | Remove a specific blog post by ID           |

## Swagger UI

Once the application is running, you can access the Swagger UI directly to interact with and test the API endpoints. Open your browser and navigate to:
`http://localhost:8080/swagger-ui/index.html`

## Building and Running

You can start the project easily using the included Maven wrapper. 

First, ensure your database connection details inside `src/main/resources/application.properties` are properly set.

Using Windows:
```shell
.\mvnw.cmd clean package
.\mvnw.cmd spring-boot:run
```

Using Unix/macOS:
```shell
./mvnw clean package
./mvnw spring-boot:run
```
