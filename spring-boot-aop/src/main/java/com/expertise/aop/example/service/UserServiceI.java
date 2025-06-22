package com.expertise.aop.example.service;

import com.expertise.aop.example.model.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceI {

    User saveUser(User user);

    List<User> getAllUsers();

    Optional<User> getUserById(Long id);
}