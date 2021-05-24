package com.example.demo_case.controller;

import com.example.demo_case.model.employee.Employee;
import com.example.demo_case.service.employee.DepartmentService;
import com.example.demo_case.service.employee.EducationDegreeService;
import com.example.demo_case.service.employee.EmployeeService;
import com.example.demo_case.service.employee.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final PositionService positionService;
    private final DepartmentService departmentService;
    private final EducationDegreeService educationDegreeService;
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(PositionService positionService, DepartmentService departmentService, EducationDegreeService educationDegreeService, EmployeeService employeeService) {
        this.positionService = positionService;
        this.departmentService = departmentService;
        this.educationDegreeService = educationDegreeService;
        this.employeeService = employeeService;
    }

    @GetMapping
    public String getIndex(Model model) {
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute("educationDegrees", educationDegreeService.findAll());
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("employee", new Employee());
        return "employee/index";
    }

    @PostMapping("/new-employee")
    public String addNewEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }


    @GetMapping("/view/{id}")
    public String viewEmployee(Model model, @PathVariable("id") Integer id) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute("educationDegrees", educationDegreeService.findAll());
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("employeeEdit", new Employee());

        return "employee/view";
    }

    @PostMapping("/edit")
    public String editEmployee(Model model, @RequestParam("id") Integer id, @ModelAttribute Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }

}
