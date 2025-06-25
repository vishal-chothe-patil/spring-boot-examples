package com.expertise.graphql.example.service;

import com.expertise.graphql.example.model.Student;

import java.util.List;

public interface StudentServiceI {

    Student createStudent(Student student);

    List<Student> getAllStudents();
}
