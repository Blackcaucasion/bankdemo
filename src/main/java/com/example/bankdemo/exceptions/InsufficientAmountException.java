package com.example.bankdemo.exceptions;

public class InsufficientAmountException extends  Exception{
    public InsufficientAmountException(String message){
        super(message);
    }
}
