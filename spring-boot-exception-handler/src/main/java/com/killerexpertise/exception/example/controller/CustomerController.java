package com.killerexpertise.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.killerexpertise.example.model.Customer;
import com.killerexpertise.example.responce.ApiResponse;
import com.killerexpertise.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<Customer>> createCustomer(
            @RequestParam("customer") String customerJson,
            @RequestParam("file") MultipartFile file) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        Customer customer = mapper.readValue(customerJson, Customer.class);
        Customer saved = customerService.saveCustomer(customer, file);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Customer created successfully", saved));
    }

    @GetMapping("/get-all")
    public ResponseEntity<ApiResponse<List<Customer>>> getAll() {
        List<Customer> customers = customerService.getAll();
        return ResponseEntity.ok(new ApiResponse<>("Customers fetched successfully", customers));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Customer>> getById(@PathVariable Long id) {
        Customer customer = customerService.getById(id);
        return ResponseEntity.ok(new ApiResponse<>("Customer fetched successfully", customer));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<Customer>> updateCustomer(
            @PathVariable Long id,
            @RequestParam("customer") String customerJson,
            @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        Customer customer = mapper.readValue(customerJson, Customer.class);
        Customer updated = customerService.updateCustomer(id, customer, file);
        return ResponseEntity.ok(new ApiResponse<>("Customer updated successfully", updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok(new ApiResponse<>("Customer deleted successfully", null));
    }
}
