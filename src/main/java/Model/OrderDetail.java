package Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "OrderDetail")
@NamedQuery(name = "Detail.findAll", query = "SELECT d FROM OrderDetail d")
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 5L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "DetailNumber")
    private int DetailNumber;

    @Column(name = "Item")
    private Item item;

    @Column(name = "Quantity")
    private int Quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`ORDER`")
    private Order Order;

    @Column(name = "Cost")
    private double Cost;

    public OrderDetail() {
    }

    public int getDetailNumber() {
        return DetailNumber;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public Model.Order getOrder() {
        return Order;
    }

    public void setOrder(Model.Order order) {
        Order = order;
    }

    public double getCost() {
        return Cost;
    }

    public void setCost(double cost) {
        Cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetail that = (OrderDetail) o;
        return DetailNumber == that.DetailNumber &&
                Quantity == that.Quantity &&
                Double.compare(that.Cost, Cost) == 0 &&
                Objects.equals(item, that.item) &&
                Objects.equals(Order, that.Order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(DetailNumber, item, Quantity, Order, Cost);
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "DetailNumber=" + DetailNumber +
                ", item=" + item +
                ", Quantity=" + Quantity +
                ", Order=" + Order +
                ", Cost=" + Cost +
                '}';
    }
}
