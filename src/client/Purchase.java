package client;

import java.io.Serializable;
import java.sql.Date;



public class Purchase implements Serializable {

    private Integer id;
    private Integer OrderNumber;
    private java.sql.Date Date;
    private Shop Seller;
    private Buyer Buyer;
    private Integer Quantity;
    private Double Sum;
    private Books Book;

    public Purchase() {}

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", OrderNumber=" + OrderNumber +
                ", Date=" + Date +
                ", Seller=" + Seller +
                ", Buyer=" + Buyer +
                ", Quantity=" + Quantity +
                ", Sum='" + Sum + '\'' +
                ", Book=" + Book +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        OrderNumber = orderNumber;
    }

    public java.sql.Date getDate() {
        return Date;
    }

    public void setDate(java.sql.Date date) {
        Date = date;
    }

    public Shop getSeller() {
        return Seller;
    }

    public void setSeller(Shop seller) {
        Seller = seller;
    }

    public Buyer getBuyer() {
        return Buyer;
    }

    public void setBuyer(Buyer buyer) {
        Buyer = buyer;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public Double getSum() {
        return Sum;
    }

    public void setSum(Double sum) {
        Sum = sum;
    }

    public Books getBook() {
        return Book;
    }

    public Purchase(Integer id, Integer orderNumber, java.sql.Date date, Shop seller, client.Buyer buyer, Integer quantity, Double sum, Books book) {
        this.id = id;
        OrderNumber = orderNumber;
        Date = date;
        Seller = seller;
        Buyer = buyer;
        Quantity = quantity;
        Sum = sum;
        Book = book;
    }

    public void setBook(Books book) {
        Book = book;
    }
}
