package cl.awakelab.m1spring.persistence.repository;

import cl.awakelab.m1spring.persistence.crud.AddressCrudRepository;
import cl.awakelab.m1spring.persistence.entity.Address;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AddressRepository {

    private final AddressCrudRepository crudRepository;

    public AddressRepository(AddressCrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    public List<Address> getAll(){
        return (List<Address>) crudRepository.findAll();
    }
    public Optional<Address> getOne(int addressId){
        return crudRepository.findById(addressId);
    }
    public Address save(Address address){
        return crudRepository.save(address);
    }
    public void delete(int addressId){
        crudRepository.deleteById(addressId);
    }
}
