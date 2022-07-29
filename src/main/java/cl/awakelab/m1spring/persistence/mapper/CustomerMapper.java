package cl.awakelab.m1spring.persistence.mapper;

import cl.awakelab.m1spring.domain.dto.Customer;
import cl.awakelab.m1spring.persistence.entity.CustomerEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AddressMapper.class, StoreMapping.class})
public interface CustomerMapper {

    @Mappings({
            @Mapping(source = "customerId", target = "customerId"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "active", target = "active"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "store", target = "store"),
    })
    Customer toCustomer(CustomerEntity customer);
    List<Customer> toCustomers(List<CustomerEntity> customers);

    @InheritInverseConfiguration
    CustomerEntity toCustomerEntity(Customer customer);
}
