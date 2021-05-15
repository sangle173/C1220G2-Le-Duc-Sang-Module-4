package com.example.jp_knife_manager.controller;

import com.example.jp_knife_manager.model.Brand;
import com.example.jp_knife_manager.model.Knife;
import com.example.jp_knife_manager.model.KnifeType;
import com.example.jp_knife_manager.service.BrandService;
import com.example.jp_knife_manager.service.KnifeService;
import com.example.jp_knife_manager.service.KnifeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @Autowired
    private KnifeTypeService knifeTypeService;

    @GetMapping("/knife-types")
    public String viewHomepage(Model model) {
        model.addAttribute("knifeTypes", knifeTypeService.findAll());
        return "knife_types";
    }

    @GetMapping("/knife_types/new")
    public String showKnifeTypeNewForm(Model model) {
        model.addAttribute("knifeType", new KnifeType());
        return "knife_type_form";
    }

    @PostMapping("/knife_types/save")
    public String saveKnifeType(KnifeType knifeType) {
        knifeTypeService.save(knifeType);

        return "redirect:/knife-types";
    }

    @Autowired
    private BrandService brandService;

    @GetMapping("/brands")
    public String viewBrandPage(Model model) {
        model.addAttribute("brands", brandService.findAll());
        return "brand_page";
    }

    @GetMapping("/brands/new")
    public String showBrandNewForm(Model model) {
        model.addAttribute("brand", new Brand());
        return "brand_form";
    }

    @PostMapping("/brands/save")
    public String saveBrand(Brand brand) {
        brandService.save(brand);

        return "redirect:/brands";
    }

    @Autowired
    private KnifeService knifeService;

    @GetMapping("/knives")
    public String viewKnivesPage(Model model) {
        model.addAttribute("knives", knifeService.findAll());
        model.addAttribute("knifeTypes", knifeTypeService.findAll());
        model.addAttribute("brands", brandService.findAll());
        model.addAttribute("knife", new Knife());
        return "index";
    }

    @GetMapping("/knives/new")
    public String showKnifeNewForm(Model model) {
        model.addAttribute("knife", new Knife());
        model.addAttribute("knifeTypes", knifeTypeService.findAll());
        model.addAttribute("brands", brandService.findAll());

        return "knife_form";
    }

    @PostMapping("/knives/save")
    public String saveKnife(Knife knife) {
        knifeService.save(knife);
        return "redirect:/knives";
    }

    @GetMapping("knives/view/{id}")
    public String viewKnife(Model model, @PathVariable("id") Integer id) {
        Knife knife = knifeService.findById(id);
        model.addAttribute("knife", knife);
        return "view";
    }

    @GetMapping("/knives/delete/{id}")
    public String viewDeleteConfirmPage(Model model, @PathVariable("id") Integer id) {
        Knife knife = knifeService.findById(id);
        if (knife != null) {
            model.addAttribute("knife", knife);
            return "knife_delete_confirm";
        } else {
            return "error";
        }
    }

    @PostMapping("/knives/delete")
    public String removeKnife(@ModelAttribute("knife") Knife knife, Model model) {
        knifeService.remove(knife.getId());
        model.addAttribute("message", "Successfully");
        return "redirect:/knives";
    }
}
