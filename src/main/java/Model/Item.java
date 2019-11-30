package Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ITEM")
public class Item implements Serializable {

    private static final long serialVersionUID = 4L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ItemId")
    private int ItemId;

    @Column(name = "Name")
    private String Name;

    @Column(name = "CostPerUnit")
    private long CostPerUnit;

    @Column(name = "Tax")
    private long Tax;

    @Column(name = "Availability")
    private boolean Availability;

    public Item(String name, long costPerUnit, long tax, boolean availability) {
        Name = name;
        CostPerUnit = costPerUnit;
        Tax = tax;
        Availability = availability;
    }

    public int getItemId() {
        return ItemId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public long getCostPerUnit() {
        return CostPerUnit;
    }

    public void setCostPerUnit(long costPerUnit) {
        CostPerUnit = costPerUnit;
    }

    public long getTax() {
        return Tax;
    }

    public void setTax(long tax) {
        Tax = tax;
    }

    public boolean isAvailability() {
        return Availability;
    }

    public void setAvailability(boolean availability) {
        Availability = availability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return ItemId == item.ItemId &&
                CostPerUnit == item.CostPerUnit &&
                Tax == item.Tax &&
                Availability == item.Availability &&
                Objects.equals(Name, item.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ItemId, Name, CostPerUnit, Tax, Availability);
    }

    @Override
    public String toString() {
        return "Item{" +
                "ItemId=" + ItemId +
                ", Name='" + Name + '\'' +
                ", CostPerUnit=" + CostPerUnit +
                ", Tax=" + Tax +
                ", Availability=" + Availability +
                '}';
    }
}
