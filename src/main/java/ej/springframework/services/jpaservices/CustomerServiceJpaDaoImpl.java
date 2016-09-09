package ej.springframework.services.jpaservices;

import ej.springframework.domain.Customer;
import ej.springframework.services.CustomerService;
import ej.springframework.services.security.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

/**
 * Created by eunsoojung on 9/6/16.
 */
@Service
@Profile("jpadao")
public class CustomerServiceJpaDaoImpl extends AbstractJpaDaoService implements CustomerService {

    // private EntityManagerFactory emf;

    // Applying Encryption Service
    private EncryptionService encryptionService;
    @Autowired
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<?> listAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Customer", Customer.class).getResultList();
    }

    @Override
    public Customer getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Customer.class, id);
    }

    @Override
    public Customer saveOrUpdate(Customer domainObject) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        if (domainObject.getUser() != null && domainObject.getUser().getPassword() != null) {
            domainObject.getUser().setEncryptedPassword(
                    encryptionService.encryptString(domainObject.getUser().getPassword()));
        }
        Customer savedCustomer = em.merge(domainObject);
        em.getTransaction().commit();

        return savedCustomer;
    }

//    @Override
//    public Customer saveOrUpdate(Customer domainObject) {
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        Customer savedCustomer = em.merge(domainObject);
//        em.getTransaction().commit();
//        return savedCustomer;
//    }

    @Override
    public void delete(Integer id) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.remove(em.find(Customer.class, id));
        em.getTransaction().commit();

    }
}
