package com.example.product_management_exercises.controller;

import com.example.product_management_exercises.model.Cart;
import com.example.product_management_exercises.model.Category;
import com.example.product_management_exercises.model.Product;
import com.example.product_management_exercises.service.imple.CategoryService;
import com.example.product_management_exercises.service.imple.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class AppController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        String keyword = null;
        return viewPage(model, 1, "name", "asc", keyword);
    }

    @GetMapping("/category/new")
    public String showCreateCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "category_form";
    }

    @RequestMapping(value = "/category/save", method = RequestMethod.POST)
    public String saveCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories")
    public String showCategories(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "categories";
    }

    @RequestMapping("/page/{pageNum}")
    public String viewPage(Model model,
                           @PathVariable(name = "pageNum") int currentPage,
                           @Param("sortField") String sortField,
                           @Param("sortDir") String sortDir,
                           @Param("keyword") String keyword) {

        Page<Product> page = productService.findAll(currentPage, sortField, sortDir, keyword);

        List<Product> productList = page.getContent();

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("productList", productList);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("keyword", keyword);
        model.addAttribute("categories", categoryService.findAll());

        return "index";
    }

    @RequestMapping("/new")
    public String showNewProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.findAll());
        return "new_product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product, HttpServletRequest request) {
        String[] detailName = request.getParameterValues("detailName");
        String[] detailValue = request.getParameterValues("detailValue");
        for (int i = 0; i < detailName.length; i++) {
            product.addDetails(detailName[i], detailValue[i]);
        }
        productService.save(product);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("edit_product");
        Product product = productService.findById(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String showDeleteProductForm(@PathVariable(name = "id") Long id) {
        productService.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping("/view/{id}")
    public String showProduct(@PathVariable(name = "id") Long id, Model model) {

        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "view";
    }

    @GetMapping("/add-to-cart/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action){
        Product product=productService.findById(id);
        if (product==null){
            return "/error.404";
        }
        if (action.equals("show")){
            cart.addProduct(product);
            return "redirect:/shopping-cart";
        }
        cart.addProduct(product);
        return "redirect:/";
    }
}
