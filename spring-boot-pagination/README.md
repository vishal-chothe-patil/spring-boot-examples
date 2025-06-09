# Spring Boot Pagination & Sorting API Example 📦 

This project demonstrates how to implement **pagination** and **sorting** in a Spring Boot REST API using Spring Data JPA. It provides clean endpoints to retrieve `Product` entities page by page, with optional sorting.

---

## What is Pagination? 📘 

**Pagination** is the process of dividing a large dataset into smaller chunks (called *pages*) so the server sends only a limited number of records per request.

### Example: ✅ 
- Page 0 (with size 3) returns: Product 1, 2, 3  
- Page 1 returns: Product 4, 5, 6  
- And so on...

---

## What is Sorting? 📘 

**Sorting** is the technique of ordering data based on one or more fields — such as name, price, or date — either in **ascending (asc)** or **descending (desc)** order.

### Example: ✅ 
- Sorted by price `asc`: Cheap → Expensive  
- Sorted by name `desc`: Z → A

---

## Why Use Pagination & Sorting? ❓ 

- 📈 **Performance**: Avoids loading large datasets at once.
- 🎯 **Efficiency**: Reduces memory usage and improves response times.
- 🧭 **User Experience**: Better data navigation on frontend (tables, lists).
- ⚙️ **Scalability**: Helps scale the API as data grows.
