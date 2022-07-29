package cl.awakelab.m1spring.persistence.mapper;

import cl.awakelab.m1spring.domain.dto.Country;
import cl.awakelab.m1spring.persistence.entity.CountryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    @Mappings({
            @Mapping(source = "countryId", target = "countryId"),
            @Mapping(source = "country", target = "country"),
    })
    Country toCountry(CountryEntity country);
    List<Country> toCountries(List<CountryEntity> countries);

    @InheritInverseConfiguration
    CountryEntity toCountryEntity(Country country);
}
