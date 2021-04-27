package controller;

import model.bean.Customer;
import model.service.CustomerService;
import model.service.CustomerServiceFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CustomerController {
    private CustomerService customerService= CustomerServiceFactory.getInstance();
    @GetMapping("/customers")
    public String showList(HttpServletRequest request) {
        List<Customer> customers=customerService.findAll();
        request.setAttribute("customers",customers);
        return "/list";
    }
}
