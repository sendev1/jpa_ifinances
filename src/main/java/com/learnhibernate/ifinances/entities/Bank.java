package com.learnhibernate.ifinances.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bankId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String createdBy;

    @Column(updatable = false)
    @CreationTimestamp
    private Date createdDate;

    @Column(nullable = false)
    private String lastUpdatedBy;

    @Column(nullable = false)
    @UpdateTimestamp
    private Date lastUpdatedDate;

    @Column(nullable = false)
    private int isInternational;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "addressLine1", column = @Column(name = "ADDRESS_LINE_1")),
            @AttributeOverride(name = "addressLine2", column = @Column(name = "ADDRESS_LINE_2"))
    })
    private Address address;

    @ElementCollection
    @CollectionTable(name = "bank_contact", joinColumns = @JoinColumn(name = "bank_id"))
    @Column(name = "name")
    private List<String> contacts = new ArrayList<>();

    public List<String> getContacts() {
        return contacts;
    }

    public void setContacts(List<String> contacts) {
        this.contacts = contacts;
    }

    public Bank() {
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getIsInternational() {
        return isInternational;
    }

    public void setIsInternational(int isInternational) {
        this.isInternational = isInternational;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
