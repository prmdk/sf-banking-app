package com.prmdk.bankapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(value = TxnDateIncorrectFormat.class)
    public ResponseEntity<String> txnDateIncorrectFormat(TxnDateIncorrectFormat ex){
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(value = AccountNotFound.class)
    public ResponseEntity<String> accountNotFound(AccountNotFound ex){
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(value = InSufficientBalance.class)
    public ResponseEntity<String> insufficientBalance(InSufficientBalance ex){
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<String> insufficientBalance(IllegalArgumentException ex){
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
