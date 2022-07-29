package cl.awakelab.m1spring.persistence.mapper;

import cl.awakelab.m1spring.domain.dto.Store;
import cl.awakelab.m1spring.persistence.entity.StoreEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AddressMapper.class})
public interface StoreMapping {

    @Mappings({
            @Mapping(source = "storeId", target = "storeId"),
            @Mapping(source = "managerStaffId", target = "managerStaffId"),
            @Mapping(source = "address", target = "address")
    })
    Store toStore(StoreEntity store);
    List<Store> toStores(List<StoreEntity> stores);

    @InheritInverseConfiguration
    StoreEntity toStoreEntity(Store store);
}
