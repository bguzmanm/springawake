package cl.awakelab.m1spring.domain.service;

import cl.awakelab.m1spring.domain.dto.Address;
import cl.awakelab.m1spring.domain.repository.AddressDTORepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private final AddressDTORepository repository;

    public AddressService(AddressDTORepository repository) {
        this.repository = repository;
    }


    public List<Address> getAll(){
        return repository.getAll();
    }
    public Optional<Address> getOne(int addressId){
        return repository.getOne(addressId);
    }

    public Address save(Address addressEntity){
        return repository.save(addressEntity);
    }
    public boolean delete(int addressId){
        return getOne(addressId)
                .map(address -> {
                   repository.delete(addressId);
                   return true;
                }).orElse(false);
    }

}
