package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CondimentController {
    @GetMapping("/")
    public String getHomePage() {
        return "index";
    }

    @GetMapping("/save")
    public String save(@RequestParam(value = "condiment", defaultValue = "None") String[] condiments, Model model) {
        model.addAttribute("condiments", condiments);
        model.addAttribute("message", "Saved");
        return "index";
    }
}
