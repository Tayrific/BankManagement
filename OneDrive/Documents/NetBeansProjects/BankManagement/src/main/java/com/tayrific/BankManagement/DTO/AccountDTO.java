/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tayrific.BankManagement.DTO;

import com.tayrific.BankManagement.entity.Account.AccountType;

/**
 *
 * @author tayyi
 */
public class AccountDTO {
    private int accountID;
    private long accountNumber;
    private AccountType accountType;
    private double balance;
    private int userId;

    // Constructor (You can add a constructor if needed)
    public AccountDTO(int accountID, long accountNumber, AccountType accountType, double balance, int userId) {
        this.accountID = accountID;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.userId = userId;
    }

    // Getters and setters
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
}
