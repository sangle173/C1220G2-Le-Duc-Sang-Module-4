package com.example.blog_ajax.repositories;

import com.example.blog_ajax.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
}
