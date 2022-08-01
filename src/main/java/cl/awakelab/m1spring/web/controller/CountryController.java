package cl.awakelab.m1spring.web.controller;

import cl.awakelab.m1spring.domain.dto.Country;
import cl.awakelab.m1spring.domain.service.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/edit/{countryId}")
    public String countryEdit(@PathVariable("countryId") int countryId, Model model){
        model.addAttribute("country",
                service.getOne(countryId)
                        .map(country -> country)
                        .orElse(null));
        return "countryEdit";
    }
    @GetMapping("/new")
    public String countryNew(){
        return "countryNew";
    }
    @PostMapping("/save")
    public String countrySave(@ModelAttribute Country country){
        service.save(country);
        return "redirect:/country";
    }

    @GetMapping("/del/{countryId}")
    public String countryDelete(@PathVariable("countryId") int countryId){
        service.delete(countryId);
        return "redirect:/country";
    }
}
