package com.example.user_validate.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "professions")
public class Profession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String professionName;
    @OneToMany(targetEntity = User.class)
    private List<User> users;

    public Profession(String professionName) {
        this.professionName = professionName;
    }

    public Profession() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    public Profession(String professionName, List<User> users) {
        this.professionName = professionName;
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}