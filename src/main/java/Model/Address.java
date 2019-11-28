package Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ADDRESS")
public class Address {

    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "AddressId")
    private int AddressId;

    @Column(name = "Number")
    private int Number;

    @Column(name = "Street")
    private String Street;

    @Column(name = "City")
    private String City;

    @Column(name = "State")
    private String State;

    public Address() {
    }

    public Address(int number, String street, String city, String state) {
        Number = number;
        Street = street;
        City = city;
        State = state;
    }

    public int getAddressId() {
        return AddressId;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return AddressId == address.AddressId &&
                Number == address.Number &&
                Objects.equals(Street, address.Street) &&
                Objects.equals(City, address.City) &&
                Objects.equals(State, address.State);
    }

    @Override
    public int hashCode() {
        return Objects.hash(AddressId, Number, Street, City, State);
    }


}
