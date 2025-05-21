#  Spring Boot Scheduler Example ⏰

## What Is It?

**Spring Boot Scheduler** enables you to automate tasks by running methods at fixed intervals or specific times using annotations like `@Scheduled`. It helps you perform background jobs such as report generation, data synchronization, email sending, and more.

---

## Why Use It?

Schedulers are commonly used in companies to:

- Automate repetitive tasks (e.g., cleaning logs, sending emails)
- Reduce manual effort by automating background jobs
- Ensure tasks run reliably and consistently on schedule
- Improve application performance by offloading non-urgent work from main request flows

---

## How It Works

### 1. Enable Scheduling

Enable scheduling support in your Spring Boot application:

```java
@SpringBootApplication
@EnableScheduling
public class SchedulerApp {
    public static void main(String[] args) {
        SpringApplication.run(SchedulerApp.class, args);
    }
}


---
```

### 2. Scheduled Task (`@Scheduled`)

Defined in `TaskSchedulerService.java`:

```java
@Scheduled(cron = "0 30 2 * * ?") // Runs daily at 2:30 AM
public void performScheduledTask() {
    // Your logic here
}

```
### 3. Add REST API to Trigger Manually

Optionally, expose a REST endpoint to trigger the task on-demand:

```java
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskSchedulerService taskService;

    public TaskController(TaskSchedulerService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/run-now")
    public ResponseEntity<String> runNow() {
        taskService.performScheduledTask();
        return ResponseEntity.ok("Task triggered manually!");
    }
}
```
---
## Cron Expression Breakdown

Example cron expression: `"0 30 2 * * ?"`

| Field         | Value | Meaning           |
|---------------|-------|-------------------|
| Seconds       | 0     | At 0 seconds      |
| Minutes       | 30    | At 30 minutes     |
| Hours         | 2     | At 2 AM           |
| Day-of-Month  | *     | Every day         |
| Month         | *     | Every month       |
| Day-of-Week   | ?     | No specific day   |

This means the task runs **every day at 2:30 AM**.

---

## Summary

- Use `@Scheduled` to automate periodic tasks  
- Enable scheduling with `@EnableScheduling` in your main application class  
- Add REST APIs if you want manual trigger control over scheduled tasks  
- Use cron expressions to fine-tune schedule times  

## References

- [Spring Boot Scheduling Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.scheduling)
