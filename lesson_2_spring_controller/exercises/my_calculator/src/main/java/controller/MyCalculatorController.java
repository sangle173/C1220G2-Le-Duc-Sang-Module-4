package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.ICalService;

@Controller
public class MyCalculatorController {
    @Autowired
    private ICalService iCalService;
    @GetMapping("/")
    public String getCalculator() {
        return "index";
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam(defaultValue = "0") double num1,
                            @RequestParam(defaultValue = "0") double num2,
                            @RequestParam String operator, Model model) {
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("operator", operator);
        try {
            model.addAttribute("result", iCalService.calculation(num1, num2, operator));
        } catch (ArithmeticException e) {
            model.addAttribute("result", e.getMessage());
        }
        return "index";
    }
}
