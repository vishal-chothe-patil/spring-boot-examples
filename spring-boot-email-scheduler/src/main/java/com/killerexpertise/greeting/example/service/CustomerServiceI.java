package com.killerexpertise.greeting.example.service;

import com.killerexpertise.greeting.example.model.Customer;

import java.util.List;

public interface CustomerServiceI {
    List<Customer> getAllCustomers();
    Customer getCustomerById(Long id);
    Customer saveCustomer(Customer customer);
    void deleteCustomer(Long id);
}
