package com.killerexpertise.restapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.killerexpertise.restapi.model.User;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private List<User> users = new ArrayList<>();

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        users.add(user);
        System.out.println(user);
        return new ResponseEntity<>("User added successfully!", HttpStatus.CREATED); 
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
