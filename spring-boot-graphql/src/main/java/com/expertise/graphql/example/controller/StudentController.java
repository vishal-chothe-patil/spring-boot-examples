package com.expertise.graphql.example.controller;

import com.expertise.graphql.example.model.Student;
import com.expertise.graphql.example.service.StudentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class StudentController {

    @Autowired
    StudentServiceI studentServiceI;

    @MutationMapping
    public Student createStudent(@Argument String name, @Argument String email,
                                 @Argument String course, @Argument Integer age,
                                 @Argument String address) {
        Student student = new Student(null, name, email, course, age, address);
        return studentServiceI.createStudent(student);
    }

}
