package com.codegym.model;

public class Product {
    private Integer id;
    private String name;
    private Double price;
    private String description;
    private String publish;

    public Product() {
    }

    public Product(String name, Double price, String description, String publish) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.publish = publish;
    }

    public Product(Integer id, String name, Double price, String description, String publish) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.publish = publish;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", publish='" + publish + '\'' +
                '}';
    }
}
