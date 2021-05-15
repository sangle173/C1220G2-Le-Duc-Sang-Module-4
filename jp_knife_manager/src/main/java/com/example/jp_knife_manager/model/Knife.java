package com.example.jp_knife_manager.model;

import javax.persistence.*;

@Entity
@Table(name = "knifes")
public class Knife {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Float price;
    private String description;
    private String url;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "knife_type_id")
    private KnifeType knifeType;

    public Knife(String name, Float price, String description, Brand brand, KnifeType knifeType) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.brand = brand;
        this.knifeType = knifeType;
    }

    public Knife(String name, Float price, String description, String url, Brand brand, KnifeType knifeType) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.url = url;
        this.brand = brand;
        this.knifeType = knifeType;
    }

    public Knife() {
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public KnifeType getKnifeType() {
        return knifeType;
    }

    public void setKnifeType(KnifeType knifeType) {
        this.knifeType = knifeType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
