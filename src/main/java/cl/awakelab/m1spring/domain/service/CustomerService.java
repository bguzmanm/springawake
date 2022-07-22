package cl.awakelab.m1spring.domain.service;

import cl.awakelab.m1spring.persistence.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    private List<Customer> lista = new ArrayList<Customer>();

    public CustomerService() {
        lista.add(new Customer(1, "Cristóbal", "Pulgar", "cristo@resucitado.org"));
        lista.add(new Customer(2, "Natalia", "Ponce", "enlacocina@cocinando.org"));
        lista.add(new Customer(3, "Erick", "Díaz", "eric@ironman.com"));
        lista.add(new Customer(4, "Amanda", "Díaz", "tiaamanda@escuelita.tech"));
    }

    public List<Customer> getAll(){
        return lista;
    }

    public Customer getOne(int customerId){
        int este = -1;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCustomerId() == customerId){
                este = i;
            }
        }
        if (este != -1){
            return lista.get(este);
        } else {
            return null;
        }

    }




}
