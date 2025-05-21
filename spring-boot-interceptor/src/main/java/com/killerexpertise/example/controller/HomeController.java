package com.killerexpertise.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        String message = "Hello from Spring Boot Interceptors Example!";
        return ResponseEntity.ok(message);
    }
}
