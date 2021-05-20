package com.example.blog_i18n.controller;

import com.example.blog_i18n.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "list";
    }
}
