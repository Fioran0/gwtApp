package client;

import java.io.Serializable;
import java.util.Objects;

public class Books implements Serializable {
    private Integer id;
    private String Name;
    private Double Cost;
    private String Warehouse;
    private Integer Quantity;

    public Books() {
    }

    public Books(Integer id, String name, Double cost, String warehouse, Integer quantity) {
        this.id = id;
        Name = name;
        Cost = cost;
        Warehouse = warehouse;
        Quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getCost() {
        return Cost;
    }

    public void setCost(Double cost) {
        Cost = cost;
    }

    public String getWarehouse() {
        return Warehouse;
    }

    public void setWarehouse(String warehouse) {
        Warehouse = warehouse;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Cost=" + Cost +
                ", Warehouse='" + Warehouse + '\'' +
                ", Quantity=" + Quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Books books = (Books) o;
        return getId().equals(books.getId()) &&
                getName().equals(books.getName()) &&
                getCost().equals(books.getCost()) &&
                getWarehouse().equals(books.getWarehouse()) &&
                getQuantity().equals(books.getQuantity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCost(), getWarehouse(), getQuantity());
    }
}
