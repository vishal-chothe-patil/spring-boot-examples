package com.expertise.aop.example.service;

import com.expertise.aop.example.model.User;

import java.util.List;

public interface UserServiceI {

    User saveUser(User user);

    List<User> getAllUsers();
}