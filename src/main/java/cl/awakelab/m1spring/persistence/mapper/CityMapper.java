package cl.awakelab.m1spring.persistence.mapper;

import cl.awakelab.m1spring.domain.dto.City;
import cl.awakelab.m1spring.persistence.entity.CityEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CountryMapper.class})
public interface CityMapper {

    @Mappings({
            @Mapping(source = "cityId", target = "cityId"),
            @Mapping(source = "city", target = "city"),
            @Mapping(source = "countryId", target = "countryId"),
            @Mapping(source = "country", target = "country"),
    })
    City toCity(CityEntity city);
    List<City> toCities(List<CityEntity> cities);

    @InheritInverseConfiguration
    CityEntity toCityEntity(City city);


}
