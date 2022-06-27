package com.example.managecrud.controller;

import com.example.managecrud.entity.Student;
import com.example.managecrud.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("liststudents", studentService.getAllStudents());

        return "index";
    }
    @GetMapping("/students/new")
    public String createStudent(Model model){

        //create student object
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/updateStudents/{id}")
    public String editStudent(@PathVariable Long id, Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }
    @PostMapping("/student/{id}")
    public String updateStudent(@PathVariable  Long id, @ModelAttribute("student") Student student ,Model model){
          //get student old from database
          Student existStudent = studentService.getStudentById(id);
          existStudent.setFirstname(student.getFirstname());
          existStudent.setLastname(student.getLastname());
          existStudent.setEmail(student.getEmail());

          //save update student
        studentService.updateStudent(existStudent);
        return "redirect:/";
    }

    //delete student request
    @GetMapping("/deleteStudents/{id}")
    public String deleteStudent(@PathVariable  Long id){
        studentService.deleteById(id);
        return "redirect:/";

    }
}
