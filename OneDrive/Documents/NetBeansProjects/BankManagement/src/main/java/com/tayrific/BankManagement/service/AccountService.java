/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tayrific.BankManagement.service;

import com.tayrific.BankManagement.DTO.AccountDTO;
import com.tayrific.BankManagement.entity.Account;
import java.util.List;

/**
 *
 * @author tayyi
 */
public interface AccountService {
    
    public Account createAccount(Account account);
    public AccountDTO getAccountByID(int accountId);
    public List<AccountDTO> getUsersAccounts(int userId);
    public AccountDTO depositMoney(int accountId, double amount);
    public AccountDTO withdrawMoney(int accountId, double amount);
    public void deleteAccount(int accountId);
      
}
