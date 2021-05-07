package com.example.student_management.controller;


import com.example.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;
    @GetMapping
    public ModelAndView getStudentPage(){
        return new ModelAndView("index","students",studentService.findAll());
    }
}
