package com.example.demo_case.controller;

import com.example.demo_case.model.customer.Customer;
import com.example.demo_case.model.service_hotel.ServiceHotel;
import com.example.demo_case.service.customer.CustomerService;
import com.example.demo_case.service.customer.TypeService;
import com.example.demo_case.service.service_hotel.RentalTypeService;
import com.example.demo_case.service.service_hotel.ServiceHotelService;
import com.example.demo_case.service.service_hotel.ServiceTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/services")
public class ServiceHotelController {
    private final ServiceHotelService serviceHotelService;
    private final RentalTypeService rentalTypeService;
    private final ServiceTypeService serviceTypeService;

    public ServiceHotelController(ServiceHotelService serviceHotelService, RentalTypeService rentalTypeService, ServiceTypeService serviceTypeService) {
        this.serviceHotelService = serviceHotelService;
        this.rentalTypeService = rentalTypeService;
        this.serviceTypeService = serviceTypeService;
    }

    @GetMapping
    public String getCustomerPage(Model model) {
        model.addAttribute("services", serviceHotelService.findAll());
        model.addAttribute("rentalTypes", rentalTypeService.findAll());
        model.addAttribute("serviceTypes", serviceTypeService.findAll());
        model.addAttribute("serviceHotel", new ServiceHotel());

        return "service_hotel/index";
    }

    @PostMapping("/new-service-hotel")
    private String saveServiceHotel(@ModelAttribute("serviceHotel") ServiceHotel serviceHotel) {
        serviceHotelService.save(serviceHotel);

        return "redirect:/services";
    }
}
