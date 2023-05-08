package com.example.bankdemo.DataAccess;

import com.example.bankdemo.exceptions.AccountNotFountException;
import com.example.bankdemo.models.SavingsAccount;

public interface SavingsAccountRepository {
    SavingsAccount findByAccNumber(Long accNumber) throws AccountNotFountException;;
}
