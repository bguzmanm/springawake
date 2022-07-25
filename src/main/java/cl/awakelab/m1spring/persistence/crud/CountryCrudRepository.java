package cl.awakelab.m1spring.persistence.crud;

import cl.awakelab.m1spring.persistence.entity.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryCrudRepository extends CrudRepository<Country, Integer> {
}
