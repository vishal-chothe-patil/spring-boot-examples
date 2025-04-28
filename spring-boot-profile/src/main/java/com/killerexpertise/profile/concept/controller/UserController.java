package com.killerexpertise.profile.concept.controller;

import com.killerexpertise.profile.concept.model.User;
import com.killerexpertise.profile.concept.service.UserService;
import com.killerexpertise.profile.concept.service.impl.DevUserServiceImpl;
import com.killerexpertise.profile.concept.service.impl.ProdUserServiceImpl;
import com.killerexpertise.profile.concept.service.impl.TestUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user) {
        userService.addUser(user);
        return "User added successfully!";
    }

    @GetMapping("/get-all")
    public Map<String, User> getAllUsers() {
        if (userService instanceof DevUserServiceImpl) {
            return ((DevUserServiceImpl) userService).getAllUsers();
        } else if (userService instanceof ProdUserServiceImpl) {
            return ((ProdUserServiceImpl) userService).getAllUsers();
        } else if (userService instanceof TestUserServiceImpl) {
            return ((TestUserServiceImpl) userService).getAllUsers();
        } else {
            throw new UnsupportedOperationException("Fetching users not supported in this profile!");
        }
    }
}
