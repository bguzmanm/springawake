package cl.awakelab.m1spring.domain.service;

import cl.awakelab.m1spring.persistence.entity.Address;
import cl.awakelab.m1spring.persistence.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private final AddressRepository repository;

    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }
    public List<Address> getAll(){
        return repository.getAll();
    }
    public Optional<Address> getOne(int addressId){
        return repository.getOne(addressId);
    }

    public Address save(Address address){
        return repository.save(address);
    }
    public boolean delete(int addressId){
        return getOne(addressId)
                .map(address -> {
                   repository.delete(addressId);
                   return true;
                }).orElse(false);
    }

}
