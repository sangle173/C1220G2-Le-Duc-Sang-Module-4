package com.example.demo_ajax.controller;

import com.example.demo_ajax.exeption.GuestFoundException;
import com.example.demo_ajax.model.Guest;
import com.example.demo_ajax.model.HotelData;
import com.example.demo_ajax.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HotelController {

    private static final String HOME_VIEW = "home";
    private static final String RESULTS_FRAGMENT = "results :: resultsList";
    @Autowired
    private HotelService hotelService;

    @ModelAttribute("guest")
    public Guest prepareGuestModel() {
        return new Guest();
    }

    @ModelAttribute("hotelData")
    public HotelData prepareHotelDataModel() {
        return hotelService.getHotelData();
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showHome(Model model) {
        prepareHotelDataModel();
        prepareGuestModel();
        return HOME_VIEW;
    }


    @RequestMapping(value = "/guests/{surname}", method = RequestMethod.GET)
    public String showGuestList(Model model, @PathVariable("surname") String surname) {
        model.addAttribute("guests", hotelService.getGuestsList(surname));

        return RESULTS_FRAGMENT;
    }

    @RequestMapping(value = "/guests", method = RequestMethod.GET)
    public String showGuestList(Model model) {
        model.addAttribute("guests", hotelService.getGuestsList());

        return RESULTS_FRAGMENT;
    }

    @RequestMapping(value = "/guests/insert", method = RequestMethod.POST)
    public String insertGuest(Guest newGuest, Model model) {
        hotelService.insertNewGuest(newGuest);

        return showHome(model);
    }
    @ExceptionHandler({GuestFoundException.class})
    public ModelAndView handleDatabaseError(GuestFoundException e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("errorMessage", "error.user.exist");
        modelAndView.addObject("guest", prepareGuestModel());
        modelAndView.addObject("hotelData", prepareHotelDataModel());

        return modelAndView;
    }

}
