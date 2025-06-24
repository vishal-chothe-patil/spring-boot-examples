package com.expertise.graphql.example.controller;

import com.expertise.graphql.example.service.StudentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class StudentController {

    @Autowired
    private StudentServiceI studentServiceI;

}
