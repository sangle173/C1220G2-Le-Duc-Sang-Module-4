package com.example.jp_knife_manager.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "brands")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String url;

    @OneToMany(targetEntity = Knife.class)
    private List<Knife> knifeList;

    public Brand() {
    }

    public Brand(String name, String url) {
        this.name = name;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Brand(String name, String description, String url) {
        this.name = name;
        this.description = description;
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Knife> getKnifeList() {
        return knifeList;
    }

    public void setKnifeList(List<Knife> knifeList) {
        this.knifeList = knifeList;
    }
}
