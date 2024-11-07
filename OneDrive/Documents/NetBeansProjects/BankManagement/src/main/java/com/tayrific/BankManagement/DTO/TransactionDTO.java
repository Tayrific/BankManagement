/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tayrific.BankManagement.DTO;

import java.text.DecimalFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


public class TransactionDTO {

    private int transactionID;
    private String transactionType;
    private String amount;  
    private String timestamp;  
    private int accountId;

    // Constructor
    public TransactionDTO(int transactionID, String transactionType, double amount, Instant timestamp, int accountId) {
        this.transactionID = transactionID;
        this.transactionType = transactionType;
        this.amount = formatAmount(amount);
        this.timestamp = formatTimestamp(timestamp);
        this.accountId = accountId;
    }

    // Getters and Setters
    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = formatAmount(amount);
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = formatTimestamp(timestamp);
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountID(int accountID) {
        this.accountId = accountID;
    }

    // Formatting the amount to 2 decimal places
    private String formatAmount(double amount) {
        DecimalFormat formatter = new DecimalFormat("#,##0.00");
        return formatter.format(amount);
    }

    // Formatting the timestamp to a more readable format
    private String formatTimestamp(Instant timestamp) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                .withZone(ZoneId.systemDefault());
        return formatter.format(timestamp);
    }
}
