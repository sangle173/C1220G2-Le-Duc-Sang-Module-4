package com.example.blog_ajax.service;

import com.example.blog_ajax.model.Blog;
import com.example.blog_ajax.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogRepository repository;

    public List<Blog> findAll() {
        return repository.findAll();
    }

    public Blog findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Blog save(Blog blog) {
       return repository.save(blog);
    }
}
