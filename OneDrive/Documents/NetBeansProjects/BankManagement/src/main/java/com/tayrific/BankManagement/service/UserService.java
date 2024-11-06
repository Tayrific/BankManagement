/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tayrific.BankManagement.service;

import com.tayrific.BankManagement.entity.User;
import java.util.List;

public interface UserService {
    public User createUser(User user);
    public User getUserDetails(int userId);
    public List<User> getAllUsers();
    public void updateUser(int userId);
    public void deleteUser(int userId);
   
}
