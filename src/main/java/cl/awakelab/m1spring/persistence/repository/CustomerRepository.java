package cl.awakelab.m1spring.persistence.repository;

import cl.awakelab.m1spring.domain.dto.Customer;
import cl.awakelab.m1spring.domain.repository.CustomerDTORepository;
import cl.awakelab.m1spring.persistence.crud.CustomerCrudRepository;
import cl.awakelab.m1spring.persistence.entity.CustomerEntity;
import cl.awakelab.m1spring.persistence.mapper.CustomerMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository implements CustomerDTORepository {

    private final CustomerCrudRepository crudRepository;
    private final CustomerMapper mapper;

    public CustomerRepository(CustomerCrudRepository crudRepository, CustomerMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    public List<Customer> getAll(){
        return mapper.toCustomers((List<CustomerEntity>)crudRepository.findAll());
        //return (List<Customer>) crudRepository.find("Smith", true);
        //return (List<Customer>) crudRepository.findAllByActive(false);
    }

    public Optional<Customer> getOne(int customerId){
        return crudRepository.findById(customerId)
                .map(mapper::toCustomer);
    }

    public Customer save(Customer customer){
        return mapper.toCustomer(crudRepository.save(mapper.toCustomerEntity(customer)));
    }

    public void delete(int customerId){
        crudRepository.deleteById(customerId);
    }


}
