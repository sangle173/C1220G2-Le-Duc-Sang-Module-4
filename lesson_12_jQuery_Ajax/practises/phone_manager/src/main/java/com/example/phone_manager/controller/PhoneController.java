package com.example.phone_manager.controller;

import com.example.phone_manager.model.Phone;
import com.example.phone_manager.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/phones")
public class PhoneController {

    @Autowired
    private IPhoneService iPhoneService;

    @PostMapping
    public ResponseEntity<Phone> createPhone(@RequestBody Phone phone) {
        return new ResponseEntity<>(iPhoneService.save(phone), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ModelAndView getAllPhonePage() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("phones", iPhoneService.findAll());
        return modelAndView;
    }

    @GetMapping
    public ResponseEntity<List<Phone>> allPhones() {
        return new ResponseEntity<>(iPhoneService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Phone> deleteSmartphone(@PathVariable Long id) {
        Phone smartphone = iPhoneService.findById(id);
        if (smartphone==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iPhoneService.remove(id);
        return new ResponseEntity<>(smartphone, HttpStatus.NO_CONTENT);
    }
}
