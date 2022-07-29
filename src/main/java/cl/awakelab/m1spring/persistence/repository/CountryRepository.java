package cl.awakelab.m1spring.persistence.repository;

import cl.awakelab.m1spring.domain.dto.Country;
import cl.awakelab.m1spring.domain.repository.CountryDTORepository;
import cl.awakelab.m1spring.persistence.crud.CountryCrudRepository;
import cl.awakelab.m1spring.persistence.entity.CountryEntity;
import cl.awakelab.m1spring.persistence.mapper.CountryMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CountryRepository implements CountryDTORepository {
    private final CountryCrudRepository crudRepository;
    private final CountryMapper mapper;

    public CountryRepository(CountryCrudRepository crudRepository, CountryMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }


    public List<Country> getAll(){
        return  mapper.toCountries((List<CountryEntity>)crudRepository.findAll());
    }

    public Optional<Country> getOne(int countryId){
        return crudRepository.findById(countryId)
                .map(mapper::toCountry);
    }

    public Country save(Country country){
        return mapper.toCountry(crudRepository.save(mapper.toCountryEntity(country)));
    }

    public void delete(int countryId){
        crudRepository.deleteById(countryId);
    }

}
