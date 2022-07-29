package cl.awakelab.m1spring.persistence.repository;

import cl.awakelab.m1spring.domain.dto.City;
import cl.awakelab.m1spring.domain.repository.CityDTORepository;
import cl.awakelab.m1spring.persistence.crud.CityCrudRepository;
import cl.awakelab.m1spring.persistence.entity.CityEntity;
import cl.awakelab.m1spring.persistence.mapper.CityMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CityRepository implements CityDTORepository {

    private final CityCrudRepository crudRepository;
    private final CityMapper mapper;

    public CityRepository(CityCrudRepository crudRepository, CityMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }


    public List<City> getAll(){
        return mapper.toCities((List<CityEntity>) crudRepository.findAll());
    }

    @Override
    public Optional<City> getOne(int cityId) {
        return crudRepository.findById(cityId)
                .map(mapper::toCity);
    }

    public List<City> getAllByCountryId(int countryId){
        return mapper.toCities(crudRepository.findByCountryId(countryId));
    }

    public City save(City city){
        return mapper.toCity(crudRepository.save(mapper.toCityEntity(city)));
    }
    public void delete(int cityId){
        crudRepository.deleteById(cityId);
    }
}
