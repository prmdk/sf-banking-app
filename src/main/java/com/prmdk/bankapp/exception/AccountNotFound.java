package com.prmdk.bankapp.exception;

public class AccountNotFound extends RuntimeException {
    public AccountNotFound(String accountNumber) {
        super("Account not found: " + accountNumber);
    }

}
