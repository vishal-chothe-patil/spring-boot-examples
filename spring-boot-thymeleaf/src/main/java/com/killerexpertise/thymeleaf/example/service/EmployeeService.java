package com.killerexpertise.thymeleaf.example.service;

import com.killerexpertise.thymeleaf.example.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);
    List<Employee> getAll();
}
