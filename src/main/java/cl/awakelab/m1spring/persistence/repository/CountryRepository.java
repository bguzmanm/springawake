package cl.awakelab.m1spring.persistence.repository;

import cl.awakelab.m1spring.persistence.crud.CountryCrudRepository;
import cl.awakelab.m1spring.persistence.entity.Country;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryRepository {
    private final CountryCrudRepository crudRepository;

    public CountryRepository(CountryCrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    public List<Country> getAll(){
        return (List<Country>) crudRepository.findAll();
    }
}
