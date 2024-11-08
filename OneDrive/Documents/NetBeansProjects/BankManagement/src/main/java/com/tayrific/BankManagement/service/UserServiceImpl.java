package com.tayrific.BankManagement.service;

import com.tayrific.BankManagement.DTO.UserDTO;
import com.tayrific.BankManagement.Repository.UserRepository;
import com.tayrific.BankManagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;



    // Convert User entity to UserDTO
    private UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        return userDTO;
    }

    @Override
    public UserDTO createUser(User user) {

        // Save the user and convert to DTO without password
        user = repo.save(user);
        return convertToDTO(user);
    }

    @Override
    public UserDTO getUserbyId(int userId) {
        Optional<User> user = repo.findById(userId);
        if (user.isEmpty()) {
            throw new RuntimeException("User does not exist");
        }
        return convertToDTO(user.get());
    }

    @Override
    public List<UserDTO> getAllUsers() {
        // Convert all User entities to UserDTOs and return the list
        List<User> allUsers = repo.findAll();
        return allUsers.stream()
                .map(this::convertToDTO)  // Map each User to a UserDTO
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(int userId, UserDTO userDTO) {
        // Fetch the existing user by ID
        User userToUpdate = repo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Update fields if provided in userDetails
        if (userDTO.getFirstName() != null) {
            userToUpdate.setFirstName(userDTO.getFirstName());
        }
        if (userDTO.getLastName() != null) {
            userToUpdate.setLastName(userDTO.getLastName());
        }
        if (userDTO.getEmail() != null) {
            userToUpdate.setEmail(userDTO.getEmail());
        }
        if (userDTO.getPhoneNumber() != null) {
            userToUpdate.setPhoneNumber(userDTO.getPhoneNumber());
        }

        // Save the updated user and convert to DTO
        User updatedUser = repo.save(userToUpdate);
        return convertToDTO(updatedUser);
    }

    @Override
    public void deleteUser(int userId) {
        repo.deleteById(userId);
    }
}