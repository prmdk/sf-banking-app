package com.prmdk.bankapp.exception;

public class TxnDateIncorrectFormat extends RuntimeException {
    public TxnDateIncorrectFormat(String dateStr) {
        super("Incorrect dateformat "+dateStr + ", please use yyyy-MM-dd");
    }
}
