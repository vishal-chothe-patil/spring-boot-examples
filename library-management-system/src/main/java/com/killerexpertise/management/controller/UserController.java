package com.killerexpertise.management.controller;

import com.killerexpertise.management.model.User;
import com.killerexpertise.management.service.UserService;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Setter
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public String createUser(@RequestBody User user) {
        logger.info("Request received to create a new user: {}", user.getName());
        userService.addUser(user);
        logger.info("User created successfully: {}", user.getName());
        return "User created successfully!";
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        logger.info("Request received to fetch all users.");
        return userService.getAllUsers();
    }

    @GetMapping("/get/{userId}")
    public User getUserById(@PathVariable int userId) {
        logger.info("Request received to fetch user with ID: {}", userId);
        return userService.getUserById(userId);
    }

    @PutMapping("/update/{userId}")
    public String updateUserDetails(@PathVariable int userId, @RequestBody User updatedUser) {
        logger.info("Request received to update user with ID: {}", userId);
        updatedUser.setUid(userId);
        userService.updateUser(userId, updatedUser);
        logger.info("User details updated successfully for ID: {}", userId);
        return "User details updated successfully!";
    }

    @DeleteMapping("/delete/{userId}")
    public String removeUser(@PathVariable int userId) {
        logger.warn("Request received to delete user with ID: {}", userId);
        userService.deleteUser(userId);
        logger.info("User removed successfully with ID: {}", userId);
        return "User removed successfully!";
    }
}
