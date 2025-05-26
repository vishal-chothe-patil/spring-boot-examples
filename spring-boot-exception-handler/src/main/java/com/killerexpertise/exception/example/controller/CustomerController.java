package com.killerexpertise.exception.example.controller;

import com.killerexpertise.exception.example.model.Customer;
import com.killerexpertise.exception.example.responce.ApiResponse;
import com.killerexpertise.exception.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<ApiResponse<Customer>> createCustomer(@RequestBody Customer customer) {
        Customer saved = customerService.saveCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Customer created successfully", saved));
    }

    @GetMapping("/get-all")
    public ResponseEntity<ApiResponse<List<Customer>>> getAllCustomers() {
        List<Customer> customers = customerService.getAll();
        return ResponseEntity.ok(new ApiResponse<>("Customers fetched all successfully", customers));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Customer>> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getById(id);
        return ResponseEntity.ok(new ApiResponse<>("Customer fetched successfully", customer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Customer>> updateCustomer(
            @PathVariable Long id,
            @RequestBody Customer customer) {
        Customer updated = customerService.updateCustomer(id, customer);
        return ResponseEntity.ok(new ApiResponse<>("Customer updated successfully", updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok(new ApiResponse<>("Customer deleted successfully", null));
    }
}
