package infs.Insurancemang.Insurancemang.repo;

import infs.Insurancemang.Insurancemang.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    List<Customer> findAllByOrderByCreateDateDesc();

    List<Customer> findByFirstNameContainingIgnoreCase(String firstName);
    List<Customer> findByLastNameContainingIgnoreCase(String lastName);
    List<Customer> findByEmailContainingIgnoreCase(String email);

}
