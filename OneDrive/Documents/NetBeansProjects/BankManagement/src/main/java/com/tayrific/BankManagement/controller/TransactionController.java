/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tayrific.BankManagement.controller;

import com.tayrific.BankManagement.DTO.AccountDTO;
import com.tayrific.BankManagement.DTO.TransactionDTO;
import com.tayrific.BankManagement.entity.Account;
import com.tayrific.BankManagement.entity.Transaction;
import com.tayrific.BankManagement.service.AccountMapper;
import com.tayrific.BankManagement.service.AccountService;
import com.tayrific.BankManagement.service.TransactionService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private final AccountService accountService;
    private final AccountMapper accountMapper;  

    // Constructor injection
    @Autowired
    public TransactionController(TransactionService transactionService, AccountService accountService, AccountMapper accountMapper) {
        this.transactionService = transactionService;
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @PostMapping("/log")
    public ResponseEntity<String> logTransaction(
            @RequestParam("transactionType") Transaction.TransactionType transactionType,
            @RequestParam("amount") double amount,
            @RequestParam("accountId") int accountId) {

        try {
            // Call the AccountService to fetch the account
            AccountDTO accountDTO = accountService.getAccountById(accountId);

            // Convert AccountDTO to Account entity
            Account account = accountMapper.toEntity(accountDTO);

            // Log the transaction
            transactionService.logTransaction(transactionType, amount, accountDTO);

            return ResponseEntity.ok("Transaction logged successfully");

        } catch (Exception e) {
            // Handle exception if the account is not found or any other error occurs
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found or invalid data");
        }
    }

     @GetMapping("/account/{accountId}")
    public ResponseEntity<List<TransactionDTO>> getTransactions(@PathVariable int accountId) {
        try {
            List<TransactionDTO> transactions = transactionService.getTransactionsByAccount(accountId);
            return ResponseEntity.ok(transactions);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
