package client;

import java.io.Serializable;

public class Buyer implements Serializable {

    private Integer id;
    private Purchase purchase;
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

    public Buyer(Integer id, Purchase purchase, String surname, String residenceArea, Double discount) {
        this.id = id;
        this.purchase = purchase;
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

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
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
}
