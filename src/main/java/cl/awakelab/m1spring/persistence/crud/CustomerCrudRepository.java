package cl.awakelab.m1spring.persistence.crud;

import cl.awakelab.m1spring.persistence.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerCrudRepository extends CrudRepository<Customer, Integer> {

    public List<Customer> findAllByActive(boolean active);

    @Query("select c from Customer c where c.lastName =:lastName and c.active =:active")
    public List<Customer> find(@Param("lastName") String lastName, @Param("active") boolean active);

    public List<Customer> findByFirstName(String firstName);

}
