# Spring Boot + Spring Data JPA CRUD Example (with File Upload) ⚙️

This is a complete Spring Boot application demonstrating **CRUD (Create, Read, Update, Delete)** operations on a `Customer` entity using **Spring Data JPA** and **MySQL**. It also includes an additional feature for uploading and storing an Aadhar card as a byte array (`BLOB`) in the database.

---

##  What is Spring Data JPA? 📘

**Spring Data JPA** is part of the larger Spring Data family. It is an abstraction over JPA (Java Persistence API) and simplifies database access by reducing boilerplate code. It allows developers to work with databases using just interfaces and method naming conventions, without writing custom SQL or JPQL.

###  Why Use Spring Data JPA? ✅

- Eliminates boilerplate DAO code
- Built-in CRUD operations via `JpaRepository`
- Easy query creation via method names (`findByEmail`, `findAllByOrderByNameAsc`, etc.)
- Seamless integration with Spring Boot
- Paging and sorting built-in
- Supports both JPQL and native queries when needed

---
### How to Use - Spring Data JPA Summary 📂

1. **Add Dependencies**  
   Include `spring-boot-starter-data-jpa` and your database driver (e.g., MySQL) in your `pom.xml` or `build.gradle`.

2. **Configure Database Connection**  
   Set up database URL, username, password, and JPA properties in `application.properties` or `application.yml`.

3. **Create Entity Class**  
   Define your entity (e.g., `Customer`) using `@Entity` annotation with appropriate fields and primary key (`@Id`).

4. **Create Repository Interface**  
   Extend `JpaRepository<Entity, ID>` to get CRUD methods and query capabilities without implementation.

5. **Create Service Layer**  
   Define a service interface and implement it to call repository methods. This adds business logic between controller and repository.

6. **Create Controller Layer**  
   Build REST controllers to expose CRUD endpoints. Use the service layer to perform database operations.

7. **Run the Application**  
   Start your Spring Boot app and test the API endpoints. Spring Data JPA handles all database interactions transparently.

8. **File Upload Handling (If needed)**  
   For file fields (like Aadhar card), accept `MultipartFile` in controllers, convert to `byte[]`, and save in entity.

---

> This flow allows to build robust CRUD applications with minimal boilerplate code, leveraging Spring Data JPA’s powerful abstractions.

---


##  Features 🧩

- ✅ Add a new customer with Aadhar card upload
- ✅ Get all customers
- ✅ Get a customer by ID
- ✅ Update customer details (optionally update file)
- ✅ Delete customer by ID
- ❌ Error handling with custom exception (`CustomerNotFoundException`)
- 📝 API responses wrapped with a consistent format using `ApiResponse`

---

## Tech Stack 🚀

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL Database
- Multipart File Upload
- Lombok (optional for reducing boilerplate)
- Maven (for build)

---

## 🗃️ Entity Structure

### `Customer.java`
```java
private Long id;
private String name;
private String email;
private String mobile;
private String address;
private byte[] aadharCard; // stored as BLOB
```
---

## 📬 Sample API Request (POST)

Use **Postman** with `multipart/form-data` for creating a new customer with a file upload:

### 🔑 Form Data Example

| Key       | Value                                                                 |
|------------|------------------------------------------------------------------------|
| `customer` | `{"name": "Vishal", "email": "vishal@test.com", "mobile": "9999999999", "address": "Pune"}` |
| `file`     | _(Select a file from your local system)_                              |

- The `customer` field must be a **valid JSON string**.
- The `file` field is used to upload the customer's Aadhar card as a file.

> 📌 Ensure the request is set to `multipart/form-data` in Postman.

---


---

## ⚠️ Error Handling

- If a customer is not found by ID, a `CustomerNotFoundException` is thrown.
- You can implement **global exception handling** using `@ControllerAdvice` and `@ExceptionHandler` annotations for cleaner error responses and centralized error management.

```java
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleCustomerNotFound(CustomerNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>(ex.getMessage(), null));
    }

    // Add more handlers if needed
}
```

---

##  Project Summary 📁

This project is a **Spring Boot CRUD API** example that demonstrates how to manage `Customer` entities using **Spring Data JPA** and **MySQL**. It also includes **file upload support** (e.g., Aadhar card as a PDF or image) using `MultipartFile`.

###  Key Features: 🔧

- ✅ Full CRUD operations on `Customer` entity  
- 📤 File upload handling (Aadhar card stored as `byte[]`)  
- 🗃️ Uses **Spring Data JPA** to interact with MySQL database  
- 🎯 Clean RESTful API design with proper HTTP status codes  
- 🔁 Supports JSON + file upload using `multipart/form-data`  
- ⚠️ Custom exception handling with `CustomerNotFoundException`  
- 📦 Layered architecture: Controller → Service → Repository


