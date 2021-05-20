package com.example.login_i18n.controller;

import com.example.login_i18n.model.User;
import com.example.login_i18n.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String getIndex(Model model){
        model.addAttribute("user",new User());
        return "login";
    }

    @GetMapping("/dashboard")
    public String getDashboard(Model model){
        model.addAttribute("users",userService.getUserList());
        return "dashboard";
    }
}
