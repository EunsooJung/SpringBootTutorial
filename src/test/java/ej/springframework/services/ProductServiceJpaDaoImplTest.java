package ej.springframework.services;

import ej.springframework.config.JpaIntegrationConfig;
import ej.springframework.domain.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by eunsoojung on 9/6/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(JpaIntegrationConfig.class)
@ActiveProfiles("jpadao")
public class ProductServiceJpaDaoImplTest {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void setEmf() throws Exception {

    }

    @Test
    public void testListAll() throws Exception {

        List<Product> products = (List<Product>) productService.listAll();

        assert products.size() == 5;

    }

    @Test
    public void getById() throws Exception {

    }

    @Test
    public void saveOrUpdate() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

}