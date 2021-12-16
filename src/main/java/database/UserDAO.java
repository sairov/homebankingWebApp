/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import config.DBConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author pol_m
 */
public class UserDAO {
    
//    public static void main(String[] args) {
//        
//        UserDAO user = new UserDAO();
//        
//        try {
//            User usuario = user.getUser(1);
//            System.out.print(usuario.getName() + " ");
//            System.out.print(usuario.getLastName() + " - ");
//            System.out.print(usuario.getUsername() + " - ");
//            System.out.print(usuario.getPassword() + " - ");
//            System.out.print(usuario.getEmail());
//            
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        
//    }
// 
    Connection connection; 
    
    public UserDAO() {
        DBConn conn = new DBConn();
        connection = conn.getConnection("homebanking", "root", "root");
    }
    
    public List<User> getUsers(int limit)throws SQLException {
        PreparedStatement ps;
        ResultSet rs;
        List<User> usersDB = new ArrayList<>();
            
        ps = connection.prepareStatement("SELECT * FROM users LIMIT ?");
            ps.setInt(1, limit);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                usersDB.add(new User(rs.getString("username"), rs.getString("password")));
            }
            
            rs.close();
            ps.close();
            connection.close();
        
        return usersDB;
    }

    public User getUserByID(int id) throws SQLException {
        PreparedStatement preparedSt;
        ResultSet resultSt;
        User user = null;
        
            preparedSt = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            preparedSt.setInt(1, id);
            resultSt = preparedSt.executeQuery();
                  
            if(resultSt.next()) {
                String username = resultSt.getString("username");
                String password = resultSt.getString("password");
                String name = resultSt.getString("name");
                String lastName = resultSt.getString("last_name");
                String email = resultSt.getString("email");
                
                user = new User(username, password, name, lastName, email);
            }
            
            resultSt.close();
            preparedSt.close();
            connection.close();
            return user;
    }
    
    public User getUserByUserName(String username) throws SQLException {
        PreparedStatement preparedSt;
        ResultSet resultSt;
        User user = null;
        
            preparedSt = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            preparedSt.setString(1, username);
            resultSt = preparedSt.executeQuery();
                  
            if(resultSt.next()) {
                String userName = resultSt.getString("username");
                String password = resultSt.getString("password");
                String name = resultSt.getString("name");
                String lastName = resultSt.getString("last_name");
                String email = resultSt.getString("email");
                
                user = new User(userName, password, name, lastName, email);
            }
               
            return user;
    }
    
    public boolean login(String username, String password) throws SQLException {
        PreparedStatement ps;
        ResultSet rs;

        ps = connection.prepareStatement("SELECT username, password FROM users WHERE username = ? AND password = ?");
        ps.setString(1, username);
        ps.setString(2, password);
        rs = ps.executeQuery();
        
        rs.close();
        ps.close();
        connection.close();
        return rs.next();
    }
    
    public boolean createUser(String username, String password, String name, String lastname, String email, String gender, String repass) throws SQLException {
        PreparedStatement ps;
        ResultSet rs;
        
        if (password.equals(repass)) {
            ps = connection.prepareStatement("INSERT INTO users(username, password, name, last_name, email, gender) "
                + "VALUES(?, ?, ?, ?, ?, ?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setString(4, lastname);
            ps.setString(5, email);
            ps.setString(6, gender);
            ps.executeUpdate();
            
            ps = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
              return true;
            }
          return false;  
        }       
       return false;    
    }
    
}
