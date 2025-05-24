package com.killerexpertise.auth.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Spring Security example!";
    }

    @GetMapping("/user")
    public String user() {
        return "Hello User! You have USER access.";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Hello Admin! You have ADMIN access.";
    }
}
