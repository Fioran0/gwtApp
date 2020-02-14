package client;

import java.io.Serializable;
import java.util.Objects;

public class Buyer implements Serializable {

    private Integer id;
    private String Surname;
    private String ResidenceArea;
    private Double Discount;

    public Buyer() {
    }

    public Buyer(Integer id, String surname, String residenceArea, Double discount) {
        this.id = id;
        Surname = surname;
        ResidenceArea = residenceArea;
        Discount = discount;
    }

    public Buyer(String surname, String residenceArea, Double discount) {
        Surname = surname;
        ResidenceArea = residenceArea;
        Discount = discount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getResidenceArea() {
        return ResidenceArea;
    }

    public void setResidenceArea(String residenceArea) {
        ResidenceArea = residenceArea;
    }

    public Double getDiscount() {
        return Discount;
    }

    public void setDiscount(Double discount) {
        Discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buyer buyer = (Buyer) o;
        return getId().equals(buyer.getId()) &&
                getSurname().equals(buyer.getSurname()) &&
                getResidenceArea().equals(buyer.getResidenceArea()) &&
                getDiscount().equals(buyer.getDiscount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSurname(), getResidenceArea(), getDiscount());
    }
}
