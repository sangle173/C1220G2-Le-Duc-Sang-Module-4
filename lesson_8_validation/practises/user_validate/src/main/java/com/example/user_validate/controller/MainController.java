package com.example.user_validate.controller;


import com.example.user_validate.model.User;
import com.example.user_validate.service.ProfessionService;
import com.example.user_validate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;


@Controller
public class MainController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProfessionService professionService;

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("professions", professionService.findAll());
        return "register_form";
    }

    @PostMapping("/register")
    public String submitForm(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        System.out.println(user);
        if (bindingResult.hasErrors()) {
            model.addAttribute("professions", professionService.findAll());
            return "register_form";
        } else {
            return "register_success";
        }
    }
}
