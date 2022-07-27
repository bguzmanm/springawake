package cl.awakelab.m1spring.web.controller;

import cl.awakelab.m1spring.domain.service.CustomerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    Log logger = LogFactory.getLog(CustomerController.class);
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }


    @GetMapping
    public String getCustomers(Model model){
        model.addAttribute("customers", service.getAll());
        model.addAttribute("nombre", "Brian");
        return "customerList";
    }

    @GetMapping("/{id}")
    public String getCustomer(@PathVariable("id") int customerId, Model model){
        logger.warn(service.getOne(customerId).toString());
        model.addAttribute("customer", service.getOne(customerId).get());
        return "customer";
    }

}
