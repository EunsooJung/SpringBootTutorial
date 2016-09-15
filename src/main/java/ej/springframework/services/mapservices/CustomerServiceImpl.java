package ej.springframework.services.mapservices;

import ej.springframework.domain.Customer;
import ej.springframework.domain.DomainObject;
import ej.springframework.domain.User;
import ej.springframework.services.CustomerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by eunsoojung on 9/1/16.
 */
@Service
@Profile("map")
public class CustomerServiceImpl extends AbstractMapService implements CustomerService {

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public Customer getById(Integer id) {
        return (Customer) super.getById(id);
    }

    @Override
    public Customer saveOrUpdate(Customer domainObject) {
        return (Customer) super.saveOrUpdate(domainObject);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }

    /* @Override
    protected void loadDomainObjects() {

        domainMap = new HashMap<>();

        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setFirstName("Michael");
        customer1.setLastName("Jung");
        customer1.setAddressLine1("1 Main St");
        customer1.setCity("Santa Clara");
        customer1.setState("CA");
        customer1.setZipCode("10203");
        customer1.setEmail("hi.michael.jung@gmail.com");
        customer1.setPhoneNumber("305-781-3947");

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setFirstName("Gibs");
        customer2.setLastName("NCIS");
        customer2.setAddressLine1("2 Main St");
        customer2.setCity("San Jose");
        customer2.setState("CA");
        customer2.setZipCode("17363");
        customer2.setEmail("hi.gibs.ncis@gmail.com");
        customer2.setPhoneNumber("244-308-8743");

        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setFirstName("Jiva");
        customer3.setLastName("Ncis");
        customer3.setAddressLine1("3 Main St");
        customer3.setCity("Palo Alto");
        customer3.setState("CA");
        customer3.setZipCode("39474");
        customer3.setEmail("hi.jiva.jung@gmail.com");
        customer3.setPhoneNumber("947-384-4875");

        domainMap.put(1, customer1);
        domainMap.put(2, customer2);
        domainMap.put(3, customer3);

    }
    */
}
