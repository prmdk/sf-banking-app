package com.prmdk.bankapp.service;

import com.prmdk.bankapp.dto.AccountDto;
import com.prmdk.bankapp.dto.TransactionDto;
import com.prmdk.bankapp.entity.Account;
import com.prmdk.bankapp.entity.AccountNumber;
import com.prmdk.bankapp.entity.Transaction;
import com.prmdk.bankapp.exception.AccountNotFound;
import com.prmdk.bankapp.exception.InSufficientBalance;
import com.prmdk.bankapp.repo.AccountNumberRepo;
import com.prmdk.bankapp.repo.AccountRepo;
import com.prmdk.bankapp.repo.TransactionRepo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountNumberRepo accountNumberRepo;
    @Autowired
    AccountRepo accountRepo;

    @Autowired
    TransactionRepo transactionRepo;

    public Account findByAccountNumber(Integer accountNumber) {
        Optional<Account> accountOptional = accountRepo.findById(accountNumber);
        if (accountOptional.isPresent()) {
            return accountOptional.get();
        } else
            throw new AccountNotFound(accountNumber.toString());

    }

    public void createAccount(AccountDto accountDto) {
        if (StringUtils.isBlank(accountDto.getCustomerName())) {
            throw new IllegalArgumentException("Customer Name is required");
        }
        Account account = new Account();
        account.setCustomerName(accountDto.getCustomerName());
        accountRepo.save(account);
    }
    @Transactional
    public void deposit(TransactionDto transactionDto) {
        if (transactionDto.getAmount() <= 0) {
            throw new IllegalArgumentException("Transaction amount should be more than 0");
        }
        Account account = findByAccountNumber(transactionDto.getAccountNumber());
        Double newBalance = account.getBalanceAmount() + transactionDto.getAmount();
        account.setBalanceAmount(newBalance);
        Transaction transaction = new Transaction();
        transaction.setAccountNumber(account.getAccountNumber());
        transaction.setDeposit(transactionDto.getAmount());
        transaction.setBalance(newBalance);
        transaction.setTransactionDate(new Date());
        accountRepo.save(account);
        transactionRepo.save(transaction);
    }
    @Transactional
    public void withdraw(TransactionDto transactionDto) {
        if (transactionDto.getAmount() <= 0) {
            throw new IllegalArgumentException("Transaction amount should be more than 0");
        }
        Account account = findByAccountNumber(transactionDto.getAccountNumber());
        Double newBalance = account.getBalanceAmount() - transactionDto.getAmount();
        if (newBalance < 0) {
            throw new InSufficientBalance(account.getBalanceAmount());
        }
        account.setBalanceAmount(newBalance);
        Transaction transaction = new Transaction();
        transaction.setAccountNumber(account.getAccountNumber());
        transaction.setWithdraw(transactionDto.getAmount());
        transaction.setBalance(newBalance);
        transaction.setTransactionDate(new Date());
        accountRepo.save(account);
        transactionRepo.save(transaction);
    }
    public Double checkBalance(Integer accountNumber) {
        return findByAccountNumber(accountNumber).getBalanceAmount();
    }
}
