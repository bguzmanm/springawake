package cl.awakelab.m1spring.domain.repository;

import cl.awakelab.m1spring.domain.dto.City;

import java.util.List;
import java.util.Optional;

public interface CityDTORepository {
    List<City> getAll();
    Optional<City> getOne(int cityId);
    City save(City city);
    void delete(int cityId);
    List<City> getAllByCountryId(int countryId);
}
