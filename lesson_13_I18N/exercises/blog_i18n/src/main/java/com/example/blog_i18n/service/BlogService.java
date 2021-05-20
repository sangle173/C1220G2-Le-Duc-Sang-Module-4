package com.example.blog_i18n.service;

import com.example.blog_i18n.model.Blog;
import com.example.blog_i18n.repositories.BlogRepository;
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

    public void save(Blog blog) {
        repository.save(blog);
    }
}
