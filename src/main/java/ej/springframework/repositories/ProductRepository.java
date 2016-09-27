package ej.springframework.repositories;

import ej.springframework.domain.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by eunsoojung on 9/26/16.
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
