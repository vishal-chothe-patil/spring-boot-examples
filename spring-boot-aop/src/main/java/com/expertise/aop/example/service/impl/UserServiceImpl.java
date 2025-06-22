package com.expertise.aop.example.service.impl;

import com.expertise.aop.example.model.User;
import com.expertise.aop.example.repository.UserRepository;
import com.expertise.aop.example.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServiceI {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}