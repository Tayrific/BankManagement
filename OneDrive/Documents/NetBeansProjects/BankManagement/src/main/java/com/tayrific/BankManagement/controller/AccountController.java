/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tayrific.BankManagement.controller;

import com.tayrific.BankManagement.DTO.AccountDTO;
import com.tayrific.BankManagement.entity.Account;
import com.tayrific.BankManagement.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@CrossOrigin
public class AccountController {

    @Autowired
    private AccountService Service;

    // Endpoint to create a new account
    @PostMapping("/create")
    public ResponseEntity<AccountDTO> createAccount(@RequestBody @Valid Account account) {
        Account createdAccount = Service.createAccount(account);
        AccountDTO accountDTO = Service.getAccountById(createdAccount.getAccountId());
        return ResponseEntity.status(HttpStatus.CREATED).body(accountDTO);
    }

    // Endpoint to get an account by its ID
    @GetMapping("/{accountId}")
    public ResponseEntity<AccountDTO> getAccountById(@PathVariable int accountId) {
        AccountDTO accountDTO = Service.getAccountById(accountId);
        return ResponseEntity.ok(accountDTO);
    }

    // Endpoint to get all accounts for a specific user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AccountDTO>> getUsersAccounts(@PathVariable int userId) {
        List<AccountDTO> accountsDTO = Service.getUsersAccounts(userId);
        return ResponseEntity.ok(accountsDTO);
    }

    // Endpoint to deposit money into an account
    @PutMapping("/{accountId}/deposit")
    public ResponseEntity<AccountDTO> depositMoney(@PathVariable int accountId, @RequestParam double amount) {
        AccountDTO updatedAccount = Service.depositMoney(accountId, amount);
        return ResponseEntity.ok(updatedAccount);
    }

    // Endpoint to withdraw money from an account
    @PutMapping("/{accountId}/withdraw")
    public ResponseEntity<AccountDTO> withdrawMoney(@PathVariable int accountId, @RequestParam double amount) {
        AccountDTO updatedAccount = Service.withdrawMoney(accountId, amount);
        return ResponseEntity.ok(updatedAccount);
    }

    // Endpoint to delete an account
    @DeleteMapping("/{accountId}")
    public ResponseEntity<Void> deleteAccount(@PathVariable int accountId) {
        Service.deleteAccount(accountId);
        return ResponseEntity.noContent().build();
    }
}