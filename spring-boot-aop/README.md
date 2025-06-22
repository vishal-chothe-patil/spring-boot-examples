# Spring Boot Aspect-Oriented Programming (AOP) Example 📦 

This project demonstrates the use of **Aspect-Oriented Programming (AOP)** in a Spring Boot application to implement centralized **method-level logging** using `@Before`, `@After`, and `@AfterReturning` advices.

It uses the **SLF4J Logger** to log method invocations in the service layer, offering clean separation of concerns for cross-cutting concerns like logging.

---

## What is AOP? 📘 

**AOP (Aspect-Oriented Programming)** is a programming paradigm that aims to isolate **cross-cutting concerns** (e.g., logging, security, transactions) from the core business logic. It allows you to **add behavior to methods without modifying their code**.

---

## Why Use AOP? ❓ 

  -  Clean separation of cross-cutting concerns (logging, security, auditing, etc.)  
  -  No duplication of logging logic in multiple places
  -  Easier maintenance and centralized control
  -  Improved readability and testability of business logic
  -  Dynamically plug in behaviors before or after method execution

---

## How to Use AOP in Spring Boot / Setup 🛠️

### 1: Add AOP Dependency in `pom.xml`

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```

### 2: Create an Aspect Class

#### Logging Aspect: `LoggingAspect.java` 
  ```java
  @Before("execution(* com.expertise.aop.example.service.*.*(..))")
  public void beforeServiceMethod(JoinPoint joinPoint) {
      logger.info("Before: {}", joinPoint.getSignature());
  }
  
  @After("execution(* com.expertise.aop.example.service.*.*(..))")
  public void afterServiceMethod(JoinPoint joinPoint) {
      logger.info("After: {}", joinPoint.getSignature());
  }
  
  @AfterReturning(pointcut = "execution(* com.expertise.aop.example.service.*.*(..))", returning = "result")
  public void afterReturning(JoinPoint joinPoint, Object result) {
      logger.info("Returned from: {} with result: {}", joinPoint.getSignature(), result);
  }
  ```

### 3: Annotate Your Spring Boot Application

Make sure our main class is annotated with @SpringBootApplication (default behavior already includes component scanning for @Aspect).

```java
@SpringBootApplication
public class SpringBootAopApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAopApplication.class, args);
    }
}
```

### 4: Run and Test

  -  Start your application
  -  Call a method in a @Service class (e.g., via controller)
  -  Observe the logs printed by the Aspect

---

## Technologies Used

| Tool / Framework     | Version      |
|----------------------|--------------|
| Java                 | 21           |
| Spring Boot          | 3.5.3        |
| Spring AOP           | 6.2.8        |
| Spring Data JPA      | 3.5.1        |
| Hibernate            | 6.6.18.Final |
| MySQL                | 8.x          |
| Maven                | Latest       |
| SLF4J (with Logback) | 2.0.17       |
