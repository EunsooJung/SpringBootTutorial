package ej.springframework.repositories;

import ej.springframework.domain.security.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by eunsoojung on 9/21/16.
 */
public interface RoleRepository extends CrudRepository<Role, Integer> {
}
