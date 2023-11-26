package infs.Insurancemang.Insurancemang.controller;

import infs.Insurancemang.Insurancemang.model.Customer;
import infs.Insurancemang.Insurancemang.repo.CustomerRepository;
import infs.Insurancemang.Insurancemang.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin("*")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String id) {
        return customerService.getCustomerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable String id, @RequestBody Customer customerDetails) {
        return customerService.getCustomerById(id)
                .map(existingCustomer -> {
                    existingCustomer.setFirstName(customerDetails.getFirstName());
                    existingCustomer.setLastName(customerDetails.getLastName());
                    existingCustomer.setEmail(customerDetails.getEmail());
                    existingCustomer.setDateOfBirth(customerDetails.getDateOfBirth());
                    existingCustomer.setPhoneNumber(customerDetails.getPhoneNumber());
                    existingCustomer.setAge(customerDetails.getAge());
                    existingCustomer.setGender(customerDetails.getGender());
                    existingCustomer.setCreateDate(customerDetails.getCreateDate());
                    Customer updatedCustomer = customerService.saveCustomer(existingCustomer);
                    return ResponseEntity.ok(updatedCustomer);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String id) {
        return customerService.getCustomerById(id)
                .map(customer -> {
                    customerService.deleteCustomer(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/dashboard/totalUsers")
    public Long getTotalUsers() {
        return customerRepository.count();
    }

    //for recent user
    @GetMapping("/recent")
    public List<Customer> getRecentCustomer() {
        return customerService.getRecentCustomer();
    }


    @GetMapping("/genders")
    public List<Map> getGenderCounts(){
        return customerService.getGenderCounts();
    }


//    demo search query
@GetMapping("/search-query")
public List<Customer> searchCustomers(
        @RequestParam(required = false) String firstName,
        @RequestParam(required = false) String lastName,
        @RequestParam(required = false) String email) {

    if (firstName != null && !firstName.isEmpty()) {
        return customerRepository.findByFirstNameContainingIgnoreCase(firstName);
    } else if (lastName != null && !lastName.isEmpty()) {
        return customerRepository.findByLastNameContainingIgnoreCase(lastName);
    } else if (email != null && !email.isEmpty()) {
        return customerRepository.findByEmailContainingIgnoreCase(email);
    } else {
        return customerRepository.findAll();
    }
}


}
