/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.AccountDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author pol_m
 */
public class User {
    private String username;
    private String password;
    private String name;
    private String lastName;
    private String gender;
    private String email;
    private String avatar;
    private List<Account> userAccounts;
    
    public User(String username, String password, String name, String lastName, String gender, String email, String avatar) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.avatar = avatar;
        
        AccountDAO accounts = new AccountDAO();
        try {
            this.userAccounts = accounts.getAccounts(1, 5);
        } catch(SQLException e) {
            
        }
        
    }
    
    public User(String username, String password, String name, String lastName, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.avatar = avatar;
    }
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
