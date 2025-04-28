# Spring Boot Profile Example 🏷️

The `spring-boot-profile` project demonstrates how to use Spring Profiles to manage environment-specific configurations and implement different behaviors for various profiles like `dev`, `test`, and `prod`.

## Profile Use Cases at a Glance
  Here’s a quick overview of when and why to use each profile:

  -  🛠️ **Dev Profile (dev)**: "Local development with verbose logging and fast in-memory storage"

  -  🧪 **Test Profile (test)** "Automated testing with mock data and trace-level debugging"

  -  🏭 **Prod Profile (prod)**: "Production deployment with database persistence and optimized settings"
## Profile-Specific Configuration

The project includes separate configurations for different profiles:
  - `Dev Profile (dev)`: Logs user details to console and simulates storage using a HashMap.
  - `Test Profile (test)`: Similar to dev, but intended for testing purposes with mock data stored in-memory.
  - `Prod Profile (prod)`: Simulates storing user data to a production database (in the example, uses an in-memory HashMap).

## UserService for Each Profile

- `DevUserServiceImpl`: Simulates adding a user in the development environment by logging to the console and storing the data in an in-memory HashMap.
- `TestUserServiceImpl`: Stores users in memory and simulates the behavior for test environments.
- `ProdUserServiceImpl`: Intended to represent the production environment, where user data might be saved to a database.

## REST API

`UserController`: Handles user creation requests and interacts with the `UserService` depending on the active profile.

### Endpoints

- `POST /users/add` → Accepts a POST request with a JSON User object to simulate adding users based on the active profile.
- `GET /users/all` → Retrieves all stored users for the active profile (Dev, Prod, Test).

## Profile-Specific Configuration in application.properties

### Base Configuration (`application.properties`)
```
# Application Settings
spring.application.name=spring-boot-profile
server.port=8080

# Default active profile (override with --spring.profiles.active)
spring.profiles.active=test
#We can change to prod to activate prod profile
```

### Dev Profile (`application-dev.properties`)

```properties
spring.profiles.active=dev
server.port=8081
logging.level.root=DEBUG
```

### Prod Profile (application-prod.properties)

```properties
spring.profiles.active=prod
server.port=8082
logging.level.root=INFO
```

### Test Profile (application-test.properties)

```properties
spring.profiles.active=test
server.port=8083
logging.level.root=TRACE
```

## Spring Boot Features Used
  -  @Profile annotation to bind services to different profiles
  -  @RestController, @PostMapping, and @RequestBody for building REST APIs
  -  Ability to configure different ports and log levels for different profiles using application-{profile}.properties
  -  Profile-specific beans to handle different environments

## Conclusion
Spring Profiles provide an efficient way to manage environment-specific configurations, enabling seamless transitions between development, testing, and production environments while maintaining consistent application behavior. This approach simplifies configuration management and ensures optimal settings for each deployment stage.

By implementing profile-based configuration, teams can:
  - Reduce environment-specific bugs
  - Streamline deployment processes
  - Maintain cleaner code organization
  - Improve overall application maintainability
