package com.example.bankdemo.DataAccess;

import com.example.bankdemo.exceptions.AccountNotFountException;
import com.example.bankdemo.models.CurrentAccount;

public interface CurrentAccountRepository {
    CurrentAccount findByAccNumber(Long accNumber) throws AccountNotFountException;
}
