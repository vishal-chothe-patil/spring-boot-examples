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

