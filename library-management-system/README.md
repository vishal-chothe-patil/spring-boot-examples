# Library Management System 📚

The `library-management-system` project is a Spring Boot application demonstrating library management features, including:

- **Admin Management**: Create and authenticate admin users, view all admins, and search for admins by name.
- **User Management**: Manage users in the library, with functionalities to add, update, and delete user details.
- **Book Management**: Add, update, and remove books from the system.
- **Borrow Records**: Track book borrow records, including user, book, borrow date, return date, and book status.
- **REST API Endpoints**: Exposes RESTful APIs for interacting with the system, including CRUD operations for admin, user, book, and borrow records.

---

- **Data Storage**:
  - Uses **in-memory Maps** (`Map<K,V>`) instead of a database.
  - Each entity (Admin, User, Book, Record) is stored in a corresponding `HashMap`.

---

## Spring Boot Features Used 🛠

- `@SpringBootApplication` for application configuration.
- `@RestController`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`, `@GetMapping` for building REST APIs.
- `ResponseEntity` for wrapping response data and providing status codes.
- Embedded Tomcat server (runs on port 8081 by default).
- Logging with SLF4J for debugging and production environments.

---

## Project Structure 🚀

```bash
library-management-system/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── librarymanagement/
│   │   │           ├── controller/             # API controllers handling requests
│   │   │           │   ├── AdminController.java
│   │   │           │   ├── UserController.java
│   │   │           │   ├── BookController.java
│   │   │           │   └── BorrowRecordController.java
│   │   │           ├── model/                  # Entity models (database structures)
│   │   │           │   ├── Admin.java
│   │   │           │   ├── User.java
│   │   │           │   ├── Book.java
│   │   │           │   └── BorrowRecord.java
│   │   │           ├── service/                # Service classes implementing business logic
│   │   │           │   ├── AdminService.java
│   │   │           │   ├── UserService.java
│   │   │           │   ├── BookService.java
│   │   │           │   └── BorrowRecordService.java
│   │   │           ├── repository/             # Repository classes for database interaction
│   │   │           │   ├── AdminRepository.java
│   │   │           │   ├── UserRepository.java
│   │   │           │   ├── BookRepository.java
│   │   │           │   └── BorrowRecordRepository.java
│   │   │           └── LibraryManagementSystemApplication.java   # Entry point of Spring Boot app
│   │   └── resources/ 
│   │       └── application.properties         # Application config settings
├── .gitignore                                # Files and directories to be ignored by git
├── LICENSE                                   # Project license file (e.g., MIT)
├── pom.xml                                   # Maven project configuration file
└── README.md                                 # Project documentation
```

---

## REST API Endpoints 📜

### Admin Endpoints:
- `POST /api/admins/register` → Registers a new admin.
- `POST /api/admins/authenticate` → Authenticates an admin by username and password.
- `GET /api/admins/all` → Retrieves all admins.
- `GET /api/admins/search/by-name/{adminName}` → Searches for an admin by name.

### User Endpoints:
- `POST /api/users/create` → Creates a new user.
- `GET /api/users/all` → Retrieves all users.
- `GET /api/users/get/{userId}` → Retrieves a specific user by ID.
- `PUT /api/users/update/{userId}` → Updates user details.
- `DELETE /api/users/delete/{userId}` → Deletes a user.

### Book Endpoints:
- `POST /api/books/create` → Creates a new book entry.
- `GET /api/books/all` → Retrieves all books.
- `GET /api/books/get/{bookId}` → Retrieves a specific book by ID.
- `PUT /api/books/update/{bookId}` → Updates book details.
- `DELETE /api/books/delete/{bookId}` → Deletes a book.

### Borrow Record Endpoints:
- `POST /api/records/borrow` → Records a book borrow entry.
- `GET /api/records/get-all` → Retrieves all borrow records.
- `GET /api/records/get/{recordId}` → Retrieves a specific borrow record by ID.
- `PUT /api/records/update/{recordId}` → Updates borrow record details.
- `DELETE /api/records/delete/{recordId}` → Deletes a borrow record.
- `GET /api/records/search/by-user/{userName}` → Retrieves borrow records for a specific user.

---

## How to Run the Project 💻

1. **Clone the repository** to your local machine:

   ```bash
   git clone https://github.com/thevishalchothe/spring-boot-examples.git

    cd library-management-system

   ```

---

## **Contributing** 💡

We welcome contributions to you! Here's how you can contribute:

1. Fork the repository and create a new branch for your feature or bug fix.
2. Implement your changes and commit them with clear messages.
3. Submit a pull request for review.

If you have any questions or need help, feel free to contact me at [vishalchothe134@gmail.com](mailto:vishalchothe134@gmail.com).

---

## **Conclusion & License** 📜

Using an open-source license encourages collaboration and contributions from the community, leading to continuous improvement.

See the [LICENSE](https://github.com/thevishalchothe) file for more information.

---

## **Thank You and Best Regards!** 🙏🎉
