package com.prmdk.bankapp.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tranId;

    @Column(nullable = false)
    private Integer accountNumber;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date transactionDate;

    @Column
    private String description;

    @Column
    private Double deposit;
    @Column
    private Double withdraw;
    @Column
    private Double balance;

    public Long getTranId() {
        return tranId;
    }

    public void setTranId(Long tranId) {
        this.tranId = tranId;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(Double withdraw) {
        this.withdraw = withdraw;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
