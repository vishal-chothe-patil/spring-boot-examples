package com.expertise.aop.example.controller;

import com.expertise.aop.example.model.User;
import com.expertise.aop.example.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserServiceI userServiceI;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userServiceI.saveUser(user);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userServiceI.getAllUsers();
    }

}