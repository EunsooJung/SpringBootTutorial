package ej.springframework.services.jpaservices;

import ej.springframework.config.JpaIntegrationConfig;
import ej.springframework.domain.Customer;
import ej.springframework.domain.User;
import ej.springframework.services.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by eunsoojung on 9/8/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(JpaIntegrationConfig.class)
@ActiveProfiles("jpadao")
public class CustomerServiceJpaDaoImplTest {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Test
    public void setEncryptionService() throws Exception {

    }

    @Test
    public void setEmf() throws Exception {

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

        Customer customer = new Customer();
        User user = new User();

        user.setUername("Test User Name");
        user.setPassword("TestPassword");

        customer.setUser(user);

        Customer savedCustomer = customerService.saveOrUpdate(customer);

        assert savedCustomer.getUser().getId() != null;

    }

    @Test
    public void delete() throws Exception {

    }

}