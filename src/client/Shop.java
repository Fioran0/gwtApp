package client;

import client.Purchase;

import java.io.Serializable;

public class Shop implements Serializable {

    private Integer id;
    private Purchase purchase;
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

    public Shop(Integer id, Purchase purchase, String shopName, String shopLocationArea, Double commissionFee) {
        this.id = id;
        this.purchase = purchase;
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

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
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
}
