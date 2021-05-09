package com.example.provinces_manager.controller;

import com.example.provinces_manager.model.Customer;
import com.example.provinces_manager.model.Province;
import com.example.provinces_manager.service.CustomerService;
import com.example.provinces_manager.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService service;

    @Autowired
    private ProvinceService provinceService;
    @GetMapping("/")
    public ModelAndView listCustomer(){
        List<Customer> customers=service.findAll();
        ModelAndView modelAndView=new ModelAndView("index");
        modelAndView.addObject("customers",customers);
        return modelAndView;
    }

    @GetMapping("/create-customer")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView=new ModelAndView("/create");
        modelAndView.addObject("customer",new Customer());
        return modelAndView;
    }

    @ModelAttribute("provinces")
    public List<Province> provinces(){
        return provinceService.findAll();
    }

}
