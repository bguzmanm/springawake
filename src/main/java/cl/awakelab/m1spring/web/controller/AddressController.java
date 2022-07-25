package cl.awakelab.m1spring.web.controller;

import cl.awakelab.m1spring.domain.service.AddressService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("address")
public class AddressController {
    private final AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    @GetMapping
    public String listAddress(Model model){
        model.addAttribute("address", service.getAll());
        return "addressList";
    }
}
