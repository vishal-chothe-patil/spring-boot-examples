package com.killerexpertise.pagination.example.service;

import com.killerexpertise.pagination.example.model.Product;
import org.springframework.data.domain.Page;

public interface ProductServiceI {

    Product saveProduct(Product product);

    Page<Product> getProductsWithPagination(int page, int size);

    Page<Product> getProductsWithPaginationAndSorting(int page, int size, String sortField, String sortDirection);

}
