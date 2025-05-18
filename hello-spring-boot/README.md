# Hello Spring Boot Example 👋

The `hello-spring-boot` project is a basic Spring Boot application that demonstrates core features of the Spring Boot framework, exploring RESTful web services using Spring Boot.

## Key Features at a Glance

Here’s a quick overview of what this simple project demonstrates:

- 🚀 **Spring Boot Setup**: Minimal configuration using `@SpringBootApplication` to bootstrap the application.
- 🌐 **RESTful Web Service**: Uses `@RestController` to expose basic endpoints.
- 🛠️ **Auto Configuration**: Leverages Spring Boot's opinionated defaults for faster development.

## REST API

`HelloController`: A simple controller that responds to HTTP GET requests.

### Endpoints

- `GET /` → Returns a welcome message with basic usage instructions.
- `GET /hello` → Returns a personalized greeting message.  
  *(Manually append `/hello` to the URL to test.)*

## Application Configuration

### application.properties

```properties
# Name of the Spring Boot application 
spring.application.name=hello-spring-boot

# Server will start on port 8080 (default, but we can set explicitly as well)
server.port=8080

```

This sets up the application's name and default port.

## Spring Boot Features Used

  -  @SpringBootApplication to bootstrap the app with minimal setup
  -  @RestController and @GetMapping to expose simple endpoints
  -  application.properties for basic configuration
