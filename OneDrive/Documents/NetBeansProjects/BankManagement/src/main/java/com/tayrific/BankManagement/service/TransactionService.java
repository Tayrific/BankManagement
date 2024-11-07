/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tayrific.BankManagement.service;

import com.tayrific.BankManagement.DTO.AccountDTO;
import com.tayrific.BankManagement.DTO.TransactionDTO;
import com.tayrific.BankManagement.entity.Transaction;

import java.util.List;

public interface TransactionService {
    
       void logTransaction(Transaction.TransactionType transactionType, double amount, AccountDTO accountDTO);   
       List<TransactionDTO> getTransactionsByAccount(int accountId);
    
}
