package com.orion.financial_mss.model;

import java.util.Date;

public class CustomerTransactionResponse {

    public CustomerTransactionResponse(Long id, Long accountNumber, Date date, String transactionType, double amount, double balance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.date = date;
        this.transactionType = transactionType;
        this.amount = amount;
        this.balance = balance;
    }

    private Long id;
    private Long accountNumber;
    private Date date;
    private String transactionType;
    private double amount;
    private double balance;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public String getTransactionType() {
        return transactionType;
    }
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

}
