package com.example.case_study.repositories.employee;

import com.example.case_study.model.employee.Employee;
import com.example.case_study.model.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
