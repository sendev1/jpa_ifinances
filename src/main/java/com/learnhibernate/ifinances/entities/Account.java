package com.learnhibernate.ifinances.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;

    @Column
    private String accountType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BANK_ID", nullable = false)
    private Bank bank;

    // Unidirectional relationship
    // No need account reference in Transaction class
    //@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "ACCOUNT_ID", nullable = false)

    //@OneToMany(mappedBy = "account") -> this did not work

    //@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "ACCOUNT_ID")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    List<Transaction> transactions = new ArrayList<>();

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }



    @Column
    private Date closeDate;

    @Column
    private String createdBy;

    @Column
    @CreationTimestamp
    private Date createdDate;

    @Column
    private double currentBalance;

    @Column
    private double initialBalance;

    @Column
    private String lastUpdatedBy;

    @Column
    @UpdateTimestamp
    private Date lastUpdatedDate;


    public Account() {
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public double getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(double initialBalance) {
        this.initialBalance = initialBalance;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    @Column
    private String name;

    @Column
    private Date openDate;
}
