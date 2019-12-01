package Model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "`ORDER`")
public class Order implements Serializable {

    private static final long serialVersionUID = 6L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "OrderId")
    private int OrderId;

    @OneToMany(mappedBy = "Order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetail> OrderDetails = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerId")
    private Customer Customer;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "AddressId", referencedColumnName = "AddressId")
    private Address AltAddress;

    @Column(name = "SubTotal")
    private double SubTotal;

    @Column(name = "Total")
    private double Total;

    @Column(name = "Date")
    private LocalDate Date;

    public Order() {
    }

    public int getOrderId() {
        return OrderId;
    }

    public Model.Customer getCustomer() {
        return Customer;
    }

    public void setCustomer(Model.Customer customer) {
        Customer = customer;
    }

    public Address getAltAddress() {
        return AltAddress;
    }

    public void setAltAddress(Address altAddress) {
        AltAddress = altAddress;
    }

    public double getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(double subTotal) {
        SubTotal = subTotal;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        Total = total;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return OrderId == order.OrderId &&
                Double.compare(order.SubTotal, SubTotal) == 0 &&
                Double.compare(order.Total, Total) == 0 &&
                Objects.equals(OrderDetails, order.OrderDetails) &&
                Objects.equals(Customer, order.Customer) &&
                Objects.equals(AltAddress, order.AltAddress) &&
                Objects.equals(Date, order.Date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(OrderId, OrderDetails, Customer, AltAddress, SubTotal, Total, Date);
    }

    @Override
    public String toString() {
        return "Order{" +
                "OrderId=" + OrderId +
                ", OrderDetails=" + OrderDetails +
                ", Customer=" + Customer +
                ", AltAddress=" + AltAddress +
                ", SubTotal=" + SubTotal +
                ", Total=" + Total +
                ", Date=" + Date +
                '}';
    }
}
