# **Zuul API Gateway Server** 🌐

Zuul is an API Gateway developed by Netflix, which acts as a single entry point for routing client requests to various microservices. It provides features like routing, monitoring, security, and load balancing, acting as a mediator between the client and backend services.

---

### **Key Features** ✨ 
- **Dynamic Routing**: Zuul routes incoming requests to the appropriate microservice based on configuration.
- **Security**: It provides a layer of security for the microservices, including authentication and authorization.
- **Load Balancing**: Zuul can distribute client requests across multiple instances of a service, enhancing scalability and reliability.
- **Monitoring and Logging**: Tracks and logs all requests and responses, offering visibility into system performance and issues.
- **Dynamic Routing**: Zuul dynamically routes requests to different services based on the request's path, enabling seamless interaction with microservices without hardcoded service locations.
- **Centralized Management**: Zuul simplifies managing API endpoints and request routing for the client, reducing the complexity of frontend communication with microservices.

---

## How It Works ⚙️ 
1. **Request Forwarding**: Zuul intercepts incoming HTTP requests and forwards them to the target service based on the configuration.
2. **Service Discovery Integration**: Zuul integrates with Eureka Server to dynamically route requests to registered services, ensuring up-to-date information on available services.
3. **Load Balancing**: Through integration with Ribbon, Zuul can distribute requests to different instances of a service, improving load distribution and fault tolerance.
4. **Filters**: Zuul uses filters to handle pre-routing, post-routing, error handling, and security logic, offering flexibility in request processing.

---

### **Setup in Spring Boot**
1. Add the dependency:
   ```xml
   <dependency>
       <groupId>org.springframework.cloud</groupId>
       <artifactId>spring-cloud-starter-netflix-zuul</artifactId>
   </dependency>
   ```
2. Enable Zuul Server:
   ```java
   @SpringBootApplication
   @EnableZuulProxy
   public class ZuulServerApplication {
       public static void main(String[] args) {
           SpringApplication.run(ZuulServerApplication.class, args);
       }
   }
   ```
3. Configure the application in application.properties
   
    ```
    #Setting the server port for the Zuul Gateway
    server.port=8763
    
    #The application name for the Zuul Gateway
    spring.application.name=zuul-gateway
    
    #Eureka server URL for the Zuul Gateway to register with Eureka
    eureka.client.service-url.defaultZone=http://localhost:8762/eureka/
    
    #Define the route for the "adm" service, pointing to a specific URL or service in the system
    #Uncomment and update the routes below as per your services (eg.)
    #zuul.routes.adm.url=http://localhost:8081  # If you want to route traffic to a specific URL  
    #zuul.routes.adm.service-id=admission  # If the "admission" service is registered in Eureka
    ```

---

## Summary

- **Zuul API Gateway** serves as the entry point for client requests, handling routing and forwarding requests to the appropriate microservices.
- This setup ensures a **scalable**, **fault-tolerant**, and **efficient** microservices architecture, with **centralized service discovery** (Eureka) and **dynamic request routing** (Zuul).
- In Microservices register with the **Eureka Discovery Server**, and the **Zuul API Gateway** dynamically routes requests to these services based on the client’s request.
