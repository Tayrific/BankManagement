/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tayrific.BankManagement.service;

import com.tayrific.BankManagement.Repository.UserRepository;
import com.tayrific.BankManagement.entity.User;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repo;
    
    
    @Override
    public User createUser(User user) {
       User userSave  = repo.save(user);
       return userSave;            
    }

    @Override
    public User getUserbyID(int userId) {
        Optional<User> user = repo.findById(userId);
        if (user.isEmpty()) {
            throw new RuntimeException("Userid does not exist");
        }
        User userFound = user.get();
        return userFound;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = repo.findAll();
        return allUsers;
    }

    @Override
    public User updateUser(int userId, User userDetails) {
        User userToUpdate = getUserbyID(userId);  // fetch the existing user by ID

        // Update fields if provided in userDetails
        if (userDetails.getFirstName() != null) {
            userToUpdate.setFirstName(userDetails.getFirstName());
        }
        if (userDetails.getLastName() != null) {
            userToUpdate.setLastName(userDetails.getLastName());
        }
        if (userDetails.getEmail() != null) {
            userToUpdate.setEmail(userDetails.getEmail());
        }
        if (userDetails.getPhoneNumber() != null) {
            userToUpdate.setPhoneNumber(userDetails.getPhoneNumber());
        }
        if (userDetails.getPassword() != null) {
            userToUpdate.setPassword(userDetails.getPassword());
        }

        // Save the updated user back to the repository
        return repo.save(userToUpdate);
    }

    @Override
    public void deleteUser(int userId) {
        repo.deleteById(userId);
    }
    
}
