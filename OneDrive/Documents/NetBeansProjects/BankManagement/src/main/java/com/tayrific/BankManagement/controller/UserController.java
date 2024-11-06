/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tayrific.BankManagement.controller;

import com.tayrific.BankManagement.Repository.UserRepository;
import com.tayrific.BankManagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    
    @Autowired
    private UserRepository userRepository;
    
    
    @PostMapping("/add")
    public User createUser(@RequestBody User user) {       
        return null;      
    }
    
}
