# Spring Boot + Spring Security Basic Auth Example 🔐

This is a simple example of using **Spring Boot** with **Spring Security** to protect REST API endpoints using **Basic Authentication** and **role-based access control**.

---

##  Features 📦

- ✅ Spring Boot with Spring Security  
- ✅ In-memory authentication  
- ✅ Role-based access for `USER` and `ADMIN`  
- ✅ Form-based login (browser)  
- ✅ Basic Auth support (Postman)  
- ✅ Endpoints secured by roles  

---

##  Users & Roles 🔐

| Username | Password   | Role  |
|----------|------------|-------|
| user     | userpass   | USER  |
| admin    | adminpass  | ADMIN |

---

##  API Endpoints 🌐

| Method | Endpoint    | Access Role     |
|--------|-------------|-----------------|
| GET    | `/welcome`  | USER / ADMIN    |
| GET    | `/user`     | USER / ADMIN    |
| GET    | `/admin`    | ADMIN only      |

---

##  Code Explanation 💡

### 🔧 `SecurityConfig.java`

This class configures Spring Security using in-memory authentication and sets up access rules for endpoints.

```java
package com.killerexpertise.auth.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails user = User.builder()
                .username("user")
                .password(encoder.encode("userpass"))
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(encoder.encode("adminpass"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/admin").hasRole("ADMIN")
                .requestMatchers("/user").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .defaultSuccessUrl("/welcome", true)
                .permitAll()
            )
            .logout(logout -> logout.permitAll())
            .csrf(csrf -> csrf.disable());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
````

---

📝 **Note:** CSRF is disabled to simplify testing via Postman and API clients. For production applications, CSRF should be enabled unless you're only building a stateless API with tokens like JWT.

---

## 🧪 Postman Testing: Basic Auth

###  1. Set Authorization 🔐

* Go to the **Authorization** tab in Postman
* **Type**: Basic Auth
* **Username**: `admin` or `user`
* **Password**: `adminpass` or `userpass`

---

### 🔍 2. Sample Requests

####  `/welcome` – Accessible by all authenticated users ✅

```http
GET http://localhost:8080/welcome
```

📤 Response:

```json
"Welcome to Spring Security Basic Auth Example!"
```

---

####  `/user` – Accessible by USER or ADMIN ✅

```http
GET http://localhost:8080/user
```

📤 Response (as user or admin):

```json
"Hello User! You have USER access."
```

---

#### `/admin` – Accessible by ADMIN only 🔒 

```http
GET http://localhost:8080/admin
```

📤 Response (as admin):

```json
"Hello Admin! You have ADMIN access."
```

📛 Forbidden (if using user credentials):

```json
{
  "timestamp": "...",
  "status": 403,
  "error": "Forbidden",
  "message": "Access Denied",
  "path": "/admin"
}
```

---

##  Troubleshooting ❓

###  403 Forbidden on `/admin` ❌

* Ensure you're logged in as **admin**
* Postman: Set correct **Basic Auth** credentials
* 🪵 View Spring Security logs by enabling:

---

## In application.properties
```
# Application name
spring.application.name=spring-boot-security-auth

# Server port
server.port=8081

# Optional
# spring.security.user.name=ignored
# spring.security.user.password=ignored
```
