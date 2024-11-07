/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tayrific.BankManagement.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import java.util.Set;

@Entity //JPA entity - mapped to a table in DB
@Table(name = "users") //This class is a table
public class User {
    
    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto generate values
    private int userId;
    
    @Column(nullable = false)
    @NotBlank(message = "Must enter a first name")
    private String firstName;
    
    @Column(nullable = false)
    @NotBlank(message = "Must enter a last name")
    private String lastName;
    
    @Column(nullable = false, unique = true)
    @NotBlank(message = "Must enter an email")
    @Email(message = "Must be a valid email format")
    private String email;
    
    @Column(nullable = false) 
    @Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$", message = "Invalid phone number") // Validates phone number format
    private String phoneNumber;
    
    @Column(nullable = false)
    @JsonIgnore
    private String password; 
    
    @OneToMany(mappedBy = "user") // Relationship with Account
    private Set<Account> accounts; // A user can have multiple accounts
    
    

    public User(String firstName, String lastName, String email, String phoneNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public User() {
    }    
   
     // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserID(int userID) {
        this.userId = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password; 
    }

    public void setPassword(String password) {
        this.password = password; 
    }

    @Override
    public String toString() {
        return "User{" + "userID=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + '}';
    }
    
}
