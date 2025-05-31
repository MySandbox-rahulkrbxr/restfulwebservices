# RESTful Web Services with Spring Boot - A Comprehensive Social Media API

This project implements a robust RESTful web service using Spring Boot that provides social media functionality with user management, post handling, API versioning, and internationalization support. The service includes security features, database integration, and comprehensive API documentation.

The application demonstrates Spring Boot best practices and includes advanced features like HATEOAS (Hypermedia as the Engine of Application State), custom exception handling, and response filtering. It supports both in-memory and MySQL database operations, making it suitable for both development and production environments.

Key features include:
- User and Post management with JPA/Hibernate persistence
- API versioning with multiple strategies (URI, Parameter, Header, and Media Type)
- Basic authentication security
- Internationalized responses
- Custom exception handling
- Response filtering
- OpenAPI documentation
- Actuator endpoints for monitoring

Restful Web Services using Spring Boot.

## Resources and URI Mappings

### Standard API Endpoints
- Retrieve all Users - **GET /users**
- Create a User - **POST /users**
- Retrieve one User - **GET /users/{id}** -> /users/1
- Delete a User - **DELETE /users/{id}** -> /users/1

### JPA API Endpoints
- Retrieve all Users - **GET /jpa/users**
- Create a User - **POST /jpa/users**
- Retrieve one User - **GET /jpa/users/{id}** -> /jpa/users/1
- Delete a User - **DELETE /jpa/users/{id}** -> /jpa/users/1
- Retrieve all posts for a User - **GET /jpa/users/{id}/posts**
- Create a posts for a User - **POST /jpa/users/{id}/posts**

## Repository Structure
```
.
├── src/main/java/com/rahul/resetfulwebservices/
│   ├── ResetfulWebServicesApplication.java    # Application entry point
│   ├── exception/                             # Custom exception handling
│   ├── filtering/                             # Response filtering implementation
│   ├── helloworld/                            # Basic endpoint implementations
│   ├── jpa/                                   # JPA repositories
│   ├── security/                              # Security configuration
│   ├── user/                                  # User and Post domain models and controllers
│   └── versioning/                            # API versioning implementations
├── src/main/resources/
│   ├── application.properties                 # Application configuration
│   ├── data.sql                              # Database initialization
│   └── messages_*.properties                  # Internationalization files
├── pom.xml                                    # Maven project configuration
└── mvnw, mvnw.cmd                            # Maven wrapper scripts
```

## Usage Instructions
### Prerequisites
- Java 21
- Maven 3.x (or use included Maven wrapper)
- MySQL 8.0 (for production mode)
- Docker (optional, for running MySQL in container)

### Installation

#### 1. Clone the repository
```bash
git clone <repository-url>
cd resetfulwebservices
```

#### 2. Configure the database

For MySQL (Production):
```bash
##### Start MySQL container
docker run --detach \
  --env MYSQL_ROOT_PASSWORD=dummypassword \
  --env MYSQL_USER=social-media-user \
  --env MYSQL_PASSWORD=dummypassword \
  --env MYSQL_DATABASE=social-media-database \
  --name mysql \
  --publish 3307:3306 \
  mysql:8-oracle
```

#### 3. Build and run the application
```bash
# Using Maven wrapper
./mvnw clean install
./mvnw spring-boot:run

# Or using Maven directly
mvn clean install
mvn spring-boot:run
```

### Quick Start

1. Access the API documentation:
```
http://localhost:8080/swagger-ui.html
```

2. Basic authentication credentials:
```
username: username
password: password
```

3. Create a new user:
```bash
curl -X POST http://localhost:8080/jpa/users \
  -H "Content-Type: application/json" \
  -u username:password \
  -d '{"name":"John Doe","birthDate":"2000-01-01"}'
```

### More Detailed Examples

1. Get all users:
```bash
curl -X GET http://localhost:8080/jpa/users -u username:password
```

2. Create a post for a user:
```bash
curl -X POST http://localhost:8080/jpa/users/1/posts \
  -H "Content-Type: application/json" \
  -u username:password \
  -d '{"description":"My first post!"}'
```

3. Get user posts:
```bash
curl -X GET http://localhost:8080/jpa/users/1/posts -u username:password
```

### Troubleshooting

1. Database Connection Issues
- Error: "Cannot connect to MySQL database"
  ```
  - Verify MySQL container is running: docker ps
  - Check connection properties in application.properties
  - Ensure port 3307 is available
  ```

2. Authentication Issues
- Error: "401 Unauthorized"
  ```
  - Verify credentials in application.properties
  - Check if Basic Auth header is properly formatted
  ```

3. JPA Issues
- Error: "Table doesn't exist"
  ```
  - Verify database initialization: check data.sql execution
  - Ensure hibernate.ddl-auto is set to "update"
  ```

## Data Flow
The application follows a layered architecture with clear separation of concerns.

```ascii
Client Request → Security Filter → Controller → Service → Repository → Database
     ↑                                                                    ↓
     └────────────────── Response ←────────────────────────────────────←─┘
```

Component interactions:
1. All requests pass through Spring Security for authentication
2. Controllers handle request mapping and validation
3. Service layer implements business logic
4. Repository layer handles data persistence
5. JPA/Hibernate manages database operations
6. Custom exception handlers manage error responses
7. Response filtering applies before sending data to client


### Database Resources
- MySQL Database Container
  - Port: 3307
  - Database: social-media-database
  - User: social-media-user
  - Password: dummypassword

### Tables
1. user_details
	- id (Primary Key)
	- name
	- birth_date

2. post
	- id (Primary Key)
	- user_id (Foreign Key)
	- description

### Sequences
- post_seq: Generates IDs for posts
- user_details_seq: Generates IDs for users