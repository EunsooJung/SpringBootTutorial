package ej.springframework.controllers;

import ej.springframework.domain.Customer;
import ej.springframework.services.CustomerService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by eunsoojung on 9/2/16.
 */
public class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();

    }

    @Test
    public void testList() throws Exception {

        List<Customer> customers = new ArrayList<>();

        customers.add(new Customer());
        customers.add(new Customer());

        when(customerService.listAll()).thenReturn((List) customers);

        mockMvc.perform(get("/customer/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/list"))
                .andExpect(model().attribute("customers", hasSize(2)));

    }

    @Test
    public void testShow() throws Exception {

        Integer id = 1;

        when(customerService.getById(id)).thenReturn(new Customer());

        mockMvc.perform(get("/customer/show/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/show"))
                .andExpect(model().attribute("customer", instanceOf(Customer.class)));
    }

    @Test
    public void testEdit() throws Exception {
        Integer id = 1;

        when(customerService.getById(id)).thenReturn(new Customer());

        mockMvc.perform(get("/customer/edit/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/customerform"))
                .andExpect(model().attribute("customer", instanceOf(Customer.class)));

    }

    @Test
    public void testNewCustomer() throws Exception {
        verifyZeroInteractions(customerService);

        mockMvc.perform(get("/customer/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/customerform"))
                .andExpect(model().attribute("customer", instanceOf(Customer.class)));

    }

    @Test
    public void saveOrUpdate() throws Exception {
        Integer id = 1;

        Customer returnCustomer = new Customer();

        String firstName = "Michael";
        String lastName = "Jung";
        String addressLine1 = "1 Main St";
        String addressLine2 = "Apt 301";
        String city = "Miami";
        String state = "Florida";
        String zipCode = "33101";
        String email = "hi.michael.jung@gmail.com";
        String phoneNumber = "304-294-9445";

        returnCustomer.setId(id);
        returnCustomer.setFirstName(firstName);
        returnCustomer.setLastName(lastName);
//        returnCustomer.setAddressLine1(addressLine1);
//        returnCustomer.setAddressLine2(addressLine2);
//        returnCustomer.setCity(city);
//        returnCustomer.setState(state);
//        returnCustomer.setZipCode(zipCode);

        returnCustomer.setEmail(email);
        returnCustomer.setPhoneNumber(phoneNumber);

        when(customerService.saveOrUpdate(Matchers.<Customer>any())).thenReturn(returnCustomer);

        mockMvc.perform(post("/customer")
        .param("id", "1")
        .param("firstName", firstName)
                .param("lastName", lastName)
/*

.param("addressLine1", addressLine1)
.param("addressLine2", addressLine2)
.param("city", city)
.param("state", state)
.param("zipCode", zipCode)
*/
                .param("shippingAddress.addressLine1", addressLine1)
                .param("shippingAddress.addressLine2", addressLine2)
                .param("shippingAddress.city", city)
                .param("shippingAddress.state", state)
                .param("shippingAddress.zipCode", zipCode)
                .param("email", email)
                .param("phoneNumber", phoneNumber))
                    .andExpect(status().is3xxRedirection())
                    .andExpect(view().name("redirect:customer/show/1"))
                    .andExpect(model().attribute("customer", instanceOf(Customer.class)))
                    .andExpect(model().attribute("customer", hasProperty("firstName", is(firstName))))
                    .andExpect(model().attribute("customer", hasProperty("lastName", is(lastName))))
/*

.andExpect(model().attribute("customer", hasProperty("addressLine1", is(addressLine1))))
.andExpect(model().attribute("customer", hasProperty("addressLine2", is(addressLine2))))
.andExpect(model().attribute("customer", hasProperty("city", is(city))))
.andExpect(model().attribute("customer", hasProperty("state", is(state))))
.andExpect(model().attribute("customer", hasProperty("zipCode", is(zipCode))))
*/
                    .andExpect(model().attribute("customer", hasProperty("shippingAddress", hasProperty("addressLine1", is(addressLine1)))))
                    .andExpect(model().attribute("customer", hasProperty("shippingAddress", hasProperty("addressLine2", is(addressLine2)))))
                    .andExpect(model().attribute("customer", hasProperty("shippingAddress", hasProperty("city", is(city)))))
                    .andExpect(model().attribute("customer", hasProperty("shippingAddress", hasProperty("state", is(state)))))
                    .andExpect(model().attribute("customer", hasProperty("shippingAddress", hasProperty("zipCode", is(zipCode)))))
                    .andExpect(model().attribute("customer", hasProperty("email", is(email))))
                    .andExpect(model().attribute("customer", hasProperty("phoneNumber", is(phoneNumber))));

        ArgumentCaptor<Customer> customerCaptor = ArgumentCaptor.forClass(Customer.class);
        verify(customerService).saveOrUpdate(customerCaptor.capture());

        Customer boundCustomer = customerCaptor.getValue();

        assertEquals(id, boundCustomer.getId());
        assertEquals(firstName, boundCustomer.getFirstName());
        assertEquals(lastName, boundCustomer.getLastName());
/*
assertEquals(addressLine1, boundCustomer.getAddressLine1());
assertEquals(addressLine2, boundCustomer.getAddressLine2());
assertEquals(city, boundCustomer.getCity());
*/
        assertEquals(addressLine1, boundCustomer.getShippingAddress().getAddressLine1());
        assertEquals(addressLine2, boundCustomer.getShippingAddress().getAddressLine2());
        assertEquals(city, boundCustomer.getShippingAddress().getCity());
        assertEquals(state, boundCustomer.getShippingAddress().getState());
        assertEquals(zipCode, boundCustomer.getShippingAddress().getZipCode());
        assertEquals(email, boundCustomer.getEmail());
        assertEquals(phoneNumber, boundCustomer.getPhoneNumber());

    }

    @Test
    public void delete() throws Exception {
        Integer id = 1;

        mockMvc.perform(get("/customer/delete/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/customer/list"));
        verify(customerService, times(1)).delete(id);
    }

}