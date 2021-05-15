package com.example.product_management_bonus.controller;

import com.example.product_management_bonus.model.Category;
import com.example.product_management_bonus.repository.CategoryRepository;
import com.example.product_management_bonus.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String viewHomePage(Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categories", categoryList);
        return "categories";
    }

    @GetMapping("/categories/new")
    public String showCategoryNewFrom(Model model) {
        model.addAttribute("category", new Category());

        return "category_form";
    }

    @PostMapping("/categories/save")
    public String saveCategory(Category category) {
        categoryService.save(category);

        return "redirect:/categories";
    }
}
