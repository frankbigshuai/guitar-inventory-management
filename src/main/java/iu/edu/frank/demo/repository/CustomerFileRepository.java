package iu.edu.frank.demo.repository;



import iu.edu.frank.demo.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerFileRepository {
    private final CustomerRepository customerRepository;

    public CustomerFileRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findByUsername(String customerUsername) {
        return customerRepository.findByUsername(customerUsername);
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public List<Customer> findAll()  {
        return (List<Customer>) customerRepository.findAll();
    }
}
