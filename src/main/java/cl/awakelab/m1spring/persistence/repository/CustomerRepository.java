package cl.awakelab.m1spring.persistence.repository;

import cl.awakelab.m1spring.persistence.crud.CustomerCrudRepository;
import cl.awakelab.m1spring.persistence.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository {

    private final CustomerCrudRepository crudRepository;

    public CustomerRepository(CustomerCrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    public List<Customer> getAll(){
        return (List<Customer>) crudRepository.findByFirstName("D%");
        //return (List<Customer>) crudRepository.find("Smith", true);
        //return (List<Customer>) crudRepository.findAllByActive(false);
    }

    public Optional<Customer> getOne(int customerId){
        return crudRepository.findById(customerId);
    }

    public Customer save(Customer customer){
        return crudRepository.save(customer);
    }

    public void delete(int customerId){
        crudRepository.deleteById(customerId);
    }


}
