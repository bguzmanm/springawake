package cl.awakelab.m1spring.domain.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class Customer {
    private Integer customerId;
    private Store store;
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
    private Boolean active;
    private LocalDate createDate;
}
