package com.example.bankdemo.Controllers;

import com.example.bankdemo.exceptions.AccountNotFountException;
import com.example.bankdemo.exceptions.InsufficientAmountException;
import com.example.bankdemo.services.SavingsAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping(path = "/api/v1/savings")
public class SavingsAccountController {
     @Autowired
      private SavingsAccountService savingsAccountService;


    /***
     *
     * @param accountNumber account number to deposit to
     * @param  amount amount of money to deposit
     * ToDo make these end points secured so only a user with a valid token can have access
     */
    @PostMapping(path = "/{accountNumber}/deposit")
    @ResponseStatus(code = HttpStatus.OK, reason = "OK")
    public void deposit(@PathVariable Long accountNumber, @RequestParam double amount) throws AccountNotFountException {

       this.savingsAccountService.deposit(accountNumber,amount);
       return;

    }
    @PostMapping(path = "/{accountNumber}/withdraw")
    @ResponseStatus(code = HttpStatus.OK, reason = "OK")
    public void withdraw(@PathVariable Long accountNumber, @RequestParam double amount) throws InsufficientAmountException,AccountNotFountException {
          this.savingsAccountService.withdraw(accountNumber,amount);
          return;

    }
    @PostMapping(path = "/open")
    @ResponseBody
    public Long openSavings( @RequestParam double amount) throws InsufficientAmountException {
      return   this.savingsAccountService.OpenAccount(amount);

    }
}
