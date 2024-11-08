/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tayrific.BankManagement.service;

import com.tayrific.BankManagement.DTO.AccountDTO;
import com.tayrific.BankManagement.DTO.TransactionDTO;
import com.tayrific.BankManagement.Repository.AccountRepository;
import com.tayrific.BankManagement.Repository.TransactionRepository;
import com.tayrific.BankManagement.entity.Account;
import com.tayrific.BankManagement.entity.Transaction;

import jakarta.transaction.Transactional;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository repo;
    @Autowired
    private AccountRepository accountRepo;



    @Override
    @Transactional
    public void logTransaction(Transaction.TransactionType transactionType, double amount, AccountDTO accountDTO) {
        // Convert AccountDTO to Account entity if needed
        Account account = accountRepo.findById(accountDTO.getAccountId())
                .orElseThrow(() -> new RuntimeException("Account not found"));

        // Create and save the transaction
        Transaction transaction = new Transaction(transactionType, amount, Instant.now(), account);
        repo.save(transaction);
    }

    @Override
    public List<TransactionDTO> getTransactionsByAccount(int accountId) {
         Account account = accountRepo.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        List<Transaction> transactions = repo.findByAccount(account);
        
        return repo.findByAccount(account).stream()
            .map(transaction -> new TransactionDTO(
                    transaction.getTransactionID(),
                    transaction.getTransactionType().toString(),
                    transaction.getAmount(),
                    transaction.getTimestamp(),
                    transaction.getAccount().getAccountId()
            ))
            .collect(Collectors.toList());
    }
}
