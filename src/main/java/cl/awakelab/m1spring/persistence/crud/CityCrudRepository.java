package cl.awakelab.m1spring.persistence.crud;

import cl.awakelab.m1spring.persistence.entity.City;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityCrudRepository extends CrudRepository<City, Integer> {

    public List<City> findByCountryId(int countryId);
}
