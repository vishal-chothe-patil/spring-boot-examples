# spring-boot-thymeleaf example 🖥️🚀 

A simple `Employee Management System` built with Spring Boot, and Thymeleaf. It allows users to add and view employee records with fields like name, email, department, designation, and salary through a web interface.

---

## What is Thymeleaf? ❓ 

**Thymeleaf** is a modern server-side Java template engine for Java-based web and standalone applications.  
It allows you to create dynamic web pages with natural templating syntax, easily integrated into Spring Boot projects.

-  Server-side rendering of HTML views  
-  Natural templating: templates can be opened as static files in browsers without a server  
-  Supports form binding, conditional rendering, iteration, internationalization, and more  
-  Designed to work seamlessly with Spring MVC and Spring Boot

---

##  Why use Thymeleaf? 🎯

  - **Clean and intuitive HTML templates**: Easy for frontend and backend developers to collaborate  
  - **Full integration with Spring Boot**: Works out of the box with Spring MVC model attributes  
  - **No JavaScript dependencies**: Server renders the complete page before sending to the client  
  - **Supports form submission and validation** directly in templates  
  - **Better developer experience** with natural templates that look like HTML

---

## How Thymeleaf is used in this project? ⚙️ 

This project `spring-boot-thymeleaf` demonstrates a basic Employee Management app with the following:

  - **Model**: `Employee` entity with 5 fields (`id`, `name`, `email`, `department`, `designation`, `salary`)  
  - **Repository**: Spring Data JPA interface to perform CRUD operations  
  - **Service Layer**: Business logic for saving and retrieving employees  
  - **Controller**: Spring MVC controller that serves Thymeleaf templates  
  - **Views**: Thymeleaf HTML templates (`create-employee.html` and `list-employees.html`)    
  - **Form Binding**: Employee creation form binds directly to the Employee model object  
  - **View Rendering**: List all employees dynamically rendered with Thymeleaf iteration  
  - **Database**: MySQL used for persistence

---

##  Features 🔥

- Create new employee with a web form  
- View all employees in a tabular format  
- Data stored in MySQL using Spring Data JPA  
- Clean UI rendered by Thymeleaf templates  

---


## Technologies Used 🛠️ 

| Technology         | Purpose                        |
|--------------------|--------------------------------|
| Spring Boot        | Application framework          |
| Spring MVC         | Web framework                  |
| Thymeleaf          | Server-side templating engine  |
| Spring Data JPA    | ORM and database access        |
| Lombok             | Boilerplate code reduction     |
| MySQL              | Relational database            |

---

##  Running the Project 🚀

1. Clone this repo  
2. Create a MySQL database named `employee_management_db`  
3. Update your `application.properties` with correct DB credentials
4. Run the application using:
   ``` 
   mvn spring-boot:run
   ```
5. Open in browser:
   
     -  http://localhost:8080/ - View employee list
     -  http://localhost:8080/employee-form - Add new employee

---

## Summary: ⚡

Use of Thymeleaf in Spring Boot

  1. Create a Spring Boot project with dependencies: Web, Thymeleaf, JPA, MySQL, Lombok.  
  2. Configure MySQL database connection in `application.properties`.  
  3. Define your JPA entity class (e.g., `Employee`) with fields and Lombok annotations.  
  4. Create a Spring Data JPA repository interface for database operations.    
  5. Implement service layer to handle business logic for CRUD methods.  
  6. Build a Spring MVC controller to serve Thymeleaf views and process form data.  
  7. Create Thymeleaf HTML templates with form binding and data iteration.  
  8. Run the application and open the browser at `http://localhost:8080/`.  
  9. Use the UI to add and view employees via Thymeleaf-rendered pages.

