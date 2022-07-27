package cl.awakelab.m1spring.web.controller;

import cl.awakelab.m1spring.domain.service.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/country")
public class CountryController {

    private final CountryService service;

    public CountryController(CountryService service) {
        this.service = service;
    }

    @GetMapping
    public String countryList(Model model){
        model.addAttribute("countries", service.getAll());
        return "countryList";
    }
}
