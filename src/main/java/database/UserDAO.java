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
 
    Connection connection; 
    
    public UserDAO() {
        DBConn conn = new DBConn();
        connection = conn.getConnection("homebanking", "root", "root");
    }
    
    public User getUser(int id) throws SQLException {
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
              
            return user;
    }
}
