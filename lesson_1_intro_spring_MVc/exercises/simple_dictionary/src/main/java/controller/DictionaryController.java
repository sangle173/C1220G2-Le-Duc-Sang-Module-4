package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    static Map<String,String> dictionary;

    static {
        dictionary=new HashMap<>();
        dictionary.put("hello","xin chao");
        dictionary.put("dictionary","tu dien");
        dictionary.put("key","chia khoa");
        dictionary.put("book","sach");
        dictionary.put("computer","may tinh");
        dictionary.put("keyboard","ban phim");
        dictionary.put("screen","man hinh");
        dictionary.put("phone","dien thoai");
        dictionary.put("house","ngoi nha");
        dictionary.put("employee","nhan vien");
        dictionary.put("fish","ca");
        dictionary.put("salmon","ca hoi");
        dictionary.put("chair","cai ghe");
        dictionary.put("classmate","ban hoc");
    }

    @GetMapping("/")
    public String getForm() {
        return "index";
    }

    @GetMapping("/translate")
    public String translate(@RequestParam String word, Model model){
        String vietnameseMean=dictionary.get(word);
        model.addAttribute("vietnameseMean",vietnameseMean);
        return "index";
    }
}
