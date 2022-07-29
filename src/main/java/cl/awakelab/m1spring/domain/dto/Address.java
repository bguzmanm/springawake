package cl.awakelab.m1spring.domain.dto;

import lombok.Data;

@Data
public class Address {
    private Integer addressId;
    private String address;
    private String address2;
    private String district;
    private City city;
    private String postalCode;
    private String phone;
}
