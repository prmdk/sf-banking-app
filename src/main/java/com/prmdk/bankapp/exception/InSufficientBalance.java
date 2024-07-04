package com.prmdk.bankapp.exception;

public class InSufficientBalance extends RuntimeException {
    public InSufficientBalance(double balance) {
        super("Insufficient balance: " + balance);
    }
}
