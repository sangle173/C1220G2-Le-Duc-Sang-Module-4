package com.example.demo_case.service.employee;

import com.example.demo_case.model.employee.Employee;
import com.example.demo_case.service.IGeneralService;
import com.example.demo_case.service.IPageGeneralService;

public interface EmployeeService extends IGeneralService<Employee>, IPageGeneralService<Employee> {
}
