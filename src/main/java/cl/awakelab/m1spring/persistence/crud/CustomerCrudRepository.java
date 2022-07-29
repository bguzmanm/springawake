package cl.awakelab.m1spring.persistence.crud;

import cl.awakelab.m1spring.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerCrudRepository extends CrudRepository<CustomerEntity, Integer> {

    public List<CustomerEntity> findAllByActive(boolean active);

    @Query("select c from CustomerEntity c where c.lastName =:lastName and c.active =:active")
    public List<CustomerEntity> find(@Param("lastName") String lastName, @Param("active") boolean active);

    public List<CustomerEntity> findByFirstName(String firstName);

    @Query(value = "select * from customer where customer.first_name like =:nombre", nativeQuery = true)
    public List<CustomerEntity> buscarPorNombre(String nombre);

}
