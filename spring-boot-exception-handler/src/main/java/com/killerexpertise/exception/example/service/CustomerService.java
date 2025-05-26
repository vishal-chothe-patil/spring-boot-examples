package com.killerexpertise.exception.example.service;

import com.killerexpertise.exception.example.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer);

    List<Customer> getAll();

    Customer getById(Long id);

    Customer updateCustomer(Long id, Customer customer);

    boolean deleteCustomer(Long id);
}
