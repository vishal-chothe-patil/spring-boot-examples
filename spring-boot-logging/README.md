# Spring Boot Logging Example 📝

The `spring-boot-logging` project demonstrates how to implement logging in a Spring Boot application using SLF4J with the default Logback logging framework.

## Key Features 

Here’s what this project illustrates:

- 📄 **Logger Integration**: Utilizes `Logger` and `LoggerFactory` to log messages at multiple levels.
- 🌐 **RESTful Logging Endpoint**: Exposes an endpoint `/logs/test` to trigger logs at various severity levels.
- ⚙️ **Configurable Logging Levels**: Customize log levels and patterns via `application.properties`.

## REST API

`LogController`: A simple REST controller to test and trigger log messages at different levels.

### Endpoint

- `GET /logs/test` → Triggers log messages at `TRACE`, `DEBUG`, `INFO`, `WARN`, and `ERROR` levels to demonstrate behavior.

## Log Levels Explained

| Level   | Description                                                                 |
|---------|-----------------------------------------------------------------------------|
| `TRACE` | Extremely fine-grained information used for diagnostics during development. |
| `DEBUG` | Helpful during debugging to understand internal state and application flow. |
| `INFO`  | Standard log level for general application events (e.g., startup/shutdown). |
| `WARN`  | Indicates something unexpected, but not an error. App continues running.     |
| `ERROR` | Severe problems that might prevent parts of the application from functioning.|

## Application Configuration

### application.properties

```properties
# Set the logging level
logging.level.root=INFO

# To test all levels including DEBUG and TRACE, use:
# logging.level.root=TRACE

# Optional: Customize the console log pattern
# logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss} - %msg%n

```

## Spring Boot Features Used

  - @RestController and @GetMapping for creating endpoints
  - SLF4J Logger and LoggerFactory for log management
  - Logback as the default logging backend
  - Profile-independent logging configuration via application.properties
