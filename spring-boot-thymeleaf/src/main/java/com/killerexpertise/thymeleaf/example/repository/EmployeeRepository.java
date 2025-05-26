package com.killerexpertise.thymeleaf.example.repository;

import com.killerexpertise.thymeleaf.example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
