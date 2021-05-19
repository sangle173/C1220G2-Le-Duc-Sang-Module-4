package com.example.blog_ajax.controller;

import com.example.blog_ajax.model.Blog;
import com.example.blog_ajax.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/blogs")
public class AjaxController {
    @Autowired
    private BlogService blogService;

    @PostMapping
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
        return new ResponseEntity<>(blogService.save(blog), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ModelAndView showAll(){
        ModelAndView mv=new ModelAndView("list");
        mv.addObject("blogs",blogService.findAll());
        return mv;
    }

    @GetMapping
    public ResponseEntity<List<Blog>> allPhones() {
        return new ResponseEntity<>(blogService.findAll(), HttpStatus.OK);
    }

}
