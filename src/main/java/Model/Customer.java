package Model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CUSTOMER")
@NamedQuery(name = "Customers.findAll", query = "SELECT c FROM Customer c")
public class Customer implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private int CustomerId;

    @Column(name = "Name")
    private String Name;

    @Column(name = "BirthDate")
    private LocalDate BirthDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AddressId", referencedColumnName = "AddressId")
    private Address Address;

    @OneToMany(mappedBy = "Customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> Orders = new ArrayList<>();

    @Column(name = "JoinDate")
    private LocalDate JoinDate;

    @Column(name = "Platform")
    private Platform Platform;


    public Customer() {
    }

    public Customer(String name, LocalDate birthDate, Model.Address address, LocalDate joinDate, Model.Platform platform) {
        Name = name;
        BirthDate = birthDate;
        Address = address;
        JoinDate = joinDate;
        Platform = platform;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public LocalDate getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        BirthDate = birthDate;
    }

    public Model.Address getAddress() {
        return Address;
    }

    public void setAddress(Model.Address address) {
        Address = address;
    }

    public LocalDate getJoinDate() {
        return JoinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        JoinDate = joinDate;
    }

    public Model.Platform getPlatform() {
        return Platform;
    }

    public void setPlatform(Model.Platform platform) {
        Platform = platform;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return CustomerId == customer.CustomerId &&
                Objects.equals(Name, customer.Name) &&
                Objects.equals(BirthDate, customer.BirthDate) &&
                Objects.equals(Address, customer.Address) &&
                Objects.equals(JoinDate, customer.JoinDate) &&
                Platform == customer.Platform;
    }

    @Override
    public int hashCode() {
        return Objects.hash(CustomerId, Name, BirthDate, Address, JoinDate, Platform);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "CustomerId=" + CustomerId +
                ", Name='" + Name + '\'' +
                ", BirthDate=" + BirthDate +
                ", Address=" + Address +
                ", JoinDate=" + JoinDate +
                ", Platform=" + Platform +
                '}';
    }
}
