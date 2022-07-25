package cl.awakelab.m1spring.persistence.crud;

import cl.awakelab.m1spring.persistence.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerCrudRepository extends CrudRepository<Customer, Integer> {
}
