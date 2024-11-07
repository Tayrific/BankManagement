/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tayrific.BankManagement.service;

import com.tayrific.BankManagement.entity.Transaction;
import com.tayrific.BankManagement.entity.Account;
import java.util.List;

public interface TransactionService {
    
    void logTransaction(Transaction.TransactionType transactionType, double amount, Account account);   
    List<Transaction> getTransactionsByAccount(Account account);
    
}
