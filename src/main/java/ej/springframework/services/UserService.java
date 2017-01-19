package ej.springframework.services;

import ej.springframework.domain.User;

/**
 * Created by eunsoojung on 9/7/16.
 */
public interface UserService extends CRUDService<User> {

    // User saveOrUpdate(User domainObject);

    // S12_L69: User Details Service
    User findByUserName(String userName);
}
