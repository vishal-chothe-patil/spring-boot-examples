package com.killerexpertise.restapi.controller;

import com.killerexpertise.restapi.model.User;
import com.killerexpertise.restapi.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        String message = userService.addUser(user);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        return user != null ?
                new ResponseEntity<>(user, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Integer id, @RequestBody User updatedUser) {
        String message = userService.updateUser(id, updatedUser);
        return new ResponseEntity<>(message, message.contains("successfully") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/partialUpdate/{id}")
    public ResponseEntity<String> partiallyUpdateUser(@PathVariable Integer id, @RequestBody User partialUser) {
        String message = userService.partiallyUpdateUser(id, partialUser);
        return new ResponseEntity<>(message, message.contains("updated") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        String message = userService.deleteUser(id);
        return new ResponseEntity<>(message, message.contains("successfully") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
