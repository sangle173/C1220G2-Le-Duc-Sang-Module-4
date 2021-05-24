package com.example.demo_case.model.employee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "positions")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL, targetEntity = Employee.class)
    private List<Employee> employees;

    public Position() {
    }

    public Position(String name, List<Employee> employees) {
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

    public void setName(String positionName) {
        this.name = positionName;
    }
}
