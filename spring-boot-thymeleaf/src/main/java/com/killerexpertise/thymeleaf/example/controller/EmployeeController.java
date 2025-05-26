package com.killerexpertise.thymeleaf.example.controller;

import com.killerexpertise.thymeleaf.example.model.Employee;
import com.killerexpertise.thymeleaf.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("employees", employeeService.getAll());
        return "list-employees";
    }

    @GetMapping("/employee-form")
    public String showCreateForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "create-employee";
    }

    @PostMapping("/employee")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return "redirect:/";
    }
}
