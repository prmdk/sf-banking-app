package com.prmdk.bankapp.controller;

import com.prmdk.bankapp.dto.AccountDto;
import com.prmdk.bankapp.dto.TransactionDto;
import com.prmdk.bankapp.entity.Account;
import com.prmdk.bankapp.entity.Transaction;
import com.prmdk.bankapp.service.AccountService;
import com.prmdk.bankapp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankController {
    @Autowired
    AccountService accountService;

    @Autowired
    TransactionService transactionService;

    @PostMapping("/createAccount")
    public ResponseEntity<String> createAccount(@RequestBody AccountDto account) {
        accountService.createAccount(account);
        return ResponseEntity.ok("Account created");
    }
    @PostMapping("/deposit")
    public ResponseEntity<String> deposit(@RequestBody TransactionDto txn) {
        accountService.deposit(txn);
        return ResponseEntity.ok("Deposit Made");
    }
    @PostMapping("/withdraw")
    public ResponseEntity<String> withdraw(@RequestBody TransactionDto txn) {
        accountService.withdraw(txn);
        return ResponseEntity.ok("Withdraw Made");
    }
    @GetMapping("/checkbalance/{accountNumber}")
    public ResponseEntity<String> checkBalance(@PathVariable Integer accountNumber) {
        Double balance = accountService.checkBalance(accountNumber);
        return ResponseEntity.ok("Balance: "+ balance);
    }
    @GetMapping("/viewTransactionsById/{accountNumber}")
    public ResponseEntity<List<Transaction>> viewTransactionsById(@PathVariable Integer accountNumber) {
        return ResponseEntity.ok(transactionService.getTransactionsByAccountNumber(accountNumber));
    }

    @GetMapping("/viewTransactionsDateWise/{accountNumber}/{date}")
    public ResponseEntity<List<Transaction>> viewTransactionsById(@PathVariable Integer accountNumber, @PathVariable String date) {

        return ResponseEntity.ok(transactionService.getTransactionsByAccountNumberAndTra(accountNumber, date));
    }
}
