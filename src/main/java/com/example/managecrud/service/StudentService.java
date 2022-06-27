package com.example.managecrud.service;

import com.example.managecrud.entity.Student;
import org.springframework.ui.Model;

import java.util.List;

public interface StudentService {

    //implement student list
    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudentById(Long id);

    Student updateStudent(Student student);

    void deleteById(Long id);
}
