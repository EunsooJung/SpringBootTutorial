package ej.springframework.services.mapservices;

import ej.springframework.domain.DomainObject;
import ej.springframework.domain.Order;
import ej.springframework.domain.User;
import ej.springframework.services.OrderService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by eunsoojung on 9/9/16.
 */
@Service
@Profile("map")
public class OrderServiceMapImpl extends AbstractMapService implements OrderService {

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public Order getById(Integer id) {
        return (Order) super.getById(id);
    }

    @Override
    public Order saveOrUpdate(Order domainObject) {
        return (Order) super.saveOrUpdate(domainObject);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }
}
