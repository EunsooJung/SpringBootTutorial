package ej.springframework.services.reposervices;

import ej.springframework.domain.User;
import ej.springframework.repositories.UserRepository;
import ej.springframework.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eunsoojung on 9/21/16.
 */
@Service
@Profile("springdatajpa")
public class UserServiceRepoImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<?> listAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public User saveOrUpdate(User domainObject) {
        return userRepository.save(domainObject);
    }

    @Override
    public void delete(Integer id) {
        userRepository.delete(id);
    }
}
