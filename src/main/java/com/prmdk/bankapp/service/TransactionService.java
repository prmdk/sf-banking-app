package com.prmdk.bankapp.service;

import com.prmdk.bankapp.entity.Account;
import com.prmdk.bankapp.entity.Transaction;
import com.prmdk.bankapp.exception.TxnDateIncorrectFormat;
import com.prmdk.bankapp.repo.AccountRepo;
import com.prmdk.bankapp.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TransactionService {
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    AccountRepo accountRepo;
    @Autowired
    TransactionRepo transactionRepo;

    public List<Transaction> getTransactionsByAccountNumber(
            Integer accountNumber
    ) {
        return transactionRepo.getTransactionByAccount(accountNumber);
    }

    public List<Transaction> getTransactionsByAccountNumberAndTra(
            Integer accountNumber,
            String txnDate
    ) throws TxnDateIncorrectFormat {
        try {
            Date date = dateFormat.parse(txnDate);
            return transactionRepo.getTransactionByAccountAndTransactionDate(accountNumber, date);
        } catch (ParseException e){
            throw new TxnDateIncorrectFormat(txnDate);
        }
    }
}
