package com.example.bankdemo.services;

import com.example.bankdemo.DataAccess.SavingsAccTransactionsRepository;
import com.example.bankdemo.DataAccess.SavingsRepository;
import com.example.bankdemo.exceptions.AccountNotFountException;
import com.example.bankdemo.exceptions.InsufficientAmountException;
import com.example.bankdemo.models.SavingsAccount;
import com.example.bankdemo.models.Transactions;
import com.example.bankdemo.models.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SavingsAccountService {
    @Autowired
    private SavingsRepository savingsRepository;
    @Autowired
    private SavingsAccTransactionsRepository savingsTransactionLogs;

    public  void deposit(Long accountNumber,double amount) throws AccountNotFountException {
        SavingsAccount account = savingsRepository.findByAccNumber(accountNumber);// need a check for no existant acc no
        account.deposit(amount);
        savingsRepository.save(account);
        Transactions transaction = new Transactions(amount, LocalDateTime.now(), Type.Deposit);
        savingsTransactionLogs.save(transaction);//save transaction
    }

    public void withdraw(Long accountNumber,double amount) throws InsufficientAmountException,AccountNotFountException{
        SavingsAccount account = savingsRepository.findByAccNumber(accountNumber);
        account.withdraw(amount);
        savingsRepository.save(account);
        Transactions transaction = new Transactions(amount, LocalDateTime.now(),Type.Withdrawal);
        savingsTransactionLogs.save(transaction);
    }
    public  Long OpenAccount(double amount) throws  InsufficientAmountException {

        if( amount < 1000.00){
            throw new InsufficientAmountException(" minimum deposit of 1000 needed");
        }
        SavingsAccount account = new  SavingsAccount(amount,true);
        return savingsRepository.save(account).getAccNumber();
    }

}
