package com.example.blog.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorys")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String categoryName;

    @OneToMany(targetEntity = Blog.class)
    private List<Blog> blogs;

    public Category() {
    }

    public Category(String categoryName, List<Blog> blogs) {
        this.categoryName = categoryName;
        this.blogs = blogs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
