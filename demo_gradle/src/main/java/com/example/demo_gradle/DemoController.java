package com.example.demo_gradle;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController{

    @GetMapping("")
    public String getHome(Model model){

        model.addAttribute("")

        return "demo";
    }
}
