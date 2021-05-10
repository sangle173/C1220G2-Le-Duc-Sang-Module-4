package com.example.blog.service;


import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IBlogService<E> {
    Page<E> findAll(Pageable pageable);

    E findById(Integer id);

    void save(E e);

    void remove(Integer id);

    Page<Blog> searchInTitle(String s, Pageable pageable);
}
