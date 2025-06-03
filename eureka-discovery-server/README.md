# Spring Cloud Eureka Discovery Server 🌐 

This project sets up a `spring-cloud-eureka-server`, which acts as a **service registry** in a microservices architecture. It enables services to **register themselves** and **discover other services** dynamically without hardcoding service URLs.

---

## What is Eureka Discovery Server? ⚡ 

**Eureka Server** is a service discovery tool developed by Netflix and integrated into the Spring Cloud ecosystem. It plays a critical role in microservices by providing a **central registry** where services can **register** and **discover** each other.

---


## Key Features ✨ 

- **Service Registry** – Stores a list of all registered services.
- **Dynamic Updates** – Automatically adds or removes services as they start or stop.
- **Health Checks** – Monitors if services are up and running.
- **Fault Tolerance** – Routes traffic to healthy service instances if one fails.
- **Loose Coupling** – Services can find each other without hardcoded locations.
- **Admin UI** – Web interface to view all registered services and their status.

---

## Eureka Server Setup (Spring Boot) ⚙️ 

### 1. Add Maven Dependency

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```
  -  Make sure to include the Spring Cloud BOM in your <dependencyManagement> section.

---

### 2. Enable Eureka Server

```java

@SpringBootApplication
@EnableEurekaServer  // Enabling Eureka Server functionality
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
```

---

### 3. Configure application.properties

```properties
# Application name for Eureka Server
spring.application.name=eureka-discovery-server

# Port on which Eureka Server will run
server.port=8761

# This is a Eureka Server, so it should not fetch the registry
eureka.client.fetch-registry=false

# Eureka Server should not register itself
eureka.client.register-with-eureka=false

# Default zone where other services will register (points to this Eureka instance)
eureka.server.service-url.defaultZone=http://localhost:8761/eureka/
```

---

## How Eureka Server Works  
  -  Registration: Microservices register themselves with Eureka using the defaultZone URL.
  -  Discovery: Clients can look up services via Eureka using the service ID.
  -  Heartbeats: Registered services send heartbeats to remain in the registry.

---

## Running the Server

1.Build the project using Maven:

```bash
mvn clean install
```
2. Run the Spring Boot application:

```
mvn spring-boot:run
```
3. Access Eureka dashboard at:

```
http://localhost:8762/
```

---

## Conclusion ✅ 

With Eureka Discovery Server in place, microservices can dynamically discover each other, enabling resilient, scalable, and loosely coupled systems in a microservices architecture. 
