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

## Why Use Spring Boot Email Scheduler? 🤖

This example demonstrates how to:

  - Send scheduled HTML emails using **Spring Boot + JavaMailSender**
  - Use **Spring Scheduler** to run tasks automatically
  - Store logs of sent or failed emails using **Spring Data JPA**
  - Trigger email sending manually via a **REST API**
  - Display how to embed styled HTML + images in emails

---


## Technologies Used 

  - Spring Boot
  - Spring Scheduler (`@Scheduled`)
  - Spring Mail (JavaMailSender)
  - Spring Data JPA (with Hibernate)
  - MySQL (or any relational DB)
  - Jakarta Mail API
  - Maven or Gradle build

---


##  How It Works (Step-by-Step) 🚀

### 1. Customer Data

Add customers with their **name** and **email** into the `Customer` table.  
This data will be used to send Greeting (Good Morning) emails.

---

### 2. Scheduled Task ⏰ 

The method in `GreetingScheduler.java` is executed **daily at 1:25 PM** using a cron expression:

```java
// Runs every day at 10:01 AM
@Scheduled(cron = "0 1 10 * * *")
public void sendDailyGoodMorningEmails() {
    emailService.sendGoodMorningEmails();
}
```
---
### 3. Email Sending Logic ✉️ 

Inside `EmailServiceImpl.java`, the flow is as follows:
  
  - Fetch all customers from the database
  - Send a **styled HTML email** to each customer using `JavaMailSender`
  - Store the status (`SENT` or `FAILED`) in the `EmailLog` table

---

### 4.  HTML Email Template 🖼️

Each email sent contains:
  
  - A personalized greeting (e.g., *"Good Morning, Vishal!"*)
  - A motivational quote
  - A **centered good morning image**
  - A friendly sign-off with branding

---

### 5. REST API Endpoint 🌐 

You can also manually trigger the email sending process by hitting the API:

```http
GET /api/email/sendmsg
```
📩 Response:

```
Good Morning emails sent successfully!
```

---

### 6. Logging 🗂️ 

  -  Every email attempt is logged into the EmailLog table with:
  -  recipientEmail: the customer's email address
  -  status: SENT or FAILED
  -  timestamp: the date and time the email was processed

---

## Running the Project

  1. Clone the repository
  2. Configure your email credentials in application.properties
  3. Run the application
  4. (Optional) Hit the API manually: `http://localhost:8080/api/email/sendmsg`
