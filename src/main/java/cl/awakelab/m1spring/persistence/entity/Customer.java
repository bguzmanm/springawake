package cl.awakelab.m1spring.persistence.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="customer")
@NamedQuery(name="Customer.findByFirstName", query="select c from Customer c where c.firstName like ?1")
public class Customer {

    @Id
    @Column(name="customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    @Column(name="store_id")
    private Integer storeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", updatable = false, insertable = false)
    private Store store;

    @Column(name="first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    private String email;
    @Column(name="address_id")
    private Integer addressId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="address_id", updatable = false, insertable = false)
    private Address address;
    private Boolean active;
    @Column(name="create_date")
    private LocalDate createDate;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

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

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", storeId=" + storeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", addressId=" + addressId +
                ", active=" + active +
                ", createDate=" + createDate +
                '}';
    }

}


