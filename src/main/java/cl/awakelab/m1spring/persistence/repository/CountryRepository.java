package cl.awakelab.m1spring.persistence.repository;

import cl.awakelab.m1spring.persistence.crud.CountryCrudRepository;
import cl.awakelab.m1spring.persistence.entity.Country;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CountryRepository {
    private final CountryCrudRepository crudRepository;

    public CountryRepository(CountryCrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    public List<Country> getAll(){
        return (List<Country>) crudRepository.findAll();
    }

    public Optional<Country> getOne(int countryId){
        return crudRepository.findById(countryId);
    }

    public Country save(Country country){
        return crudRepository.save(country);
    }

    public void delete(int countryId){
        crudRepository.deleteById(countryId);
    }

}
