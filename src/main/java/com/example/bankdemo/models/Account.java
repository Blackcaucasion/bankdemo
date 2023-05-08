package com.example.bankdemo.models;

import com.example.bankdemo.exceptions.InsufficientAmountException;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Account {
    protected  double balance;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected  Long accNumber;



    public Account(double balance, Long accNumber) {
        this.balance = balance;
        this.accNumber = accNumber;
    }

    public Account() {

    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Long getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(Long accNumber) {
        this.accNumber = accNumber;
    }
    public abstract void deposit(double amount);
    public  abstract  void withdraw(double amount) throws InsufficientAmountException;
    public  abstract  void transfer(double amount);
}
