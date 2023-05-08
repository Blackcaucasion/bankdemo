package com.example.bankdemo.models;

import com.example.bankdemo.exceptions.InsufficientAmountException;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "savings")
public class SavingsAccount extends  Account{
    private  boolean isOpen = false;

    public SavingsAccount(double balance, Long accNumber, boolean isOpen) {
        super(balance, accNumber);
        this.isOpen = isOpen;
    }

    public SavingsAccount() {
        super();
    }

    public SavingsAccount(double balance,boolean isOpen) {
        this.balance =balance;
        this.isOpen = isOpen;
    }

    @Override
    public void deposit(double amount) {
        if (isOpen) {
            balance += amount;
        }

    }

    @Override
    public void withdraw(double amount) throws InsufficientAmountException {
        //        check if is open
       if(balance < 1000){
           throw new InsufficientAmountException("you have insufficient amount to withdraw");
       }
        if(balance - amount <= 1000){
            throw new InsufficientAmountException("you have insufficient amount to withdraw");
        }
        balance -= amount;
    }

    @Override
    public void transfer(double amount) {
    }
}
