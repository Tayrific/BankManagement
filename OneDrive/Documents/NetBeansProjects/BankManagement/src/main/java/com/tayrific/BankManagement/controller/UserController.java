/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tayrific.BankManagement.controller;

import com.tayrific.BankManagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tayrific.BankManagement.service.UserService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    
    @Autowired
    UserService service;
    
    
    @PostMapping("/add")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createUser = service.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUser);
    }
    
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserByID(@PathVariable int userId) {
        User user = service.getUserbyId(userId);
        return ResponseEntity.ok(user);
    }
    
    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> allUsers = service.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }
    
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable int userId,  @RequestBody User userDetails){
        User updateUser = service.updateUser(userId, userDetails);
        return ResponseEntity.ok(updateUser);
    }
    
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable int userId) {
        service.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
    
}
