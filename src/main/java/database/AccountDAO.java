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
import model.Account;

/**
 *
 * @author pol_m
 */
public class AccountDAO {
    Connection connection;

    public AccountDAO() {
        DBConn conn = new DBConn();
        connection = conn.getConnection("homebanking", "root", "root");
    }
     
     public List<Account> getAccounts(int userId, int limit)throws SQLException {
        PreparedStatement ps;
        ResultSet rs;
        List<Account> accountDB = new ArrayList<>();
            
        ps = connection.prepareStatement("SELECT * FROM accounts WHERE user_id = ? LIMIT ?");
            ps.setInt(1, userId);
            ps.setInt(2, limit);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                accountDB.add(new Account(rs.getInt("account_number"), rs.getString("type"), rs.getString("currency"), rs.getLong("balance"), rs.getInt("user_id")));
            }
            
            rs.close();
            ps.close();
            connection.close();
        
        return accountDB;
    }
}
