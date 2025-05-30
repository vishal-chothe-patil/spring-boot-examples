# Spring Boot REST API Example 🌐

This is a simple **Spring Boot REST API** example for managing users with basic CRUD operations using an in-memory data store (Java `List` in Service). It's ideal for to understand RESTful services, controller-service separation, and basic Spring Boot setup.

---

## How to Use: REST API - Step-by-Step Summary 📌 

### 1. Create Spring Boot Project
- Use **Spring Initializr**
- Add dependencies: `Spring Web`, `Lombok`

### 2. Define Packages
- Create the following packages:
  - `controller`
  - `model`
  - `service`
  - `service.impl`

### 3. Create Model – `User.java`
- Define fields:
  - `id`
  - `name`
  - `email`
  - `mobile`

### 4. Create Service Layer
- Create `UserService` interface with CRUD method signatures
- Implement `UserServiceImpl` class using in-memory `List<User>` to store data

### 5. Create Controller
- Create `UserController` class with REST endpoints:
  - `POST /addUser` – Add a new user
  - `GET /getAllUser` – Get all users
  - `GET /{id}` – Get user by ID
  - `PUT /update/{id}` – Update user completely
  - `PATCH /partialUpdate/{id}` – Partially update user
  - `DELETE /{id}` – Delete user by ID

### 6. Run the App
- Start the app using the `main` method in your Spring Boot application class
- Use **Postman** or browser to test the endpoints:
  - Base URL: `http://localhost:8080/api/users`

---

## API Endpoints 🧾 

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST   | `/api/users/addUser` | Add a new user |
| GET    | `/api/users/getAllUser` | Retrieve all users |
| GET    | `/api/users/{id}` | Get a single user by ID |
| PUT    | `/api/users/update/{id}` | Update the entire user |
| PATCH  | `/api/users/partialUpdate/{id}` | Update partial fields of a user |
| DELETE | `/api/users/{id}` | Delete user by ID |

---

## Tech Stack ⚙️ 
  -  Spring Boot (REST API)
  -  Spring Web
  -  Lombok
  -  Java 17
  -  No external database (in-memory List<User> for simplicity)

---

## Sample User JSON 🧑‍💻 

```json
{
  "id": 1,
  "name": "KillerExpertise",
  "email": "killerexpertise@example.com",
  "mobile": "9876543210"
}
```
