package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.ConvertCoinImpl;
import service.IConvert;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ConvertCoinController {
    @RequestMapping("/")
    public String convertCoin() {
        return "list";
    }

    @RequestMapping(value = "/view", method = RequestMethod.POST)
    @ResponseBody
    public String convertCoin(@RequestParam("usd") double usd) {
        double vnd = usd * 23000;
        return "Result :" + usd + "-usd =" + vnd+"-vnd";
    }
}
