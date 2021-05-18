package com.example.phone_manager.controller;

import com.example.phone_manager.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private IPhoneService iPhoneService;

    @GetMapping("/")
    public String showIndex() {
        return "/index";
    }
}
