/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tayrific.BankManagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;


@Entity //JPA entity - mapped to a table in DB
@Table(name = "transactions")
public class Transaction {
    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto generate values
    private int transactionID;
     
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType transactionType;
    
    @Column(nullable = false)
    @Min(value = 0, message = "Amount must be positive")
    private double amount;
    
    @Column(nullable = false)
    private java.time.Instant timestamp;
    
    @ManyToOne // Many accounts can belong to one user
    @JoinColumn(name = "accountId", nullable = false) // Foreign key reference to user
    private Account account;
    
    public enum TransactionType {
        DEPOSIT,
        WITHDRAWAL
    }
    
     public Transaction(TransactionType transactionType, double amount, java.time.Instant timestamp, Account account) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.timestamp = timestamp;
        this.account = account;
    }
     

    
    public Transaction() {
    }
    
    // Getters and Setters
    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public java.time.Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(java.time.Instant timestamp) {
        this.timestamp = timestamp;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return String.format("Transaction{transactionID=%d, transactionType=%s, amount=%.2f, timestamp=%s, accountID=%d}",
        transactionID, transactionType, amount, timestamp, account.getAccountId());
    }

}
