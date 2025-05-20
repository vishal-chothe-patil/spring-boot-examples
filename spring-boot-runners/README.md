#  Spring Boot Runners Example 🚀

A `spring-boot-runners` example demonstrating the use of **ApplicationRunner** and **CommandLineRunner** interfaces in a Spring Boot application to handle startup logic and command-line arguments.

---

## 📚 What is this example about?

Spring Boot provides two interfaces, **ApplicationRunner** and **CommandLineRunner**, that allow you to run specific code **right after the application context is loaded** and before the Spring Boot application starts serving requests.

This project shows:

- How to implement and use **ApplicationRunner** and **CommandLineRunner** in your Spring Boot app.
- How to read **command-line arguments** passed during application startup.
- How to log information and handle default values when specific arguments are not provided.

---

## ⚙️ Why use ApplicationRunner and CommandLineRunner?

- 🔄 To execute initialization code during application startup.
- 📥 To process **command-line arguments** in a clean, flexible way.
- 🧩 To separate startup logic from the main business logic.
- 🛠️ Useful for tasks like data loading, configuration setup, or performing checks before the app fully starts.

---

## 🛠️ How to use this example?

### 1. Running the application with a command-line argument

Pass the `--load-inventor` argument with a JSON string when starting the app:

```bash
./mvnw spring-boot:run -Dspring-boot.run.arguments="--load-inventor='[{\"id\":1,\"title\":\"Java\",\"developBy\":\"James Gosling\"}]' "
---
 In Program Argument we can pass : --load-inventor='[{\"id\":1,\"title\":\"Java\",\"developBy\":\"James Gosling\"}]' 
```

## 2️⃣ What happens internally?

✅ The `ApplicationRunner` or `CommandLineRunner` implementation detects the `--load-inventor` argument.

🧪 If provided, it extracts the JSON string from the argument.

📭 If not provided, it falls back to a default empty JSON array: `[]`.

🪵 Logs are generated showing:
- 🔄 Application startup event
- 📦 The value of the inventor JSON string (or default)

---

## 🔍 Where to use this pattern?

💡 Use this approach when:

- 🧰 You need to run **initialization scripts** or **data loaders** right after the Spring Boot application context has loaded.
- ⚙️ Your application supports **dynamic configuration** via **command-line arguments**.
- 🖥️ You're building **CLI utilities** using Spring Boot.
- 🐞 You want to **test or debug** startup logic with customizable input arguments.

---

## ⚡ Example Code Snippets

### 📦 ApplicationRunner Example
```java
@Component
public class AppRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) {
        // your logic here
    }
}
```

### 📦 ComandLineRunner Example
```
@Component
public class CmdRunner implements CommandLineRunner {
    @Override
    public void run(String... args) {
        // your logic here
    }
}
```

## 📖 Learn More

📚 [Spring Boot Reference Guide: ApplicationRunner and CommandLineRunner](https://docs.spring.io/spring-boot/reference/features/spring-application.html#features.spring-application.command-line-runner)

📝 [Spring Boot Logging](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.logging)
