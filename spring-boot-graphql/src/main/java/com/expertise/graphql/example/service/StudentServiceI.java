package com.expertise.graphql.example.service;

import com.expertise.graphql.example.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentServiceI {

    Student createStudent(Student student);

    List<Student> getAllStudents();

    Optional<Student> getStudentById(Long id);

    Student updateStudent(Long id, Student student);
}
