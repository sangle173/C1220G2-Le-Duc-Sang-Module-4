package com.example.controllers;

import com.example.models.Cart;
import com.example.models.Product;
import com.example.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private ProductService productService;

    @ModelAttribute("cart")
    public Cart setUpCart() {
        return new Cart();
    }

    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "index";
    }

    @GetMapping("/detail")
    public String viewDetail(@RequestParam Integer id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "detail";
    }

    @PostMapping("/detail")
    public String addToCart(@ModelAttribute("cart") Cart cart, Product product, Model model) {
        cart.addToCart(product);
        model.addAttribute("product", product);
        model.addAttribute("message", "Added product to cart successfully!");
        return "detail";
    }

    @GetMapping("/cart")
    public String viewCart() {
        return "cart";
    }

    @PostMapping("/cart")
    public String updateCart(@ModelAttribute(name = "cart") Cart cart,
                             @RequestParam(name = "changeId") Optional<Integer> changeId,
                             @RequestParam(name = "changeValue") Optional<Integer> changeValue,
                             @RequestParam(name = "deleteId") Optional<Integer> deleteId) {
        if (changeId.isPresent() && changeValue.isPresent()) {
            Product product = productService.findById(changeId.get());
            cart.changeQuantity(product, changeValue.get());
        } else if (deleteId.isPresent()) {
            Product product = productService.findById(deleteId.get());
            cart.removeProduct(product);
        }
        return "cart";
    }
}
