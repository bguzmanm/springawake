package cl.awakelab.m1spring.domain.repository;

import cl.awakelab.m1spring.domain.dto.Country;

import java.util.List;
import java.util.Optional;

public interface CountryDTORepository {
    List<Country> getAll();
    Optional<Country> getOne(int countryId);
    Country save(Country country);
    void delete(int countryId);
}
