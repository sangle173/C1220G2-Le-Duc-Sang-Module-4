package com.example.demo_case.service.employee.impl;

import com.example.demo_case.model.employee.Department;
import com.example.demo_case.repositories.employee.DepartmentRepository;
import com.example.demo_case.service.employee.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository repository;

    @Override
    public List<Department> findAll() {
        return repository.findAll();
    }

    @Override
    public Department findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Department save(Department department) {
        return repository.save(department);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
