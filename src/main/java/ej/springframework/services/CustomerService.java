package ej.springframework.services;

import ej.springframework.commands.CustomerForm;
import ej.springframework.domain.Customer;

/**
 * Created by eunsoojung on 9/1/16.
 */

public interface CustomerService extends CRUDService<Customer> {
    // L11
    Customer saveOrUpdateCustomerForm(CustomerForm customerForm);
}
