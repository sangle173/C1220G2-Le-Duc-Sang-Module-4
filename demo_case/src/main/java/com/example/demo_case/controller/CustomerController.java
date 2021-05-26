package com.example.demo_case.controller;

import com.example.demo_case.model.customer.Customer;
import com.example.demo_case.repositories.customer.CustomerRepository;
import com.example.demo_case.service.customer.CustomerService;
import com.example.demo_case.service.customer.TypeService;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;
    private final TypeService typeService;
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/")
    public ResponseEntity<List<Customer>> searchCustomers(@SearchSpec Specification<Customer> specs) {
        return new ResponseEntity<>(customerRepository.findAll(Specification.where(specs)), HttpStatus.OK);
    }

    public CustomerController(CustomerService customerService, TypeService typeService) {
        this.customerService = customerService;
        this.typeService = typeService;
    }

    @RequestMapping
    public String viewHomePage(Model model) {
        String keyword = null;
        return viewPage(model, 1, "name", "asc", keyword);
    }

    @RequestMapping("/page/{pageNum}")
    public String viewPage(Model model,
                           @PathVariable(name = "pageNum") int currentPage,
                           @Param(("sortField")) String sortField,
                           @Param(("sortDir")) String sortDir,
                           @Param("keyword") String keyword) {
        Page<Customer> page = customerService.findAll(currentPage, sortField, sortDir, keyword);
        List<Customer> customerList = page.getContent();
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("customers", customerList);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("keyword", keyword);
        model.addAttribute("types", typeService.findAll());
        model.addAttribute("customer", new Customer());
        return "customer/index";

    }

    @GetMapping("/search")
    public String searchCustomer(Model model,
                                 @RequestParam(value = "nameSearch", required = false) String nameSearch,
                                 @RequestParam(value = "emailSearch", required = false) String emailSearch) {
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("emailSearch", emailSearch);
        model.addAttribute("customers", customerService.findByField(nameSearch, emailSearch));
        return "customer/index";
    }

    @PostMapping("/new-customer")
    private String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);

        return "redirect:/customers/";
    }


    @GetMapping(value = "/delete/{id}")
    public String view(@PathVariable("id") Integer id) {
        customerService.deleteById(id);
        return "redirect:/customers/";
    }

}
