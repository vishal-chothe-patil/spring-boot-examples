# Spring Boot Actuator Example 📊 

This project example demonstrate that use of **Spring Boot Actuator** to monitor and manage a Spring Boot application with built-in and custom health checks.

---

##  What is Spring Boot Actuator? 

**Spring Boot Actuator** is a production-ready feature of Spring Boot that provides a set of REST endpoints to help you:
- Monitor application health
- Track metrics (memory, disk, GC, threads, etc.)
- View application info, beans, and environment properties
- Integrate with monitoring tools like Prometheus & Grafana

---

##  Why Use Spring Boot Actuator? 

Spring Boot Actuator makes it easy to:
- Monitor and manage your app in **production**
- Expose custom health checks (e.g., database status, external services)
- Improve **observability** without extra boilerplate
- Automate uptime/downtime alerts with integrations

---

## ⚙️ How to Use Actuator 

### 1. Add Dependencies 

```xml
<!-- pom.xml -->
<dependencies>
    <!-- Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Actuator -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
    <!-- Cache (optional) -->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-cache</artifactId>
   </dependency>
</dependencies>
```
---
## 2. Add Configuration 📝

Add the following to your `application.properties` file:

```properties
# application.properties

# Expose multiple endpoints
management.endpoints.web.exposure.include=info,health,loggers,metrics,mappings,env,caches

# Show full health details when accessed locally or with auth
management.endpoint.health.show-details=always

# Optional: change default context path for actuator
management.endpoints.web.base-path=/actuator

# Optional: Application info
info.app.name=Spring Boot Actuator Example
info.app.version=1.0.0
```
---

##  Custom Components need to undestand 

### Custom Health Indicator
**File:** `health/CustomHealthIndicator.java`  
Implements a custom health check by simulating the status of an external service and reporting it under the `/actuator/health` endpoint.

### Custom Info Contributor
**File:** `info/CustomInfoContributor.java`  
Adds custom metadata (like team name, owner, or environment) to the `/actuator/info` endpoint.

### Cache Metrics
**File:** `caches/CacheService.java`  
Simulates a simple in-memory cache. The size of the cache is exposed as a custom metric and can be viewed under `/actuator/caches`.

----

##  Which Are Actually Used in Production? 🎯

| Use Case                                  | Endpoint Used                    |
|-------------------------------------------|--------------------------------|
| Load balancer health check                 | `/actuator/health`              |
| Build info for monitoring tools            | `/actuator/info`                |
| App performance monitoring (Prometheus, Grafana) | `/actuator/prometheus`          |
| Memory and CPU diagnostics                  | `/actuator/metrics`, `/actuator/heapdump` |
| Debugging logging issues in production      | `/actuator/loggers`             |
| Investigating slow threads or deadlocks     | `/actuator/threaddump`          |
| Dynamic config/environment debugging         | `/actuator/env`, `/actuator/mappings` |

---

## 📚 Reference
 
🔗 [Spring Boot Actuator - Official Docs](https://docs.spring.io/spring-boot/docs/current/actuator-api/htmlsingle/)
