package cl.awakelab.m1spring.persistence.crud;

import cl.awakelab.m1spring.persistence.entity.CityEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityCrudRepository extends CrudRepository<CityEntity, Integer> {

        public List<CityEntity> findByCountryId(int countryId);
}
