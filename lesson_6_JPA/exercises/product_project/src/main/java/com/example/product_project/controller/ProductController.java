package com.example.product_project.controller;

import com.example.product_project.model.Product;
import com.example.product_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/")
    public ModelAndView showListProduct(){
        return new ModelAndView("index","products",service.findAll());
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView=new ModelAndView("create");
        modelAndView.addObject("product",new Product());
        return modelAndView;
    }

    @PostMapping("/create-product")
    public ModelAndView saveProduct(@ModelAttribute("product") Product product){
        service.save(product);
        ModelAndView modelAndView=new ModelAndView("create");
        modelAndView.addObject("product",new Product());
        modelAndView.addObject("message","successfully");
        return modelAndView;
    }
}
