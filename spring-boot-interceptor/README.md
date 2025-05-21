# Spring Boot Interceptor Example 🚦

This project example demonstrates how to implement and use **Spring Boot Interceptors** to intercept HTTP requests and responses in a Spring Boot web application.

---

## What is an Interceptor? 🔍

An **Interceptor** in Spring MVC is a powerful mechanism to intercept incoming HTTP requests and outgoing responses before they reach the controller or after the controller processes them. Interceptors are useful for cross-cutting concerns such as logging, authentication, authorization, and more.

---

## Why Use Interceptors? ⚙️

- 📝 Logging request data (URI, HTTP method, client IP) for auditing and debugging  
- 🔐 Implementing authentication or authorization checks globally  
- 🔄 Modifying request or response objects before or after controller processing  
- ⏱ Measuring performance or execution time of requests  

---

## When to Use Interceptors 🧠

Use interceptors when you need:

- 🌐 Cross-cutting logic that applies to many or all endpoints  
- 🔄 Pre-processing or post-processing around controller methods  
- 🚀 Global request handling without modifying controller code  

---

## How to Use 🚀

1. Implement a class that extends `HandlerInterceptor` and override desired methods:
   - `preHandle()` — runs before the controller  
   - `postHandle()` — runs after the controller but before view rendering  
   - `afterCompletion()` — runs after view rendering, useful for cleanup  

2. Register your interceptor in a configuration class that implements `WebMvcConfigurer` and override `addInterceptors()`.

3. Define your controllers as usual.

4. Run the Spring Boot application.

---

## Sample Code: LoggingInterceptor.java 💻

```java
package com.killerexpertise.example.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoggingInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        logger.info("Incoming request data -> URI: {}, Method: {}, IP: {}",
                request.getRequestURI(),
                request.getMethod(),
                request.getRemoteAddr());
        return true;  // continue processing the request
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           org.springframework.web.servlet.ModelAndView modelAndView) throws Exception {
        logger.info("Handler executed, preparing to render view");
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) throws Exception {
        logger.info("Request completed");
        if (ex != null) {
            logger.error("Exception occurred: ", ex);
        }
    }
}
```


## References 📘

- [Spring Boot Documentation – Interceptors](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-handlerinterceptor)
