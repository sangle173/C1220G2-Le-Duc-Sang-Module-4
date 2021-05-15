package com.example.jp_knife_manager.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "knife_type")
public class KnifeType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String url;
    private String description;

    @OneToMany(targetEntity = Knife.class)
    private List<Knife> knifeList;

    public KnifeType() {
    }

    public KnifeType(String name) {
        this.name = name;
    }

    public KnifeType(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public KnifeType(String name, String url, String description) {
        this.name = name;
        this.url = url;
        this.description = description;
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

    @Override
    public String toString() {
        return "KnifeType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
