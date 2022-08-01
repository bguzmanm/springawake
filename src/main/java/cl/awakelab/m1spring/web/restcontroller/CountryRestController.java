package cl.awakelab.m1spring.web.restcontroller;

import cl.awakelab.m1spring.domain.dto.Country;
import cl.awakelab.m1spring.domain.service.CountryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiOperation("Return all Countries")
    @ApiResponse(code = 200, message = "Ok")
    public ResponseEntity<List<Country>> getAllCountry(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{countryId}")
    @ApiOperation("Return Country by countryId")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "Country not found")
    })
    public ResponseEntity<Country> getOneById(@ApiParam(value = "The id of Country", required = true)
                                                  @PathVariable("countryId") int countryId){
        return service.getOne(countryId)
                .map(country -> new ResponseEntity<>(country, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/save")
    @ApiOperation("Save a Country")
    @ApiResponse(code = 200, message = "Country save")
    public ResponseEntity<Country> save(@ApiParam(value = "The Country", required = true)
                                            @RequestBody Country country){
        return new ResponseEntity<>(service.save(country), HttpStatus.OK);
    }
    @DeleteMapping("/del/{countryId}")
    @ApiOperation("Delete a Country")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "Country not found"),
    })
    public ResponseEntity delete(@ApiParam(value = "the country id", required = true)
                                     @PathVariable("countryId") int countryId){
        if (service.delete(countryId)){
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


}
