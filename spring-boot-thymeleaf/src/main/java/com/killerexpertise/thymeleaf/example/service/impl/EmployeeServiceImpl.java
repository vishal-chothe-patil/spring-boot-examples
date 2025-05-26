package com.killerexpertise.thymeleaf.example.service.impl;

import com.killerexpertise.thymeleaf.example.model.Employee;
import com.killerexpertise.thymeleaf.example.repository.EmployeeRepository;
import com.killerexpertise.thymeleaf.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        return repository.findAll();
    }
}
