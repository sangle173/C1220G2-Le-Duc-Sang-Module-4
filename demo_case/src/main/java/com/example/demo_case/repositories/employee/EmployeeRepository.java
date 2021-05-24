package com.example.demo_case.repositories.employee;

import com.example.demo_case.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("select  e from Employee e where " +
            "concat(e.id, e.name, e.birthday, e.idCard, e.salary, e.phoneNumber, e.email,e.address, e.position, e.department,e.educationDegree)" +
            "like %?1%")
    Page<Employee> findByNameContaining(String keyword, Pageable pageable);
}
