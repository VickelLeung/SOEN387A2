/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soen387.repository.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Vickel
 */

public class repositoryCore {
    
    // Global variables
    private static int id; //have to be auto generate
    private static String title;
    private static String description;
    private static String isb; //unique
    private static String author;
    private static String publisher;
    private static String cover;
    
     public static void main(String[] args){
         
     }
    
    
 public static void listAllBooks(){
     
        Connection myCon = null;
        Statement myStm = null;
        ResultSet myRs = null;
        ResultSet insert=null;

        String user = "root";
        String pw = "reactgod";
        String dbURL = "jdbc:mysql://localhost:3306/Book";
        String values = "";
          
      try {

        myCon = DriverManager.getConnection(dbURL, user, pw);
        myStm = myCon.createStatement();
          
    
            myRs = myStm.executeQuery("select * from book");
             while(myRs.next()){
            System.out.println(myRs.getString("title"));
            System.out.println(myRs.getString("ISBN"));
           
        }
        
        myRs.close();
        
        values ="VALUES('here johnny','johnnyboi','S8K25O90','will smith','actions');";
        myStm.executeUpdate("INSERT INTO book (title, description, ISBN, author, publisher)" + values);
        
        } catch(SQLException e) {
        for (Throwable t : e)
        t.printStackTrace();
        }
        
   
 }   
 
 public int getBookInfo(int id){
     
     Connection myCon = null;
         Statement myStm = null;
         ResultSet myRs = null;
        
         String user = "root";
         String pw = "reactgod";
         String dbURL = "jdbc:mysql://localhost:3306/Book";
         String values = "";
          
      try {

        myCon = DriverManager.getConnection(dbURL, user, pw);
        myStm = myCon.createStatement();
          
     //         insert = myStm.executeQuery("  INSERT INTO book (title, description, ISBN, author, publisher)\n" + values);
            myRs = myStm.executeQuery("select * from book");
             while(myRs.next()){
            System.out.println(myRs.getString("title"));
            System.out.println(myRs.getString("ISBN"));
        }
        
        myRs.close();
        
       
        
        } catch(SQLException e) {
        for (Throwable t : e)
        t.printStackTrace();
        }
        
     
     return 0;
 }
 
 
 public String getBookInfo(String isbn){
     
     return "";
 }
    
public int addNewBook(String bookInfo){
        int ok = 0;
        
        Connection myCon = null;
        Statement myStm = null;
       
        String user = "root";
        String pw = "reactgod";
        String dbURL = "jdbc:mysql://localhost:3306/Book";
        String values = "";
          
      try {

        myCon = DriverManager.getConnection(dbURL, user, pw);
        myStm = myCon.createStatement();
         
        values ="VALUES('here johnny','johnnyboi','S8K25O90','will smith','actions');";
        myStm.executeUpdate("INSERT INTO book (title, description, ISBN, author, publisher)" + values);
        myStm.close();
        
        //book added
        ok = 1;
        } catch(SQLException e) {
        for (Throwable t : e)
        t.printStackTrace();
        }
        
    
    return ok;
}
    
public void updateBookInfo(int id, String bookInfo){
        Connection myCon = null;
        Statement myStm = null;
       
        String user = "root";
        String pw = "reactgod";
        String dbURL = "jdbc:mysql://localhost:3306/Book";
        String values = "";
          
      try {

        myCon = DriverManager.getConnection(dbURL, user, pw);
        myStm = myCon.createStatement();
         
        values ="VALUES('here johnny','johnnyboi','S8K25O90','will smith','actions');";
        myStm.executeUpdate("INSERT INTO book (title, description, ISBN, author, publisher)" + values);
        myStm.close();
        } catch(SQLException e) {
        for (Throwable t : e)
        t.printStackTrace();
        }
        
   
}

public void setImage(){
    
}

public void deleteBook(int id){
    
}

public void deleteAllBooks(){
    
}

}


