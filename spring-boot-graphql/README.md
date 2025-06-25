# Spring Boot GraphQL Example ⚙️

This `spring-boot-graphql` project showcases how to build a full-fledged Student Management CRUD system using Spring Boot and GraphQL following a schema-first approach.
It illustrates the power of GraphQL in efficiently handling create, read, update, and delete operations via structured query mappings and controller logic.

---

## What is GraphQL? 📘 

**GraphQL** is a query language and runtime for APIs developed by Facebook in 2012.

- Unlike REST, it allows clients to request only the **exact data** they need.
- Uses **type system** to describe data.
- Single endpoint (`/graphql`) for all data operations.

---

## Why Use GraphQL? ❓ 

| REST                            | GraphQL                                  |
|---------------------------------|-------------------------------------------|
| Multiple endpoints              | Single endpoint `/graphql`               |
| Over-fetching or under-fetching| Precise data fetching                    |
| Fixed structure per response    | Flexible structure by client request     |
| HTTP verbs based (GET, POST)    | Schema and type system based             |

- Better performance on frontend
- Faster development and debugging
- Eliminates versioning complexity

---
## Project Setup – Step by Step 📦 

### 🔹 1: Add Dependencies in `pom.xml`

  ```xml
  <dependencies>
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-graphql</artifactId>
      </dependency>
  </dependencies>
  ```

### 🔹 2: Configure application.properties
 
  ```properties
  # Default Behavior: URL endpoint where your GraphQL API is accessible
  spring.graphql.path=/graphql and other required properties
  ```

### 🔹 3: Define GraphQL Schema – src/main/resources/graphql/schema.graphqls

  ```graphql
  
  type Student {
    id: ID
    name: String
    email: String
    course: String
    age: Int
    address: String
  }
  
  type Query {
    getAllStudents: [Student]
    getStudentById(id: ID!): Student
  }
  
  type Mutation {
    createStudent(name: String, email: String, course: String, age: Int, address: String): Student
    updateStudent(id: ID!, name: String, email: String, course: String, age: Int, address: String): Student
    deleteStudent(id: ID!): Boolean
  }
  ```

### 🔹 4: Create Entity and Other Architecture Layers

For Exampple Controller Layer:

```java
@Controller
public class StudentController {

    @Autowired
    StudentServiceI studentServiceI;

    @MutationMapping
    public Student createStudent(@Argument String name, @Argument String email,
                                 @Argument String course, @Argument Integer age,
                                 @Argument String address) {
        Student student = new Student(null, name, email, course, age, address);
        return studentServiceI.createStudent(student);
    }

    @QueryMapping
    public List<Student> getAllStudents() {
        return studentServiceI.getAllStudents();
    }
}
```
---

## Sample Queries & Mutations ✅ 

### Create Student

  ```json
  {
    "query": "mutation CreateStudent($name: String, $email: String, $course: String, $age: Int, $address: String) { createStudent(name: $name, email: $email, course: $course, age: $age, address: $address) { id name email course age address } }",
    "variables": {
      "name": "Patil",
      "email": "Patil@example.com",
      "course": "Spring Boot with GraphQL",
      "age": 25,
      "address": "Pune"
    }
  }
  ```

### Get All Students 
 
  ```json 
  {
    "query": "query { getAllStudents { id name email course age address } }"
  }
  ```

### Get Student By ID 

  ```json
  {
    "query": "query GetStudentById($id: ID!) { getStudentById(id: $id) { id name email course age address } }",
    "variables": {
      "id": 1
    }
  }
  ```
 
### Update Student

  ```json
  {
    "query": "mutation UpdateStudent($id: ID!, $name: String, $email: String, $course: String, $age: Int, $address: String) { updateStudent(id: $id, name: $name, email: $email, course: $course, age: $age, address: $address) { id name email course age address } }",
    "variables": {
      "id": 1,
      "name": "Patil Updated",
      "email": "updated@example.com",
      "course": "GraphQL Advanced",
      "age": 26,
      "address": "Mumbai"
    }
  }
  ```
 
### Delete Student 

  ```json
  {
    "query": "mutation DeleteStudent($id: ID!) { deleteStudent(id: $id) }",
    "variables": {
      "id": 1
    }
  }
  ```

--- 

 ## Summary! Key Highlights 📌 

This project serves as a complete, production-ready example of building a modern CRUD API using Spring Boot and GraphQL. It showcases how to integrate GraphQL seamlessly with Java-based backends using Spring Boot 3.5.3 and Java 21, leveraging a schema-first approach for clarity and structure. 

What This Project Demonstrates 
- GraphQL Basics: Using `@QueryMapping` and `@MutationMapping` to bind GraphQL operations to Java methods.
-  Full CRUD Operations: Create, retrieve (single & all), update, and delete a Student entity with real database integration.
- Best Practices: Clean layering `(Controller → Service → Repository)` and modular package structure under com.expertise.graphql.example.
- Auto DB Setup: MySQL database schema is auto-generated using Spring Data JPA with ddl-auto=update.
- GraphQL Schema Design: Defined using `schema.graphqls` files under src/main/resources/graphql, which helps decouple data shape from implementation logic.
