package com.killerexpertise.example.service.impl;

import com.killerexpertise.example.exception.CustomerNotFoundException;
import com.killerexpertise.example.model.Customer;
import com.killerexpertise.example.repository.CustomerRepository;
import com.killerexpertise.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer, MultipartFile file) throws IOException {
        if (file != null && !file.isEmpty()) {
            customer.setAadharCard(file.getBytes());
        }
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with ID " + id + " not found"));
    }

    @Override
    public Customer updateCustomer(Long id, Customer updatedCustomer, MultipartFile file) throws IOException {
        Customer existing = getById(id); // throws exception if not found
        existing.setName(updatedCustomer.getName());
        existing.setEmail(updatedCustomer.getEmail());
        existing.setMobile(updatedCustomer.getMobile());
        existing.setAddress(updatedCustomer.getAddress());

        if (file != null && !file.isEmpty()) {
            existing.setAadharCard(file.getBytes());
        }

        return customerRepository.save(existing);
    }

    @Override
    public boolean deleteCustomer(Long id) {
        Customer existing = getById(id); // throws exception if not found
        customerRepository.delete(existing);
        return true;
    }
}
