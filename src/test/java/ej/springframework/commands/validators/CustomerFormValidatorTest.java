package ej.springframework.commands.validators;

import ej.springframework.commands.CustomerForm;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static org.junit.Assert.*;

/**
 * Created by eunsoojung on 9/28/16.
 *
 * Create new Test class: After open the target source code and then ctl + command + t key
 */
public class CustomerFormValidatorTest {

    private Validator validator;
    private CustomerForm customerForm;
    private Errors errors;

    @Before
    public void setup() {
        validator = new CustomerFormValidator();
        customerForm = new CustomerForm();
        errors = new BeanPropertyBindingResult(customerForm, "customerForm");
    }


    @Test
    public void testNoErrors() {
        customerForm.setPasswordText("password");
        customerForm.setPasswordTextConf("password");

        validator.validate(customerForm, errors);

        assert errors.hasErrors() == false;

    }

    @Test
    public void tesHasErrors() {
        customerForm.setPasswordText("password");
        customerForm.setPasswordTextConf("asdf");

        validator.validate(customerForm, errors);

        assert errors.hasErrors();
    }

}