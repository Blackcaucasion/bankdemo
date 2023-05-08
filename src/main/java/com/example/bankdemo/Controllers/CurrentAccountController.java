package com.example.bankdemo.Controllers;

import com.example.bankdemo.exceptions.AccountNotFountException;
import com.example.bankdemo.exceptions.InsufficientAmountException;
import com.example.bankdemo.services.CurrentAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api/v1/current")
public class CurrentAccountController {
    @Autowired
    private CurrentAccountService currentAccountService;



    @PostMapping(path = "/{accountNumber}/deposit")
    @ResponseStatus(code = HttpStatus.OK, reason = "OK")
    public void deposit(@PathVariable Long accountNumber, @RequestParam double amount) throws AccountNotFountException {
        this.currentAccountService.deposit(accountNumber,amount);
        return;

    }
    @PostMapping(path = "/{accountNumber}/withdraw")
    @ResponseStatus(code = HttpStatus.OK, reason = "OK")
    public void withdraw(@PathVariable Long accountNumber, @RequestParam double amount) throws InsufficientAmountException ,AccountNotFountException {
       this.currentAccountService.withdraw(accountNumber,amount);
       return;
    }

}
