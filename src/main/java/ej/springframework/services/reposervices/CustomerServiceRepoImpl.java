package ej.springframework.services.reposervices;

import ej.springframework.domain.Customer;
import ej.springframework.repositories.CustomerRepository;
import ej.springframework.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eunsoojung on 9/21/16.
 */
@Service
@Profile("springdatjpa")
public class CustomerServiceRepoImpl implements CustomerService{

    private CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<?> listAll() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    @Override
    public Customer getById(Integer id) {
        return null;
    }

    @Override
    public Customer saveOrUpdate(Customer domainObject) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
