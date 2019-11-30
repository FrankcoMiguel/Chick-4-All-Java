package Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable {

    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "AddressId")
    private int AddressId;

    @Column(name = "StreetNumber")
    private int StreetNumber;

    @Column(name = "Street")
    private String Street;

    @Column(name = "City")
    private String City;

    @Column(name = "State")
    private String State;

    @Column(name = "Country")
    private String Country;

    @Column(name = "Phone")
    private String Phone;

    public Address() {
    }

    public Address(int streetNumber, String street, String city, String state, String country, String phone) {
        StreetNumber = streetNumber;
        Street = street;
        City = city;
        State = state;
        Country = country;
        Phone = phone;
    }

    public int getAddressId() {
        return AddressId;
    }

    public int getStreetNumber() {
        return StreetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        StreetNumber = streetNumber;
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

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return AddressId == address.AddressId &&
                StreetNumber == address.StreetNumber &&
                Objects.equals(Street, address.Street) &&
                Objects.equals(City, address.City) &&
                Objects.equals(State, address.State) &&
                Objects.equals(Country, address.Country) &&
                Objects.equals(Phone, address.Phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(AddressId, StreetNumber, Street, City, State, Country, Phone);
    }

    @Override
    public String toString() {
        return "Address{" +
                "AddressId=" + AddressId +
                ", StreetNumber=" + StreetNumber +
                ", Street='" + Street + '\'' +
                ", City='" + City + '\'' +
                ", State='" + State + '\'' +
                ", Country='" + Country + '\'' +
                ", Phone='" + Phone + '\'' +
                '}';
    }
}
