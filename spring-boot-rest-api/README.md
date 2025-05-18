# Spring Boot REST API Example 🌐

The `spring-boot-rest-api` project demonstrates how to build a basic RESTful API using Spring Boot, enabling simple user management operations through HTTP.

## Key Features
This project highlights the fundamentals of building a REST API:

- 📦 **REST API Setup**: Implements an endpoint for adding users via HTTP POST.
- 🧑‍💻 **UserController**: Handles incoming API requests and manages in-memory data storage.
- 🧾 **Model Class (`User`)**: A simple Java class with user properties.
- 🧪 **Postman Testing**: Easily test the API using Postman or any REST client.

## REST API

`UserController`: A REST controller that accepts and processes user data.

### Endpoint

- `POST /api/user/addUser`  
  → Accepts a JSON payload representing a `User`, validates it, and returns an appropriate HTTP response.

### Response Handling

- Uses `ResponseEntity` to return:
  - ✅ `201 Created` for successful user addition
  - ❌ `400 Bad Request` for invalid input
- Stores user data in an in-memory `List<User>` to simulate a basic storage mechanism.

## Model Class

`User`: Represents the user entity with the following fields:

```java
id, name, email, mobile;
```
## Example API Request

To test using Postman:

`URL: http://localhost:8080/api/user/addUser`

Method: `POST`

Headers:

`Content-Type: application/json`

Body : json

```
{
  "id": 1,
  "name": "killerexpertise",
  "email": "killerexpertise@gmail.com",
  "mobile": "1234567890"
}
```
