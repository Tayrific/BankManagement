/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tayrific.BankManagement.service;

import com.tayrific.BankManagement.DTO.UserDTO;
import com.tayrific.BankManagement.entity.User;
import java.util.List;

public interface UserService {

    public UserDTO createUser(User user);
    public UserDTO getUserbyId(int userId);
    public List<UserDTO> getAllUsers();
    public UserDTO  updateUser(int userId, UserDTO userDTO);
    public void deleteUser(int userId);
   
}
