package com.killerexpertise.greeting.example.repository;

import com.killerexpertise.greeting.example.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
