/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soen387.repository.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Vicke
 */
public class session {
    
    
    public String getCurrentUser(){
    
        return "";
    }
    
    public boolean isUserLoggedIn(){
        
        return false;
    }
    
    public void login(int userId, String password){
        
    }
    
    public void logout(){
        
    }
    
    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
//    private Connection connect() {
//        // SQLite connection string
//        String url = "jdbc:sqlite:C://sqlite/db/test.db";
//        Connection conn = null;
//        try {
//            conn = DriverManager.getConnection(url);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return conn;
//    }
    
    
}
