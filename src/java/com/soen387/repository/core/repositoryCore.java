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
import java.util.ArrayList;

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
    
     private static final String user = "soen387a2";
     private static final String pw = "Lr00IQ5T~!Ma";
     private static final String dbURL = "jdbc:mysql://den1.mysql2.gear.host/soen387a2";
    
     public static void main(String[] args){
         
         //setup the connection
  
     }
     
     public repositoryCore(){}
    
     public repositoryCore(String title, String desciption, String isbn, String firstName, String lastName){
//         Book b = new Book(title, description, isbn, firstName, lastName);
         
     }
     
    
 public String listAllBooks() throws ClassNotFoundException, SQLException{
         
        String bookList="";  
        Connection myCon = null;
        Statement myStm = null;
        ResultSet myRs = null;
      
           
        Class.forName("com.mysql.jdbc.Driver");
        myCon = DriverManager.getConnection(dbURL, user, pw);
        myStm = myCon.createStatement();
            
           String sql ="SELECT * FROM book";

            myRs = myStm.executeQuery(sql);
            while(myRs.next()){
         
            bookList+= "<tr bgcolor='#E0FFFF'>";

            bookList += "<td>"+myRs.getString("title")+"</td>";
            bookList += "<td>"+myRs.getString("ISBN")+"</td>";
            bookList += "<td>"+myRs.getString("description")+"</td>";
            bookList += "<td>"+myRs.getString("firstName")+"</td>";
            bookList += "<td>"+myRs.getString("lastName")+"</td>";
            bookList += "<td>"+myRs.getString("publisher")+"</td>";
            bookList+= "</tr>";
            }
        
        myRs.close();
        
   return bookList;
 }   
 
 //return id of book to get info
 public String getBookInfo(int id){
     
        Connection myCon = null;
        Statement myStm = null;
        ResultSet myRs = null;
         
        String val  = "";
      try {

        myCon = DriverManager.getConnection(dbURL, user, pw);
        myStm = myCon.createStatement();
          
     //         insert = myStm.executeQuery("  INSERT INTO book (title, description, ISBN, author, publisher)\n" + values);
            myRs = myStm.executeQuery("select * from book");
             while(myRs.next()){
            System.out.println(myRs.getString("title"));
            System.out.println(myRs.getString("ISBN"));
            val += myRs.getString("title");
            val += myRs.getString("ISBN");
        }
        
        myRs.close();
        
       
        
        } catch(SQLException e) {
        for (Throwable t : e)
        t.printStackTrace();
        }
        
     return val;
//     return 0;
 }
 
 
 public String getBookInfo(String isbn){
     
     return "";
 }
    
public int addNewBook(Book bookInfo) throws ClassNotFoundException{
        int ok = 0;
        
        Connection myCon = null;
        Statement myStm = null;

        String values = "";
        
        String getTitle = bookInfo.getTitle();
        String getDescription = bookInfo.getDescription();
        String getIsbn = bookInfo.getIsbn();
        String firstName = bookInfo.getFirstName();
        String lastName = bookInfo.getLastName();
        
//        System.out.println("t:" + getTitle + " desc:" + getDescription + " isb:" + getIsbn);
 
      try {
        Class.forName("com.mysql.jdbc.Driver");
        myCon = DriverManager.getConnection(dbURL, user, pw);
        myStm = myCon.createStatement();
        
        values ="VALUES('"+getTitle+"','"+getDescription+"','"+getIsbn+"','"+ firstName +"','"+ lastName +"','actions');";
        myStm.executeUpdate("INSERT INTO book (title, description, ISBN, firstName, lastName, publisher)" + values);
        myStm.close();
        
        //book added
        ok = 1;
        } catch(SQLException e) {
        for (Throwable t : e)
        t.printStackTrace();
        }     
    
    return ok;
}
    
public void updateBookInfo(int id, Book b) throws ClassNotFoundException{
        Connection myCon = null;
        Statement myStm = null;
      
      try {
        Class.forName("com.mysql.jdbc.Driver");
        myCon = DriverManager.getConnection(dbURL, user, pw);
        myStm = myCon.createStatement();
        
        String getTitle = b.getTitle();
        String getDescription = b.getDescription();
        String getIsbn = b.getIsbn();
        String firstName = b.getFirstName();
        String lastName = b.getLastName();
        
        System.out.println("t :" + getTitle + " desc: " + getDescription);
        
        myStm.executeUpdate("UPDATE book SET title = "+ "\"" +getTitle + "\"" + " SET description =" + "\"" +getDescription + "\"" + " SET firstName = "+ "\"" +firstName 
                + "\"" + " SET lastName = " + "\""  +lastName + "\"" + "WHERE ISBN =" +"\"" +getIsbn +"\"");
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


