package com.example.case_study.model.employee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "education_degrees")
public class EducationDegree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_degree_id")
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "educationDegree", cascade = CascadeType.ALL, targetEntity = Employee.class)
    private List<Employee> employees;

    public EducationDegree() {
    }

    public EducationDegree(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
