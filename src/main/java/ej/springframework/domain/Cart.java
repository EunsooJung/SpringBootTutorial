package ej.springframework.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eunsoojung on 9/8/16.
 */
@Entity
public class Cart extends AbstractDomainClass {
    // S16_L90
    // public class Cart implements DomainObject {

    @OneToOne
    private User user;

    // S9-L58
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart", orphanRemoval = true)
    private List<CartDetail> cartDetails = new ArrayList<>();

/* S16_L90

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;

@Version
private Integer version;
*/

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
/*

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


    public List<CartDetail> getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(List<CartDetail> cartDetails) {
        this.cartDetails = cartDetails;
    }

    public void addCartDetail(CartDetail cartDetail){
        cartDetails.add(cartDetail);
        cartDetail.setCart(this);
    }

    public void removeCartDetail(CartDetail cartDetail){
        cartDetail.setCart(null);
        this.cartDetails.remove(cartDetail);
    }
}
