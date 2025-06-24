package com.expertise.graphql.example.controller;

import com.expertise.graphql.example.service.StudentServceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class StudentController {

    @Autowired
    StudentServceI studentServceI;

}
