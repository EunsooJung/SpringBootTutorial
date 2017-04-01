package ej.springframework.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Created by eunsoojung on 9/8/16.
 * Entity Object
 */
@Entity
// public class CartDetail implements DomainObject {
public class CartDetail extends AbstractDomainClass {

/*
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;

@Version
private Integer version;
*/

    @ManyToOne
    private Cart cart;

    @OneToOne
    private Product product;

    private Integer quantity;
/* S16_L90
    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }


public Integer getVersion() {
return version;
}

public void setVersion(Integer version) {
this.version = version;
}
*/

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
