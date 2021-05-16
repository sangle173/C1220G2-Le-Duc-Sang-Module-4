package com.example.shopping_cart.controller;

import com.example.shopping_cart.model.Cart;
import com.example.shopping_cart.model.Product;
import com.example.shopping_cart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Controller
@SessionAttributes("cart")
public class MainController {

    @Autowired
    private ProductService service;

    @ModelAttribute("cart")
    public Cart setUpCart(@CookieValue(name = "cartCookie", defaultValue = "") String cartCookie) {
        return readCartCookie(cartCookie);
    }

    @GetMapping("/")
    private String showProductPage(@ModelAttribute("cart") Cart cart, Model model) {
        model.addAttribute("products", service.findAll());
        return "index";
    }

    @GetMapping("/view/{id}")
    public String viewDetail(@PathVariable Long id, Model model) {
        model.addAttribute("product", service.findById(id));
        return "view";
    }

    @GetMapping("/cart")
    public String viewCart(@ModelAttribute("cart") Cart cart) {
        return "cart";
    }

    @PostMapping("/cart")
    public String updateCart(@ModelAttribute(name = "cart") Cart cart,
                             @RequestParam(name = "changeId") Optional<Long> changeId,
                             @RequestParam(name = "changeValue") Optional<Long> changeValue,
                             @RequestParam(name = "deleteId") Optional<Long> deleteId,
                             @CookieValue(name = "cartCookie", defaultValue = "") String cartCookieValue,
                             HttpServletResponse response) {
        if (changeId.isPresent() && changeValue.isPresent()) {
            Product product = service.findById(changeId.get());
            cart.changeQuantity(product, changeValue.get());
        } else if (deleteId.isPresent()) {
            Product product = service.findById(deleteId.get());
            cart.removeProduct(product);
        }

        Cookie cookie = new Cookie("cartCookie", createCartString(cart));
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);

        return "cart";
    }
    @PostMapping("/view")
    public String addToCart(@ModelAttribute("cart") Cart cart,
                            @CookieValue(name = "cartCookie", defaultValue = "") String cartCookieValue,
                            Product product, Model model, HttpServletResponse response) {
        cart.addToCart(product);

        Cookie cookie = new Cookie("cartCookie", createCartString(cart));
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);

        model.addAttribute("product", product);
        model.addAttribute("message", "successfully!");
        return "view";
    }


    public String createCartString(Cart cart) {
        Set<Map.Entry<Product, Long>> products = cart.getProducts().entrySet();
        StringBuilder cartStr = new StringBuilder();
        for (Map.Entry<Product, Long> product : products) {
            cartStr.append("-").append(product.getKey().getId()).append("-").append(product.getValue());
        }
        cartStr.deleteCharAt(0);
        return cartStr.toString();
    }

    public Cart readCartCookie(String cookieValueStr) {
        Cart cart = new Cart();
        if (!cookieValueStr.equals("")) {
            Map<Product, Long> products = new HashMap<>();
            String[] cookieValue = cookieValueStr.split("-");
            for (int i = 0; i < cookieValue.length; i += 2) {
                Product product = service.findById(Long.parseLong(cookieValue[i]));
                if (product != null) {
                    products.put(product, Long.parseLong(cookieValue[i + 1]));
                }
            }
            cart.setProducts(products);
        }
        return cart;
    }
}
