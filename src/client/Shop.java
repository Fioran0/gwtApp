package client;


import java.io.Serializable;
import java.util.Objects;

public class Shop implements Serializable {

    private Integer id;
    private String shopName;
    private String shopLocationArea;
    private Double CommissionFee;

    public Shop() {
    }

    public Shop(Integer id, String shopName, String shopLocationArea, Double commissionFee) {
        this.id = id;
        this.shopName = shopName;
        this.shopLocationArea = shopLocationArea;
        CommissionFee = commissionFee;
    }

    public Shop(String shopName, String shopLocationArea, Double commissionFee) {
        this.shopName = shopName;
        this.shopLocationArea = shopLocationArea;
        CommissionFee = commissionFee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopLocationArea() {
        return shopLocationArea;
    }

    public void setShopLocationArea(String shopLocationArea) {
        this.shopLocationArea = shopLocationArea;
    }

    public Double getCommissionFee() {
        return CommissionFee;
    }

    public void setCommissionFee(Double commissionFee) {
        CommissionFee = commissionFee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return getId().equals(shop.getId()) &&
                getShopName().equals(shop.getShopName()) &&
                getShopLocationArea().equals(shop.getShopLocationArea()) &&
                getCommissionFee().equals(shop.getCommissionFee());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getShopName(), getShopLocationArea(), getCommissionFee());
    }
}
