# spring-boot-email-scheduler Example ⚙️📧

This is a **Spring Boot** example project demonstrating how to send **automated scheduled emails** using **Spring's JavaMailSender** along with the **Spring Scheduler**. The project sends a personalized "Good Morning" email to a list of customers daily at a configured time, logging email statuses (sent or failed) in a database.


## What is this project? 📩

- A sample Spring Boot application to send **HTML formatted emails** with embedded images.
- Uses **Spring Scheduler** (`@Scheduled`) to trigger the email sending automatically every day.
- Uses **JavaMailSender** for composing and sending emails.
- Stores email logs (recipient, status, timestamp) in a database via Spring Data JPA.
- Fetches recipients dynamically from the database (`Customer` entity).
- Provides a simple, extensible architecture with Service, Repository, and Scheduler layers.

---

## Why use Spring Boot Email Scheduler? 🤖

- **Automated communication**: Schedule emails without manual intervention.
- **Customizable email templates**: Send rich HTML emails with inline images.
- **Reliable**: Log email sending status and handle failures gracefully.
- **Extensible**: Add new email types or schedules easily.
- **Scalable**: Integrate with any customer database and email server.

---

## Technologies Used 

- Spring Boot
- Spring Scheduler (`@Scheduled`)
- Spring Mail (JavaMailSender)
- Spring Data JPA (with Hibernate)
- MySQL (or any relational DB)
- Jakarta Mail API
- Maven or Gradle build

