# 🚀 Spring Boot Filter Example

This project example demonstrates how to use **Servlet Filters** in a Spring Boot application with two use cases:

- ✅ `SimpleFilter` — Logs incoming request info (IP and Host).
- ✅ `AuthLoggingFilter` — Logs and secures endpoints using a basic token-based authorization.

---

---

## 🔍 What is a Filter?

A **filter** is a reusable component in the Java Servlet API used to:
- Intercept incoming requests
- Modify request or response objects
- Perform logic like logging, authentication, or request validation

---

## 🗺️ Where Do Filters Apply?

In a Spring Boot app, filters apply at the **Servlet layer**, before your `@Controller` or `@RestController` handles the request.

Filters can be:
- Registered automatically using `@Component`
- Registered manually with `FilterRegistrationBean` for fine-grained control

---

## ⚙️ How to Use Filters in Spring Boot?

1. Create a class that implements `javax.servlet.Filter` (or `jakarta.servlet.Filter`)
2. Override `doFilter()` to define logic
3. Register using `@Component` or programmatically

---

## 🧪 Filters in This Project

### ✅ `SimpleFilter`

Logs the remote host and IP address of every incoming request.

```java
@Component
public class SimpleFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(SimpleFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        logger.info("Remote Host: {}", request.getRemoteHost());
        logger.info("Remote Address: {}", request.getRemoteAddr());
        chain.doFilter(request, response);
    }
}
```
## 🧠 When to Use Filters

Use filters when you need:

- 🔍 **Global request pre-processing** (e.g., logging, header modification, IP tracking)
- 🔐 **Authentication/authorization** across endpoints (e.g., API token checks, session validation)
- 🔄 **Cross-cutting logic** that applies to all or specific URL patterns (e.g., CORS setup, compression, metrics)

## 📘 References

- [Spring Boot Docs – Filters](https://docs.spring.io/spring-boot/docs/current/reference/html/web.html#web.servlet.filters)
