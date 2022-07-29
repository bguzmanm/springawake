package cl.awakelab.m1spring.persistence.repository;

import cl.awakelab.m1spring.domain.dto.Address;
import cl.awakelab.m1spring.domain.repository.AddressDTORepository;
import cl.awakelab.m1spring.persistence.crud.AddressCrudRepository;
import cl.awakelab.m1spring.persistence.entity.AddressEntity;
import cl.awakelab.m1spring.persistence.mapper.AddressMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AddressRepository implements AddressDTORepository {

    private final AddressCrudRepository crudRepository;
    private final AddressMapper mapper;

    public AddressRepository(AddressCrudRepository crudRepository, AddressMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    public List<Address> getAll(){
        return  mapper.toAddresses((List<AddressEntity>) crudRepository.findAll());
    }
    public Optional<Address> getOne(int addressId){
        return crudRepository.findById(addressId)
                .map(mapper::toAddress);
    }
    public Address save(Address address){
        return mapper.toAddress(crudRepository.save(mapper.toAddressEntity(address)));
    }
    public void delete(int addressId){
        crudRepository.deleteById(addressId);
    }
}
