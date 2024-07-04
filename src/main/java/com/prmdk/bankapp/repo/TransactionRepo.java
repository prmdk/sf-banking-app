package com.prmdk.bankapp.repo;

import com.prmdk.bankapp.entity.Account;
import com.prmdk.bankapp.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {
    @Query(value = "select txn from Transaction txn where txn.accountNumber =?1")
    List<Transaction> getTransactionByAccount(Integer accountNumber);

    @Query(value = "select txn from Transaction txn where txn.accountNumber =?1 and txn.transactionDate =?2")
    List<Transaction> getTransactionByAccountAndTransactionDate(Integer account, Date transactionDate);

}
