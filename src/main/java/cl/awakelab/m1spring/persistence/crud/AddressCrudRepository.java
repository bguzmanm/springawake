package cl.awakelab.m1spring.persistence.crud;

import cl.awakelab.m1spring.persistence.entity.AddressEntity;
import org.springframework.data.repository.CrudRepository;

public interface AddressCrudRepository extends CrudRepository<AddressEntity, Integer> {
}
