package com.example.japanese_food.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    private String categoryName;
    private String categoryUrl;
    private boolean categoryStatus;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    private List<Product> productList;

    public Category() {
    }

    public Category(Integer categoryId, String categoryName, String categoryUrl, boolean categoryStatus, List<Product> productList) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryUrl = categoryUrl;
        this.categoryStatus = categoryStatus;
        this.productList = productList;
    }

    public Category(String categoryName, String categoryUrl, boolean categoryStatus, List<Product> productList) {
        this.categoryName = categoryName;
        this.categoryUrl = categoryUrl;
        this.categoryStatus = categoryStatus;
        this.productList = productList;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryUrl() {
        return categoryUrl;
    }

    public void setCategoryUrl(String categoryUrl) {
        this.categoryUrl = categoryUrl;
    }

    public boolean isCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(boolean categoryStatus) {
        this.categoryStatus = categoryStatus;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
