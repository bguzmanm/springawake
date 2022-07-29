package cl.awakelab.m1spring.domain.dto;

import lombok.Data;

@Data
public class City {

    private Integer cityId;
    private String city;
    private Integer countryId;

    private Country country;
}
