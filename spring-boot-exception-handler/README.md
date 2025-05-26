# Spring Boot Exception Handler Example ⚙️🌐

This project demonstrates how to implement **centralized exception handling** in a Spring Boot application using `@ControllerAdvice`, `@ExceptionHandler`, and custom exceptions.

---

## What is Exception Handling? ❓ 

Exception handling is the process of responding to unexpected events or errors during application execution (like a missing customer, invalid input, etc.). Instead of crashing or showing a stack trace, we respond with a structured and meaningful message.

---

## Why Use Global Exception Handling? 🎯 

-  Centralized error management
-  Clean and readable controller/service layers
-  Proper HTTP status codes (404, 400, 500, etc.)
-  User-friendly and consistent error responses
-  Better debugging and maintainability

---

## How It Works (Step-by-Step) ⚙️

### 1. Service Layer: Detect and Throw Custom Exception

When the requested customer is not found, we throw a custom exception:

```java
@Override
public Customer getById(Long id) {
    return customerRepository.findById(id)
            .orElseThrow(() -> new CustomerNotFoundException("Customer with ID " + id + " not found"));
}
```
### 2. Custom Exception: CustomerNotFoundException

A simple runtime exception class:
```
public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
```
  -  This makes the exception unchecked.

### 3. Exception Propagation to Controller

The controller calls the service method. If the service throws CustomerNotFoundException, it’s not caught in the controller and is instead propagated to Spring's exception resolution mechanism.

### 4. Global Exception Handler: @ControllerAdvice

We handle exceptions centrally using a global handler:

```
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleCustomerNotFoundException(CustomerNotFoundException ex) {
        ApiResponse<String> response = new ApiResponse<>(ex.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    // Other exception handlers can be added here
}
```

  - Catches the exception.

  - Builds a custom response object.

  - Returns HTTP status 404 (Not Found).

### 5. Response Format

The client receives a well-structured JSON response:

```
{
  "message": "Customer with ID 10 not found",
  "data": null
}
```
Along with:
  -  HTTP 404 Not Found status

  -  Helpful error message

  -  Consistent format across errors


