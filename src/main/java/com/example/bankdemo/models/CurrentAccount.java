package com.example.bankdemo.models;

import com.example.bankdemo.exceptions.InsufficientAmountException;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name ="current")
public class CurrentAccount extends Account {

    private double overdraftLimit =-100_000.00  ;

    public CurrentAccount(double balance, Long accNumber, double overdraftLimit) {
        super(balance,accNumber);
        this.overdraftLimit = overdraftLimit;
    }

    public CurrentAccount(double overdraftLimit,double balance ) {
        this.overdraftLimit = overdraftLimit;
        this.balance =balance;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public CurrentAccount() {
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) throws InsufficientAmountException {
        //can only withdraw with a positive balance
        if(balance >0 && balance >= amount){
            balance -= amount;
            return ;
        }
        if(overdraftLimit +amount >0){
            throw  new InsufficientAmountException("not enough balance");
        }
        if(balance < 0 ||balance ==0 && overdraftLimit < 0 ){
            overdraftLimit += amount;
        }
        else {
            throw  new InsufficientAmountException("not enough balance");
        }
    }

    @Override
    public void transfer(double amount) {

    }
}
