package com.learnhibernate.ifinances.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Bond extends Investment {

    @Column
    private double interestRate;

    @Column
    private String issuer;

    @Column
    private Date maturityDate;

    @Column
    private String name;

    @Column
    private Date purchaseDate;

    @Column
    private double value;

    public Bond() {
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
