package cl.awakelab.m1spring.persistence.crud;

import cl.awakelab.m1spring.persistence.entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressCrudRepository extends CrudRepository<Address, Integer> {
}
