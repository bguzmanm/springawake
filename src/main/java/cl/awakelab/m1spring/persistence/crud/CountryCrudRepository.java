package cl.awakelab.m1spring.persistence.crud;

import cl.awakelab.m1spring.persistence.entity.CountryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CountryCrudRepository extends CrudRepository<CountryEntity, Integer> {
}
