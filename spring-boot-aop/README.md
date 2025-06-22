# Spring Boot Aspect-Oriented Programming (AOP) Example 📦 

This project demonstrates the use of **Aspect-Oriented Programming (AOP)** in a Spring Boot application to implement centralized **method-level logging** using `@Before`, `@After`, and `@AfterReturning` advices.

It uses the **SLF4J Logger** to log method invocations in the service layer, offering clean separation of concerns for cross-cutting concerns like logging.

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


---


---

## AOP Logging Details

### Logging Aspect: `LoggingAspect.java` ✅ 
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
---

