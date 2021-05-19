package com.example.phone_manager.controller;

import com.example.phone_manager.model.Phone;
import com.example.phone_manager.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Phone> deleteSmartphone(@PathVariable Long id) {
        Phone smartphone = iPhoneService.findById(id);
        if (smartphone==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iPhoneService.remove(id);
        return new ResponseEntity<>(smartphone, HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView editSmartphonePage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Phone phone = iPhoneService.findById(id);
        modelAndView.addObject("phoneExist", phone);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Phone editPhone(@PathVariable Long id, @RequestBody Phone phone) {
        phone.setId(id);
        return iPhoneService.save(phone);
    }
}
