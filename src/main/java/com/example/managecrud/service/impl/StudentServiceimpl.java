package com.example.managecrud.service.impl;

import com.example.managecrud.entity.Student;
import com.example.managecrud.repository.StudentRepository;
import com.example.managecrud.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceimpl implements StudentService {
    //add depandency

    private StudentRepository studentRepository;

    public StudentServiceimpl(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
}
