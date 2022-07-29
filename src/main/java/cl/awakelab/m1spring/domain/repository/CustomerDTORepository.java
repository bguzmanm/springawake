package cl.awakelab.m1spring.domain.repository;

import cl.awakelab.m1spring.domain.dto.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDTORepository {
    List<Customer> getAll();
    Optional<Customer> getOne(int customerId);
    Customer save(Customer customer);
    void delete(int customerId);
}
