package com.example.demo_case.controller;

import com.example.demo_case.model.customer.Customer;
import com.example.demo_case.service.customer.CustomerService;
import com.example.demo_case.service.customer.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;
    private final TypeService typeService;

    public CustomerController(CustomerService customerService, TypeService typeService) {
        this.customerService = customerService;
        this.typeService = typeService;
    }

    @GetMapping
    public String getCustomerPage(Model model) {
        model.addAttribute("types", typeService.findAll());
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("customer", new Customer());

        return "customer/index";
    }

    @PostMapping("/new-customer")
    private String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);

        return "redirect:/customers";
    }


    @GetMapping(value = "/delete/{id}")
    public String view(@PathVariable("id") Integer id) {
        customerService.deleteById(id);
        return "redirect:/customers";
    }

}
