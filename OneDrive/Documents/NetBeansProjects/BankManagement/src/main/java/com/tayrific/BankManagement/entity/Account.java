/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tayrific.BankManagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;


@Entity //JPA entity - mapped to a table in DB
@Table(name = "accounts")
public class Account {
    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto generate values
    private int accountID;
     
    @Column(nullable = false, unique = true)
    private long accountNumber;
    
     @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountType accountType;
    
    @Column(nullable = false)
    @Min(value = 0, message = "Balance cannot be negative")
    private double balance;
    
    @ManyToOne // Many accounts can belong to one user
    @JoinColumn(name = "userid", nullable = false) // Foreign key reference to user
    private User user;
    
    public enum AccountType {
        SAVINGS,
        CHECKING
    }
    
    public Account(long accountNumber, AccountType accountType, double balance, User user) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.user = user;
    }

    public Account() {
    }

    
    //getters and setters
    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }  

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" + "accountID=" + accountID + ", accountNumber=" + accountNumber + ", accountType=" + accountType + ", balance=" + balance + ", user=" + user + '}';
    }   
}
