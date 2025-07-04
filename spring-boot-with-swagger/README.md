# Spring Boot with Swagger Example 🧾🚀

This project demonstrates that the integration of `Swagger (OpenAPI)` into a `Spring Boot` REST API. It includes basic CRUD-like endpoints using an in-memory store (`Map`) and generates interactive API documentation using SpringDoc OpenAPI.

---

## 📘 What is Swagger?

**Swagger (OpenAPI)** is a set of tools and specifications for documenting RESTful APIs. It generates interactive API documentation where developers can:
- Visualize endpoints
- Send requests from UI
- Understand request/response formats
- Share APIs easily with teams

---

## Why Use Swagger ❓ 

- Auto-generates and updates API docs
- Enables live testing via Swagger UI
- Increases productivity for frontend/backend devs
- Enhances clarity of API contracts
- Reduces need for manual documentation

---

## How to Use / Setup 🛠️ 

### 1. Clone the Repository

  ```bash
  git clone https://github.com/vishal-chothe-patil/spring-boot-with-swagger.git
  cd spring-boot-with-swagger
  ```

### 2. Add Required Dependencies in pom.xml

  ```xml
  <!-- Spring Boot Web -->
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
  </dependency>
  
  <!-- SpringDoc OpenAPI (Swagger UI) -->
  <dependency>
      <groupId>org.springdoc</groupId>
      <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
      <version>2.2.0</version>
  </dependency>
  ```

### 3. SwaggerConfig file (Optional)

  ```
  @Configuration
  public class SwaggerConfig {
  
      @Bean
      public OpenAPI apiInfo() {
          return new OpenAPI()
                  .info(new Info()
                          .title("Book API")
                          .description("API documentation for book management.\n\n Developed by KillerExpertise — feel free to reach out. ⚠\uFE0F")
                          .version("1.0.0")
                          .contact(new Contact()
                                  .name("Vishal Chothe")
                                  .email("vishalchothe134@gmail.com")
                                  .url("https://github.com/vishal-chothe-patil")));
      }
  }
  ```
---

## Access Swagger UI

After starting the application, open the following URL in your browser to access the Swagger UI:

  ```
  http://localhost:8080/swagger-ui.html
  ```

   or
  
  ```  
  http://localhost:8080/swagger-ui/index.html
  ```

---

## API Endpoints

| Method | Endpoint                 | Description         |
|--------|--------------------------|---------------------|
| POST   | `/api/books/add`         | Add a new book      |
| GET    | `/api/books/get/{id}`    | Get a book by ID    |
| GET    | `/api/books/all`         | Get all books       |
| DELETE | `/api/books/delete/{id}` | Delete a book by ID |


---

## Sample JSON for Adding a Book

Use the following JSON structure to test the POST `/api/books/add` endpoint:

  ```json
  {
    "title": "Effective Java",
    "author": "Joshua Bloch"
  }
  ```
---

## Project Summary 📝 

This project demonstrates how to integrate **Swagger (OpenAPI)** into a basic **Spring Boot** RESTful API. It showcases a simple `BookController` with in-memory data storage using a `Map` and provides endpoints to add, fetch, list, and delete books.

The Swagger UI is automatically generated using **SpringDoc OpenAPI** and offers an interactive way to explore and test the API. 
  -   how to document and test APIs effectively using Swagger in a Spring Boot application.
