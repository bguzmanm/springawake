package cl.awakelab.m1spring.web.restController;

import cl.awakelab.m1spring.domain.dto.Country;
import cl.awakelab.m1spring.domain.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/country")
public class CountryRestController {

    private final CountryService service;

    public CountryRestController(CountryService service) {
        this.service = service;
    }
    @GetMapping("/list")
    public ResponseEntity<List<Country>> getAllCountry(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{countryId}")
    public ResponseEntity<Country> getOneById(@PathVariable("countryId") int countryId){
        return service.getOne(countryId)
                .map(country -> new ResponseEntity<>(country, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/save")
    public ResponseEntity<Country> save(@RequestBody Country country){
        return new ResponseEntity<>(service.save(country), HttpStatus.OK);
    }
    @DeleteMapping("/del/{countryId}")
    public ResponseEntity delete(@PathVariable("countryId") int countryId){
        if (service.delete(countryId)){
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


}
