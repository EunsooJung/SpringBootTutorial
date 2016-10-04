package ej.springframework.converters;

import ej.springframework.commands.CustomerForm;
import ej.springframework.domain.Address;
import ej.springframework.domain.Customer;
import ej.springframework.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by eunsoojung on 9/26/16.
 * To use command object for Customer form
 */
@Component
public class CustomerFormToCustomer implements Converter<CustomerForm, Customer> {

    @Override
    public Customer convert(CustomerForm customerForm) {

        Customer customer = new Customer();
        customer.setUser(new User());
        customer.setBillingAddress(new Address());
        customer.setShippingAddress(new Address());
        customer.getUser().setId(customerForm.getUserId());
        customer.getUser().setVersion(customerForm.getUserVersion());
        customer.setId(customerForm.getCustomerId());
        customer.setVersion(customerForm.getCustomerVersion());
        customer.getUser().setUsername(customerForm.getUserName());
        customer.getUser().setPassword(customerForm.getPasswordText());
        customer.setFirstName(customerForm.getFirstName());
        customer.setLastName(customerForm.getLastName());
        customer.setEmail(customerForm.getEmail());
        customer.setPhoneNumber(customerForm.getPhoneNumber());

        return customer;
    }
}