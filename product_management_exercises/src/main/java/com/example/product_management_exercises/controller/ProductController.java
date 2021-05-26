package com.example.product_management_exercises.controller;

import com.example.product_management_exercises.service.imple.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
//
//    @GetMapping("/product/list")
//    public String viewList(Model model){
//
//        return
//    }
    @GetMapping("/search")
    public String searching(Model model,
                            @RequestParam(value = "nameSearch", required = false) String nameSearch,
                            @RequestParam(value = "categoryName", required = false) String categoryName,
                            @RequestParam(value = "brandSearch", required = false) String brandSearch
    ) {
        model.addAttribute("nameSearch",nameSearch);
        model.addAttribute("categoryName",categoryName);
        model.addAttribute("brandSearch",brandSearch);
        model.addAttribute("products",productService.findByNameCategoryBrand(nameSearch,categoryName,brandSearch));
        return "list";
    }
}
