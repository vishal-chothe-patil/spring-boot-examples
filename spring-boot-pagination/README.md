# Spring Boot Pagination & Sorting API Example 📦 

This project demonstrates how to implement **pagination** and **sorting** in a Spring Boot REST API using Spring Data JPA. It provides clean endpoints to retrieve `Product` entities page by page, with optional sorting.

---

## What is Pagination? 📘 

**Pagination** is the process of dividing a large dataset into smaller chunks (called *pages*) so the server sends only a limited number of records per request.

### Example:  
- Page 0 (with size 3) returns: Product 1, 2, 3  
- Page 1 returns: Product 4, 5, 6  
- And so on...

---

## What is Sorting? 📘 

**Sorting** is the technique of ordering data based on one or more fields — such as name, price, or date — either in **ascending (asc)** or **descending (desc)** order.

### Example: 
- Sorted by price `asc`: Cheap → Expensive  
- Sorted by name `desc`: Z → A

---

## Why Use Pagination & Sorting? ❓ 

- 📈 **Performance**: Avoids loading large datasets at once.
- 🎯 **Efficiency**: Reduces memory usage and improves response times.
- 🧭 **User Experience**: Better data navigation on frontend (tables, lists).
- ⚙️ **Scalability**: Helps scale the API as data grows.

---


## API Endpoints 📦 

### 🔹 Get Paginated Products
  ```
  GET /products/pagination?page=0&size=3
  ```

**Query Params:**
- `page`: page number (starts from 0)
- `size`: number of items per page

---

### 🔹 Get Paginated and Sorted Products
 
  ```
  GET /products/sort-pagination?page=0&size=3&sortField=price&sortDirection=desc
  ```

**Query Params:**
- `sortField`: e.g., `name`, `price`, `id`
- `sortDirection`: `asc` or `desc`

---

## Sample JSON Response 💡

```json
{
  "content": [
    {
      "id": 1,
      "name": "Laptop",
      "price": 45000,
      "category": "Electronics"
    },
    {
      "id": 2,
      "name": "Mouse",
      "price": 800,
      "category": "Accessories"
    },
    {
      "id": 3,
      "name": "Charger",
      "price": 600,
      "category": "Accessories"
    }
  ],
  "totalPages": 4,
  "totalElements": 12,
  "size": 3,
  "number": 0
}
```

---

## How to Use in Spring Boot ⚙️ 

  ### Step 1: Add JPA and Web dependencies 🧬 
  ```
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-jpa</artifactId>
  </dependency>
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
  </dependency>
  ```

### Step 2: Use Pageable in Controller 🧬
  ```
// GET with pagination + sorting
    @GetMapping("/sort-pagination")
    public Page<Product> getSortedPaginatedProducts(@RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "3") int size,
                                                    @RequestParam(defaultValue = "id") String sortField,
                                                    @RequestParam(defaultValue = "asc") String sortDirection) {

        return productService.getProductsWithPaginationAndSorting(page, size, sortField, sortDirection);
    }
  ```

### Step 3: Use PageRequest.of(page, size, sort) in Service 🧬 
  ```  
  @Override
      public Page<Product> getProductsWithPaginationAndSorting(int page, int size, String sortField, String sortDirection) {
          Sort sort = sortDirection.equalsIgnoreCase("asc") ?
                  Sort.by(sortField).ascending() :
                  Sort.by(sortField).descending();
  
          Pageable pageable = PageRequest.of(page, size, sort);
          return productRepository.findAll(pageable);
      }
  ```

---

##  Summary 📌

  -  Pagination helps split large datasets into smaller, faster chunks.
  -  Sorting gives control over how records are ordered.
  -  Easily added in Spring Boot using Pageable, Sort, and PageRequest.

-  Improves performance
-  Better user experience
-  Cleaner API design

