package com.example.form_handilng.controller;

import com.example.form_handilng.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        List<String> professionList = Arrays.asList("Developer", "Chef", "Waiter");
        model.addAttribute("professions", professionList);
        return "register_form";
    }

    @PostMapping("/register")
    public String submitForm(@Validated @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            List<String> professionList = Arrays.asList("Developer", "Chef", "Waiter");
            model.addAttribute("professions",professionList);
            return "register_form";
        } else {
            return "register_success";
        }
    }
}
