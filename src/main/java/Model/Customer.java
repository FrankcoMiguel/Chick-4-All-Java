package Model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private int CustomerId;

    @Column(name = "Name")
    private String Name;

    @Column(name = "Age")
    private int Age;

    @Column(name = "Address")
    private Address Address;

    @Column(name = "JoinDate")
    private LocalDate JoinDate;

    @Column(name = "Platform")
    private Platform Platform;


    public Customer() {
    }

    public Customer(String name, int age, Model.Address address, LocalDate joinDate, Model.Platform platform) {
        Name = name;
        Age = age;
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

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
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
}
