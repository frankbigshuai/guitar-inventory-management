package iu.edu.frank.demo.repository;



import iu.edu.frank.demo.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface CustomerRepository
        extends CrudRepository<Customer, String>
{
    Customer findByUsername(String username);

}