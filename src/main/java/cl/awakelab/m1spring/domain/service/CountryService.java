package cl.awakelab.m1spring.domain.service;


import cl.awakelab.m1spring.domain.dto.Country;
import cl.awakelab.m1spring.domain.repository.CountryDTORepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private final CountryDTORepository repository;

    public CountryService(CountryDTORepository repository) {
        this.repository = repository;
    }


    public List<Country> getAll(){
        return repository.getAll();
    }

    public Optional<Country> getOne(int countryId){
        return repository.getOne(countryId);
    }

    public Country save(Country country){
        return repository.save(country);
    }
    public boolean delete(int countryId){
        return getOne(countryId).map(country -> {
                   repository.delete(countryId);
                   return true;
                }).orElse(false);

/*        if (getOne(countryId).isPresent()){
            repository.delete(countryId);
            return true;
        } else {
            return false;
        }*/
    }

}
