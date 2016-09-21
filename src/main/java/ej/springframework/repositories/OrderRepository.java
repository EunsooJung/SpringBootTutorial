package ej.springframework.repositories;

import ej.springframework.domain.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by eunsoojung on 9/21/16.
 */
public interface OrderRepository extends CrudRepository<Order, Integer> {
}
