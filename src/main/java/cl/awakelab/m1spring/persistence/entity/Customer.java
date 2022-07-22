package cl.awakelab.m1spring.persistence.entity;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {

    private int customerId;
    @Setter
    private String firstName;
    @Setter
    private String lastName;
    @Setter
    private String email;
}
