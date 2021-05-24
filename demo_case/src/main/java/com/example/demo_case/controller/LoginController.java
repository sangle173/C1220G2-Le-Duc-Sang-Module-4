package com.example.demo_case.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        if (authentication==null|| authentication instanceof AnonymousAuthenticationToken){
            return "login/login";
        }
        return "redirect:/employees";
    }
    @GetMapping("/403")
    public String error403() {
        return "login/403";
    }
}
