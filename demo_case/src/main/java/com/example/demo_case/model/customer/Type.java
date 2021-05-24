package com.example.demo_case.model.customer;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer_type")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Integer id;
    private String typeName;

    @OneToMany(mappedBy = "type", targetEntity = Customer.class, cascade = CascadeType.ALL)
    private List<Customer> customers;

    public Type() {
    }

    public Type(String typeName, List<Customer> customers) {
        this.typeName = typeName;
        this.customers = customers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
