package com.example.japanese_food.controller;

import com.example.japanese_food.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public ModelAndView getProductList() {
        return new ModelAndView("index", "products", productService.findAll());
    }
}
