package ej.springframework.domain;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by eunsoojung on 9/1/16.
 */
@Entity
// public class Customer implements DomainObject {
public class Customer extends AbstractDomainClass {

/*
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;

@Version
private Integer version;
*/

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
/* Refactored for the S16_L90
    @Embedded
    private Address billingAddress;

    @Embedded
    private Address shippingAddress;

private String addressLine1;
private String addressLine1;
private String addressLine2;
private String city;
private String state;
private String zipCode;
*/
    // Added S16_L90
    @Embedded
    private Address billingAddress = new Address();

    // Added S16_L90
    @Embedded
    private Address shippingAddress = new Address();

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private User user;
//    S9-L56
//    @OneToOne(cascade = {CascadeType.ALL})
//    pr
    //L10
    @Override
    public Integer getId() {
        return id;
    }

//    public void setId(Integer id) {
//        this.id = id;
//    }

/*
public Integer getVersion() {
return version;
}

public void setVersion(Integer version) {
this.version = version;
}
*/

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
/*
    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
*/

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

}
