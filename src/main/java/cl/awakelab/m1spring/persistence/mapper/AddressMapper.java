package cl.awakelab.m1spring.persistence.mapper;

import cl.awakelab.m1spring.domain.dto.Address;
import cl.awakelab.m1spring.persistence.entity.AddressEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CityMapper.class})
public interface AddressMapper {
    @Mappings({
            @Mapping(source = "addressId", target = "addressId"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "address2", target = "address2"),
            @Mapping(source = "district", target = "district"),
            @Mapping(source = "phone", target = "phone"),
            @Mapping(source = "postalCode", target = "postalCode"),
            @Mapping(source = "city", target = "city"),
    })
    Address toAddress(AddressEntity address);
    List<Address> toAddresses(List<AddressEntity> addresses);

    @InheritInverseConfiguration
    AddressEntity toAddressEntity(Address address);
}
