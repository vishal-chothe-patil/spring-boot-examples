package com.killerexpertise.pagination.example.controller;

import com.killerexpertise.pagination.example.model.Product;
import com.killerexpertise.pagination.example.service.ProductServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServiceI productService;

    // POST - Create new product
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }
    // GET with pagination
    @GetMapping("/pagination")
    public Page<Product> getPaginatedProducts(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "3") int size) {

        return productService.getProductsWithPagination(page, size);
    }

    // GET with pagination + sorting
    @GetMapping("/sort-pagination")
    public Page<Product> getSortedPaginatedProducts(@RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "3") int size,
                                                    @RequestParam(defaultValue = "id") String sortField,
                                                    @RequestParam(defaultValue = "asc") String sortDirection) {

        return productService.getProductsWithPaginationAndSorting(page, size, sortField, sortDirection);
    }
}
