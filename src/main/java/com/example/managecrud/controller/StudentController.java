package com.example.managecrud.controller;

import com.example.managecrud.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/liststudents")
    public String listStudents(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "index";
    }
}
