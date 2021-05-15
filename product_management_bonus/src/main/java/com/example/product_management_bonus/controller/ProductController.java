package com.example.product_management_bonus.controller;

import com.example.product_management_bonus.model.Category;
import com.example.product_management_bonus.model.Product;
import com.example.product_management_bonus.service.CategoryService;
import com.example.product_management_bonus.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/products")
    public String viewProductPage(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @GetMapping("/products/new")
    public String showNewProductNewForm(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("product", new Product());
        return "product_form";
    }

    @PostMapping("/products/save")
    public String saveProduct(Product product){
        productService.save(product);

        return "redirect:/products";
    }

    @GetMapping("/products/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Integer id, Model model){
        Product product=productService.findById(id);
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categories", categoryList);
        model.addAttribute("product",product);
        return "product_form";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id, Model model){
        productService.deleteById(id);

        return "redirect:/products";
    }
}
