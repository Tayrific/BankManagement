/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tayrific.BankManagement.service;

import com.tayrific.BankManagement.DTO.AccountDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tayrific.BankManagement.Repository.AccountRepository;
import com.tayrific.BankManagement.entity.Account;
import jakarta.transaction.Transactional;
import java.util.ArrayList;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repo;
    
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account createAccount(Account account) {
        return repo.save(account);
    }

    @Override
    public AccountDTO getAccountById(int accountId) {
        Account account = repo.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        
        return accountMapper.toDTO(account);
    }

    @Override
    public List<AccountDTO> getUsersAccounts(int userId) {
        List<Account> allAccounts = repo.findByUser_userId(userId);
        List<AccountDTO> allAccountsDTO = new ArrayList<>();
        for (Account account : allAccounts) {
            allAccountsDTO.add(accountMapper.toDTO(account));
        }
        return allAccountsDTO;
    }

    @Override
    @Transactional
    public AccountDTO depositMoney(int accountId, double amount) {
        Account account = repo.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        
        account.setBalance(account.getBalance() + amount);
        repo.save(account);

        return getAccountById(accountId);
    }

    @Override
    @Transactional
    public AccountDTO withdrawMoney(int accountId, double amount) {
        Account account = repo.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }

        account.setBalance(account.getBalance() - amount);
        repo.save(account);

        return getAccountById(accountId);
    }

    @Override
    public void deleteAccount(int accountId) {
        repo.deleteById(accountId);
    }
}

