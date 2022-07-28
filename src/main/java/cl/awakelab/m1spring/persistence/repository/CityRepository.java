package cl.awakelab.m1spring.persistence.repository;

import cl.awakelab.m1spring.persistence.crud.CityCrudRepository;
import cl.awakelab.m1spring.persistence.entity.City;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CityRepository {

    private final CityCrudRepository crudRepository;

    public CityRepository(CityCrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    public List<City> getAll(){
        return (List<City>) crudRepository.findAll();
    }

    public List<City> getAllByCountryId(int countryId){
        return crudRepository.findByCountryId(countryId);
    }

    public City save(City city){
        return crudRepository.save(city);
    }
    public void delete(int cityId){
        crudRepository.deleteById(cityId);
    }
}
