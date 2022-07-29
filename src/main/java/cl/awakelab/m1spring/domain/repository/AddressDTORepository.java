package cl.awakelab.m1spring.domain.repository;

import cl.awakelab.m1spring.domain.dto.Address;

import java.util.List;
import java.util.Optional;

public interface AddressDTORepository {
    List<Address> getAll();
    Optional<Address> getOne(int addressId);
    Address save(Address address);
    void delete(int addressId);
}
