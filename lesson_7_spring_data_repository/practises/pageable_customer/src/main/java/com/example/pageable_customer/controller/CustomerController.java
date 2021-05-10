package com.example.pageable_customer.controller;

import com.example.pageable_customer.model.Customer;
import com.example.pageable_customer.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private CustomerServiceImpl service;

    @GetMapping("/")
    public ModelAndView listCustomers(@RequestParam("search") Optional<String> search, Pageable pageable) {
        Page<Customer> customers;
        if (search.isPresent()){
            customers=service.findAllByFirstNameContaining(search.get(),pageable);
        }else {
            customers=service.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/create-customer")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView=new ModelAndView("create");
        modelAndView.addObject("customer",new Customer());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer){
        service.save(customer);
        ModelAndView modelAndView=new ModelAndView("create");
        modelAndView.addObject("message","successfully");
        return modelAndView;
    }
}
