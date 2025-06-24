package com.expertise.graphql.example.service.impl;

import com.expertise.graphql.example.repository.StudentRepository;
import com.expertise.graphql.example.service.StudentServceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentServceI {

    @Autowired
    StudentRepository studentRepository;

}
