package com.killerexpertise.exception.example.service.impl;

import com.killerexpertise.exception.example.exception.CustomerNotFoundException;
import com.killerexpertise.exception.example.model.Customer;
import com.killerexpertise.exception.example.repository.CustomerRepository;
import com.killerexpertise.exception.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
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
    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        Customer existing = getById(id); // throws if not found
        existing.setName(updatedCustomer.getName());
        existing.setEmail(updatedCustomer.getEmail());
        existing.setMobile(updatedCustomer.getMobile());
        existing.setAddress(updatedCustomer.getAddress());
        return customerRepository.save(existing);
    }

    @Override
    public boolean deleteCustomer(Long id) {
        Customer existing = getById(id); // throws if not found
        customerRepository.delete(existing);
        return true;
    }
}
