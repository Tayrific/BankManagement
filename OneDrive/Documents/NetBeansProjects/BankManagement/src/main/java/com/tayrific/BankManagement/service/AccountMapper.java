/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tayrific.BankManagement.service;

import com.tayrific.BankManagement.DTO.AccountDTO;
import com.tayrific.BankManagement.entity.Account;
import org.springframework.stereotype.Service;


@Service
public class AccountMapper {
    public AccountDTO toDTO(Account account) {
        return new AccountDTO(
                account.getAccountId(),
                account.getAccountNumber(),
                account.getAccountType(),
                account.getBalance(),
                account.getUser().getUserId()   
        );
    }
    
    public Account toEntity(AccountDTO accountDTO) {
        Account account = new Account();
        account.setAccountId(accountDTO.getAccountId());
        // Set other fields as needed
        return account;
    }
}