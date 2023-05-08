package com.example.bankdemo.services;

import com.example.bankdemo.DataAccess.CurrentAccTransactionsRepository;
import com.example.bankdemo.DataAccess.CurrentRepository;
import com.example.bankdemo.exceptions.AccountNotFountException;
import com.example.bankdemo.exceptions.InsufficientAmountException;
import com.example.bankdemo.models.CurrentAccTransactions;
import com.example.bankdemo.models.CurrentAccount;
import com.example.bankdemo.models.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CurrentAccountService {
    @Autowired
    private CurrentRepository currentAccountRepository;
    @Autowired
    private CurrentAccTransactionsRepository currentAccTransactionsRepository;

    public  void deposit(Long accountNumber,double amount) throws AccountNotFountException {
        CurrentAccount account = currentAccountRepository.findByAccNumber(accountNumber);
        account.deposit(amount);
        currentAccountRepository.save(account);
        CurrentAccTransactions transaction = new CurrentAccTransactions(amount, LocalDateTime.now(), Type.Deposit);
        currentAccTransactionsRepository.save(transaction);// record transaction

    }
    public void withdraw(Long accountNumber,double amount) throws InsufficientAmountException,AccountNotFountException{
        CurrentAccount account = currentAccountRepository.findByAccNumber(accountNumber);
        account.withdraw(amount);
        currentAccountRepository.save(account);
        CurrentAccTransactions transaction = new CurrentAccTransactions(amount, LocalDateTime.now(),Type.Withdrawal);
        currentAccTransactionsRepository.save(transaction);// record transaction
    }

    }
