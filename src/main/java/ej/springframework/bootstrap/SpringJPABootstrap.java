package ej.springframework.bootstrap;

import ej.springframework.domain.Customer;
import ej.springframework.domain.Product;
import ej.springframework.domain.Address;
import ej.springframework.services.CustomerService;
import ej.springframework.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by eunsoojung on 9/6/16.
 * This class is Test temporary Data Set Class but this class perform to store and load data
 * for the H2 Memory Database
 */
@Component
public class SpringJPABootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ProductService productService;
    private CustomerService customerService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadProducts();
        loadCustomers();
    }
/*
    private void loadProducts() {

        Product product1 = new Product();
        product1.setDescription("Product1");
        product1.setPrice(new BigDecimal("14.99"));
        product1.setImageUrl("http://example.com/product1");
        productService.saveOrUpdate(product1);

        Product product2 = new Product();
        product2.setDescription("Product2");
        product2.setPrice(new BigDecimal("24.99"));
        product2.setImageUrl("http://example.com/product2");
        productService.saveOrUpdate(product2);

        Product product3 = new Product();
        product3.setDescription("Product3");
        product3.setPrice(new BigDecimal("34.99"));
        product3.setImageUrl("http://example.com/product3");
        productService.saveOrUpdate(product3);

        Product product4 = new Product();
        product4.setDescription("product4");
        product4.setPrice(new BigDecimal("44.99"));
        product4.setImageUrl("http://example.com/product4");
        productService.saveOrUpdate(product4);

        Product product5 = new Product();
        product5.setDescription("product5");
        product5.setPrice(new BigDecimal("54.99"));
        product5.setImageUrl("http://example.com/product5");
        productService.saveOrUpdate(product5);
    }

    private void loadCustomers() {

        Customer customer1 = new Customer();
        customer1.setFirstName("Michael");
        customer1.setLastName("Jung");
        customer1.setAddressLine1("1 Main St");
        customer1.setAddressLine2("Miami");
        customer1.setCity("Miami");
        customer1.setState("Florida");
        customer1.setZipCode("33101");
        customer1.setEmail("hi.michael.jung@gmail.com");
        customer1.setPhoneNumber("304-349-9595");
        customerService.saveOrUpdate(customer1);

        Customer customer2 = new Customer();
        customer2.setFirstName("Gib");
        customer2.setLastName("Mcroy");
        customer2.setAddressLine1("2 Main St");
        customer2.setAddressLine2("Los Gatos");
        customer2.setCity("Los Gatos");
        customer2.setState("CA");
        customer2.setZipCode("55101");
        customer2.setEmail("hi.gibs.mcroy@gmail.com");
        customer2.setPhoneNumber("305-345-9595");
        customerService.saveOrUpdate(customer2);

    }
*/
public void loadCustomers() {
    Customer customer1 = new Customer();
    customer1.setFirstName("Micheal");
    customer1.setLastName("Weston");
    customer1.setBillingAddress(new Address());
    customer1.getBillingAddress().setAddressLine1("1 Main St");
    customer1.getBillingAddress().setCity("Miami");
    customer1.getBillingAddress().setState("Florida");
    customer1.getBillingAddress().setZipCode("33101");
    customer1.setEmail("micheal@burnnotice.com");
    customer1.setPhoneNumber("305.333.0101");
    customerService.saveOrUpdate(customer1);

    Customer customer2 = new Customer();
    customer2.setFirstName("Fiona");
    customer2.setLastName("Glenanne");
    customer2.setBillingAddress(new Address());
    customer2.getBillingAddress().setAddressLine1("1 Key Biscane Ave");
    customer2.getBillingAddress().setCity("Miami");
    customer2.getBillingAddress().setState("Florida");
    customer2.getBillingAddress().setZipCode("33101");
    customer2.setEmail("fiona@burnnotice.com");
    customer2.setPhoneNumber("305.323.0233");
    customerService.saveOrUpdate(customer2);

    Customer customer3 = new Customer();
    customer3.setFirstName("Sam");
    customer3.setLastName("Axe");
    customer3.setBillingAddress(new Address());
    customer3.getBillingAddress().setAddressLine1("1 Little Cuba Road");
    customer3.getBillingAddress().setCity("Miami");
    customer3.getBillingAddress().setState("Florida");
    customer3.getBillingAddress().setZipCode("33101");
    customer3.setEmail("sam@burnnotice.com");
    customer3.setPhoneNumber("305.426.9832");
    customerService.saveOrUpdate(customer3);
}

    public void loadProducts(){

        Product product1 = new Product();
        product1.setDescription("Product 1");
        product1.setPrice(new BigDecimal("12.99"));
        product1.setImageUrl("http://example.com/product1");
        productService.saveOrUpdate(product1);

        Product product2 = new Product();
        product2.setDescription("Product 2");
        product2.setPrice(new BigDecimal("14.99"));
        product2.setImageUrl("http://example.com/product2");
        productService.saveOrUpdate(product2);

        Product product3 = new Product();
        product3.setDescription("Product 3");
        product3.setPrice(new BigDecimal("34.99"));
        product3.setImageUrl("http://example.com/product3");
        productService.saveOrUpdate(product3);

        Product product4 = new Product();
        product4.setDescription("Product 4");
        product4.setPrice(new BigDecimal("44.99"));
        product4.setImageUrl("http://example.com/product4");
        productService.saveOrUpdate(product4);

        Product product5 = new Product();
        product5.setDescription("Product 5");
        product5.setPrice(new BigDecimal("25.99"));
        product5.setImageUrl("http://example.com/product5");
        productService.saveOrUpdate(product5);

    }
}
