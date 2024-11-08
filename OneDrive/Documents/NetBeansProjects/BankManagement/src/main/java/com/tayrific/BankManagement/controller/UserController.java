/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tayrific.BankManagement.controller;

import com.tayrific.BankManagement.DTO.UserDTO;
import com.tayrific.BankManagement.entity.User;
import com.tayrific.BankManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    @Autowired
    UserService service;

    // Create user - No password in DTO, password encoded in service
    @PostMapping("/add")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            return ResponseEntity.badRequest().body("Password cannot be null or empty");
        }
        UserDTO createUser = service.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUser);
    }

    // Get user by ID
    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserByID(@PathVariable int userId) {
        UserDTO user = service.getUserbyId(userId);
        return ResponseEntity.ok(user);
    }

    // Get all users
    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> allUsers = service.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }

    // Update user
    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable int userId, @RequestBody UserDTO userDTO) {
        UserDTO updatedUser = service.updateUser(userId, userDTO);
        return ResponseEntity.ok(updatedUser);
    }

    // Delete user
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable int userId) {
        service.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
