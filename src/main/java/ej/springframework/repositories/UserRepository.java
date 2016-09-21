package ej.springframework.repositories;

import ej.springframework.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by eunsoojung on 9/21/16.
 */
public interface UserRepository extends CrudRepository<User, Integer> {

}
