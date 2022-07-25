package cl.awakelab.m1spring.web.controller;

import cl.awakelab.m1spring.domain.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/city")
public class CityController {

    private final CityService service;

    public CityController(CityService service) {
        this.service = service;
    }

    @GetMapping
    public String getCities(Model model){
        model.addAttribute("cities", service.getAll());
        return "citiesList";
    }
}
