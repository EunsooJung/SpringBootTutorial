package ej.springframework.services.jpaservices;

import ej.springframework.config.JpaIntegrationConfig;
import ej.springframework.domain.*;
import ej.springframework.services.UserService;
import ej.springframework.services.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by eunsoojung on 9/8/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
// @SpringApplicationConfiguration(JpaIntegrationConfig.class)
@ActiveProfiles("jpadao")
public class UserServiceJpaDaoImplTest {

    private UserService userService;
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void testSaveOfUser() throws Exception {
        User user = new User();

        user.setUsername("TestUSerName");
        user.setPassword("TestPassword");

        User savedUser = userService.saveOrUpdate(user);

        assert savedUser.getId() != null;
        assert savedUser.getEncryptedPassword() != null;

        System.out.println("Encrypted Password");
        System.out.println(savedUser.getEncryptedPassword());
    }

    @Test
    public void testSaveOrUserWithCustomer() throws Exception {
        User user = new User();

        user.setUsername("TestUserName");
        user.setPassword("myPassoword");

        Customer customer = new Customer();
        customer.setFirstName("Chevy");
        customer.setLastName("Chase");

        user.setCustomer(customer);

        User savedUser = userService.saveOrUpdate(user);

        assert savedUser.getId() != null;
        assert savedUser.getVersion() != null;
        assert savedUser.getCustomer() != null;
        assert savedUser.getCustomer().getId() != null;
    }

    // S9-L58 Test Case
    @Test
    public void testAddCartToUser() throws Exception {

        User user = new User();

        user.setUsername("TestUserName");
        user.setPassword("myPassoword");

        user.setCart(new Cart());

        User savedUser = userService.saveOrUpdate(user);

        assert savedUser.getId() != null;
        assert savedUser.getVersion() != null;
        assert savedUser.getCart() != null;
        assert savedUser.getCart().getId() != null;
    }
    @Test
    public void testAddCartToUserWithCartDetails() throws Exception {
        User user = new User();

        user.setUsername("S9-L58-TestUserName");
        user.setPassword("S9-L58-TestUserPassword");

        user.setCart(new Cart());

        List<Product> storedProducts = (List<Product>) productService.listAll();

        CartDetail cartItemOne = new CartDetail();
        cartItemOne.setProduct(storedProducts.get(0));
        user.getCart().addCartDetail(cartItemOne);

        CartDetail cartItemTwo = new CartDetail();
        cartItemTwo.setProduct(storedProducts.get(1));
        user.getCart().addCartDetail(cartItemTwo);

        User savedUser = userService.saveOrUpdate(user);

        assert savedUser.getId() != null;
        assert savedUser.getVersion() != null;
        assert savedUser.getCart() != null;
        assert savedUser.getCart().getId() != null;

    }

    @Test
    public void testAddAndRemoveCartToUserWithCartDetails() throws Exception {
        User user = new User();

        user.setUsername("S9-L58-TestUserName");
        user.setPassword("S9-L58-TestUserPassword");

        user.setCart(new Cart());

        List<Product> storedProducts = (List<Product>) productService.listAll();

        CartDetail cartItemOne = new CartDetail();
        cartItemOne.setProduct(storedProducts.get(0));
        user.getCart().addCartDetail(cartItemOne);

        CartDetail cartItemTwo = new CartDetail();
        cartItemTwo.setProduct(storedProducts.get(1));
        user.getCart().addCartDetail(cartItemTwo);

        User savedUser = userService.saveOrUpdate(user);

        assert savedUser.getCart().getCartDetails().size() == 2;

        savedUser.getCart().removeCartDetail(savedUser.getCart().getCartDetails().get(0));

        userService.saveOrUpdate(savedUser);

        assert savedUser.getCart().getCartDetails().size() == 1;

    }
}