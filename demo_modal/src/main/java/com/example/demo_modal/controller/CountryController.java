package com.example.demo_modal.controller;

import com.example.demo_modal.model.Country;
import com.example.demo_modal.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CountryController {

    @Autowired
    private CountryRepository repository;

    @GetMapping("/")
    public String showPage(Model model, @RequestParam(defaultValue = "0") Integer page){
        model.addAttribute("data",repository.findAll(new PageRequest(page,4)));
        return "index";
    }
}
