package com.example.bankdemo.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "current_trans")
public class CurrentAccTransactions {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long id;
    public double amount;
    private LocalDateTime dateTime;
    public Type accountType; //rename to transTyple

    public CurrentAccTransactions(double amount, LocalDateTime dateTime, Type accountType) {
        this.amount = amount;
        this.dateTime = dateTime;
        this.accountType = accountType;
    }

    public CurrentAccTransactions() {
    }

    public Long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Type getAccountType() {
        return accountType;
    }
}
