package infs.Insurancemang.Insurancemang.service;


import infs.Insurancemang.Insurancemang.model.Customer;
import infs.Insurancemang.Insurancemang.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private CustomerRepository customerRepository;


    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(String id) {
        return customerRepository.findById(id);
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }

    public List<Customer> getRecentCustomer(){ return customerRepository.findAllByOrderByCreateDateDesc();}

    public List<Map> getGenderCounts() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group("gender").count().as("count")
        );

        AggregationResults<Map> results = mongoTemplate.aggregate(aggregation, "customer", Map.class);

        return results.getMappedResults();
    }

}
