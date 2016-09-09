package ej.springframework.services;

import java.util.List;

/**
 * Created by eunsoojung on 9/1/16.
 */
public interface CRUDService<T> {

    List<?> listAll();

    T getById(Integer id);

    T saveOrUpdate(T domainObject);

    void delete(Integer id);
}
