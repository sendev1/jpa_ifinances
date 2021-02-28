package com.learnhibernate.ifinances.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int budgetId;

    @Column
    private double goalAmount;

    @Column
    private String name;

    @Column
    private int period;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="BUDGET_TRANSACTION",
            joinColumns = @JoinColumn(name = "BUDGET_ID"),
            inverseJoinColumns = @JoinColumn(name = "TRANSACTION_ID"))
    private List<Transaction> transactions = new ArrayList<>();

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Budget() {
    }

    public int getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(int budgetId) {
        this.budgetId = budgetId;
    }

    public double getGoalAmount() {
        return goalAmount;
    }

    public void setGoalAmount(double goalAmount) {
        this.goalAmount = goalAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }
}
