package com.expertise.aop.example.service.impl;

import com.expertise.aop.example.repository.UserRepository;
import com.expertise.aop.example.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServiceI {

    @Autowired
    private UserRepository userRepository;

}