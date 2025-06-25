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
