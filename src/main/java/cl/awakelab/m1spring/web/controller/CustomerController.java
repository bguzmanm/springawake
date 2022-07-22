package cl.awakelab.m1spring.web.controller;

import cl.awakelab.m1spring.domain.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping
    public String getCustomers(Model model){
        CustomerService cs = new CustomerService();
        model.addAttribute("customers", cs.getAll());
        model.addAttribute("nombre", "Brian");
        return "customerList";
    }

    @GetMapping("/{id}")
    public String getCustomer(@PathVariable("id") int customerId, Model model){
        CustomerService cs = new CustomerService();
        model.addAttribute("customer", cs.getOne(customerId));
        return "customer";
    }

}
