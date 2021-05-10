package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.BlogService;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public String listBlogs(@RequestParam Optional<String> key, @RequestParam Optional<String> order,
                            @PageableDefault(value = 2) Pageable pageable, Model model ){
        Page<Blog> blogs;
        if (order.isPresent()){
            if (order.get().equals("asc")) {
                pageable = PageRequest.of(pageable.getPageNumber(), 2, Sort.by("title").ascending());
            } else {
                pageable = PageRequest.of(pageable.getPageNumber(), 2, Sort.by("title").descending());
            }
            model.addAttribute("order", order.get());
        }
        if (key.isPresent() && !key.get().trim().equals("")) {
            model.addAttribute("key", key.get());
            blogs = blogService.searchInTitle(key.get(), pageable);
        } else {
            blogs = blogService.findAll(pageable);
        }
        model.addAttribute("blogs", blogs);
        return "index";
    }

    @GetMapping("/create-blog")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public ModelAndView saveBlog(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("message", "successfully");
        return modelAndView;
    }

//    @ModelAttribute("categories")
//    public List<Category> categories() {
//        return categoryService.findAll();
//    }

}
