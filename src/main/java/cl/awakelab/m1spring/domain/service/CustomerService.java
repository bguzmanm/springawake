package cl.awakelab.m1spring.domain.service;

import cl.awakelab.m1spring.persistence.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    private final List<Customer> list = new ArrayList<>();

    public CustomerService() {

        list.add(new Customer(1, "Cristóbal", "Pulgar", "cristo@resucitado.org"));
        list.add(new Customer(2, "Natalia", "Ponce", "enlacocina@cocinando.org"));
        list.add(new Customer(3, "Erick", "Díaz", "eric@ironman.com"));
        list.add(new Customer(4, "Amanda", "Díaz", "tiaamanda@escuelita.tech"));

    }

    public List<Customer> getAll() {
        return list;
    }


    public Customer getOne(int customerId) {
        /*Utilizo stream y lambda para filtrar los datos*/
        return list.stream()
                .filter(c -> c.getCustomerId() == customerId) // <- esto es el lambda
                .findFirst()
                .orElse(null);
    }

}
