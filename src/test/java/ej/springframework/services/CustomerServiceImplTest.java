package ej.springframework.services;

import ej.springframework.config.JpaIntegrationConfig;
import ej.springframework.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by eunsoojung on 9/6/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(JpaIntegrationConfig.class)
@ActiveProfiles("jpadao")
public class CustomerServiceImplTest {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Test
    public void listAll() throws Exception {

        List<Customer> customers = (List<Customer>) customerService.listAll();

        assert customers.size() == 2;

    }

    @Test
    public void getById() throws Exception {

    }

    @Test
    public void saveOrUpdate() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void loadDomainObjects() throws Exception {

    }

}