package cl.awakelab.m1spring.web.restcontroller;

import cl.awakelab.m1spring.domain.dto.City;
import cl.awakelab.m1spring.domain.service.CityService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityRestController {

    private final CityService service;

    public CityRestController(CityService service) {
        this.service = service;
    }

    @GetMapping("/list")
    @ApiOperation("Return all cities")
    @ApiResponse(code = 200, message = "Ok")
    public ResponseEntity<List<City>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{cityId}")
    @ApiOperation("Return a City by cityId")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "City not found")
    })
    public ResponseEntity<City> getOne(@ApiParam(value = "The id of a city") @PathVariable("cityId") int cityId){
        return service.getOne(cityId)
                .map(city -> new ResponseEntity<>(city, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
