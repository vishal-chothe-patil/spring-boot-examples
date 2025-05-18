package com.killerexpertise.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "Welcome to Hello Spring Boot! Visit '/hello' for a greeting.";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello from KillerExpertise -Vishal!";
    }
}
