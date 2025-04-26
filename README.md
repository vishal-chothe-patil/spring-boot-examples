# spring-boot-examples ⚙️📊

This `spring-boot-examples` repository demonstrates Spring Boot concepts including Auto-Configuration, Starter Dependencies (Web, DevTools), Embedded Servers (Tomcat), RESTful APIs, and Logging with SLF4J.

---

## Project Architecture 📂

### hello-spring-boot Example

The `hello-spring-boot` project is a simple Spring Boot application that demonstrates basic Spring Boot features, including:

- **Basic Spring Boot Application Setup**: A simple `@SpringBootApplication` to get started with Spring Boot.
- **RestController**: A basic RESTful controller to handle requests and return greetings.
- **Simple Endpoints**: Demonstrates two simple endpoints:  
  - `/` → Shows a welcome message with instructions  
  - `/hello` → Manually add in the URL to view the personalized greeting

---

### spring-boot-logging Example

The `spring-boot-logging` project demonstrates logging in Spring Boot using SLF4J with the default Logback implementation:

- **Logger Integration**: Uses `Logger` and `LoggerFactory` to log messages at different levels.
- **RESTful Controller**: Exposes an endpoint `/logs/test` to trigger logs at various levels (TRACE, DEBUG, INFO, WARN, ERROR).
- **Log Message Meaning**:
  - `TRACE` →  Detailed debug info, typically used for diagnosing specific issues during development, usually for developers.
  - `DEBUG` → Useful for debugging, shows application state and flow.
  - `INFO` → General app events (startup, shutdown, or configuration updates.
  - `WARN` → Something unexpected happened, but the application is still running fine.
  - `ERROR` → Serious issues that may affect functionality.
- **Configurable Log Levels**: Log output can be easily adjusted through the `application.properties` file.
```
   - # Set the logging level
    - # Only show logs of level INFO and above (INFO, WARN, ERROR)
      - logging.level.root=INFO

    - # Or to test all levels including DEBUG and TRACE:
      - #logging.level.root=TRACE

  - # Log pattern (optional)
      - # logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss} - %msg%n
```
---

### spring-boot-rest-api Example

The `spring-boot-rest-api` project demonstrates how to build a basic RESTful API using Spring Boot:

- **REST API Setup**: Implements a simple REST API to perform basic user operations.
- **UserController**:  
    - Handles HTTP POST requests at `/api/users/addUser`.
    - Accepts a JSON `User` object and responds with a success message.
- **Model Class (`User`)**:  
    - Represents a simple Java object containing fields like `id`, `name`, `email`, and `mobile`.
- **Postman Testing**:  
    - The API can be tested using Postman by sending a `POST` request with JSON payload.

 **Example API Call**:
    - **URL**: `http://localhost:8080/api/users/addUser`
    - **Method**: `POST`
    - **Headers**: `Content-Type: application/json`
  - **Body**:
``` json
{
  "id": 1,
  "name": "Vishal",
  "email": "vishal@gmail.com",
  "mobile": "8698720310"
}

```
- **Spring Boot Features Used**:
    - `@SpringBootApplication` for application configuration.
    - `@RestController`, `@PostMapping`, and `@RequestBody` for building REST APIs.
    - Embedded Tomcat server (runs on port 8080 by default).

---
