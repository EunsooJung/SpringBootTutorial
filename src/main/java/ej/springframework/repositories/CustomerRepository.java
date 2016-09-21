package ej.springframework.repositories;

import ej.springframework.domain.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by eunsoojung on 9/21/16.
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
