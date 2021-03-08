package com.learnhibernate.ifinances.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Stock extends Investment {

    @Column
    private String name;

    @Column
    private String issuer;

    @Column
    private Date purchaseDate;

    @Column
    private int quantity;

    @Column
    private double sharePrice;

    public Stock() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(double sharePrice) {
        this.sharePrice = sharePrice;
    }
}
