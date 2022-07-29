package cl.awakelab.m1spring.domain.dto;

import lombok.Data;

@Data
public class Store {
    private Integer storeId;
    private Integer managerStaffId;
    private Address address;
}
