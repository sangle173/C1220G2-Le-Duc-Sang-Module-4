package com.example.case_study.controller;

import com.example.case_study.service.employee.DepartmentService;
import com.example.case_study.service.employee.EducationDegreeService;
import com.example.case_study.service.employee.EmployeeService;
import com.example.case_study.service.employee.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final PositionService positionService;
    private final DepartmentService departmentService;
    private final EducationDegreeService educationDegreeService;
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(PositionService positionService, DepartmentService departmentService,
                              EducationDegreeService educationDegreeService, EmployeeService employeeService) {
        this.positionService = positionService;
        this.departmentService = departmentService;
        this.educationDegreeService = educationDegreeService;
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute("educationDegrees", educationDegreeService.findAll());
        model.addAttribute("emList", employeeService.findAll());
        return "employee/index";
    }

}
