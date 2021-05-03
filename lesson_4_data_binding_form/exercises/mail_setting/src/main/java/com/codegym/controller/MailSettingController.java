package com.codegym.controller;

import com.codegym.model.MailSetting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MailSettingController {
    private static MailSetting setting;
    private static List<String> languages;
    private static List<Integer> pageSizes;

    static {
        setting = new MailSetting();
        languages = new ArrayList<>();
        pageSizes = new ArrayList<>();
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
        pageSizes.add(5);
        pageSizes.add(10);
        pageSizes.add(15);
        pageSizes.add(25);
        pageSizes.add(50);
        pageSizes.add(100);
    }

    @GetMapping
    public String getHomePage() {
        return "index";
    }

    @GetMapping("settings")
    public ModelAndView openSettings() {
        ModelAndView modelAndView = new ModelAndView("settings", "mailSetting", setting);
        modelAndView.addObject("languages", languages);
        modelAndView.addObject("pageSizes", pageSizes);
        return modelAndView;
    }


    @PostMapping("settings/save")
    public ModelAndView save(@ModelAttribute MailSetting mailSetting) {
        setting = mailSetting;
        ModelAndView modelAndView = openSettings();
        modelAndView.addObject("message", "Updated");
        return modelAndView;
    }

    @GetMapping("settings/reset")
    public ModelAndView reset() {
        setting = new MailSetting();
        return openSettings();
    }
}
