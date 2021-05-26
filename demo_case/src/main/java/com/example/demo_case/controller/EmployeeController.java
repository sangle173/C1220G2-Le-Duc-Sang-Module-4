package com.example.demo_case.controller;

import com.example.demo_case.model.customer.Customer;
import com.example.demo_case.model.employee.Employee;
import com.example.demo_case.service.customer.impl.CustomerServiceImpl;
import com.example.demo_case.service.employee.DepartmentService;
import com.example.demo_case.service.employee.EducationDegreeService;
import com.example.demo_case.service.employee.EmployeeService;
import com.example.demo_case.service.employee.PositionService;
import com.example.demo_case.service.employee.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @ModelAttribute
    public void detail(Model model) {
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute("educationDegrees", educationDegreeService.findAll());
    }

    @RequestMapping
    public String viewHomePage(Model model) {
        String keyword = null;
        return viewPage(model, 1, "name", "asc", keyword);
    }

    @RequestMapping("/page/{pageNum}")
    public String viewPage(Model model,
                           @PathVariable(name = "pageNum") int currentPage,
                           @Param(("sortField")) String sortField,
                           @Param(("sortDir")) String sortDir,
                           @Param("keyword") String keyword) {
        Page<Employee> page = employeeService.findAll(currentPage, sortField, sortDir, keyword);
        List<Employee> employeeList = page.getContent();
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("employees", employeeList);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("keyword", keyword);
//        model.addAttribute("positions", positionService.findAll());
//        model.addAttribute("departments", departmentService.findAll());
//        model.addAttribute("educationDegrees", educationDegreeService.findAll());
        model.addAttribute("employee", new Employee());
        return "employee/index";

    }

    @PostMapping("/new-employee")
    public String addNewEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result) {
        if (result.hasFieldErrors()) {
            return "employee/new";
        } else {
            employeeService.save(employee);
            return "redirect:/employees";
        }

    }

    @GetMapping("/new-employee")
    public String showNewEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute("educationDegrees", educationDegreeService.findAll());
        return "employee/new";
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
    public String editEmployee(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }


    @GetMapping(value = "/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeService.deleteById(id);
        return "redirect:/employees";
    }

}
