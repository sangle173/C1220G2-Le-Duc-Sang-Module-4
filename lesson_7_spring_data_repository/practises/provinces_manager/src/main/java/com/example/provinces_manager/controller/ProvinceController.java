package com.example.provinces_manager.controller;

import com.example.provinces_manager.model.Province;
import com.example.provinces_manager.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/provinces")
    public ModelAndView listProvinces() {
        List<Province> provinces = provinceService.findAll();
        ModelAndView modelAndView = new ModelAndView("/provinces");
        modelAndView.addObject("provinces", provinces);
        return modelAndView;
    }

    @GetMapping("/create-province")
    public ModelAndView showCreateProvinceForm() {
        ModelAndView modelAndView = new ModelAndView("create.provinces");
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }

    @PostMapping("/create-province")
    public ModelAndView saveProvince(@ModelAttribute("province") Province province) {
        provinceService.save(province);
        ModelAndView modelAndView = new ModelAndView("create.provinces");
        modelAndView.addObject("message", "successfully");
        return modelAndView;
    }

    @GetMapping("edit-province/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id) {
        Province province = provinceService.findById(id);
        ModelAndView modelAndView;
        if (province != null) {
            modelAndView = new ModelAndView("edit.province");
            modelAndView.addObject("province", province);
            return modelAndView;
        } else {
            modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("edit-province")
    public ModelAndView updateProvince(@ModelAttribute("province") Province province) {
        provinceService.save(province);

        ModelAndView modelAndView = new ModelAndView("edit.province");
        modelAndView.addObject("message", "successfully");
        return modelAndView;
    }
}
