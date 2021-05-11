package com.example.user_validate.controller;


import com.example.user_validate.model.Profession;
import com.example.user_validate.model.User;
import com.example.user_validate.service.ProfessionService;
import com.example.user_validate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProfessionService professionService;

    @GetMapping("/")
    public ModelAndView userList() {
        return new ModelAndView("index", "users", userService.findAll());
    }

    @GetMapping("/register")
    public ModelAndView showRegisterForm() {
        return new ModelAndView("create", "user", new User());
    }

    @PostMapping("/register")
    public ModelAndView submitForm(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("create");
        } else {
            userService.save(user);
            ModelAndView modelAndView = new ModelAndView("index");
            modelAndView.addObject("message", "successfully");
            return modelAndView;
        }
    }

    @ModelAttribute("professions")
    public List<Profession> professions() {
        return professionService.findAll();
    }
}
