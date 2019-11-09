/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soen387.repository.core;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.Part;

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
     
    static repositoryCore obj = new repositoryCore();
    
    private repositoryCore(){}
    
    public static repositoryCore getInstance(){
        return obj;
    }
     
    
 public String listAllBooks() throws ClassNotFoundException, SQLException{
         
        String bookList="<form action=\"deleteBook\" method=\"Post\">";  
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
            bookList += "<td>"+myRs.getString("picture")+"</td>";
            bookList += "<td>"+myRs.getString("title")+"</td>";
            bookList += "<td>"+myRs.getString("ISBN")+"</td>";
            bookList += "<td>"+myRs.getString("description")+"</td>";
            bookList += "<td>"+myRs.getString("firstName")+"</td>";
            bookList += "<td>"+myRs.getString("lastName")+"</td>";
            bookList += "<td>"+myRs.getString("publisher_company")+"</td>";
             bookList += "<td>"+myRs.getString("publisher_address")+"</td>";
            bookList += "<input type=\"hidden\" name=\"hdnbt\" value=\""+ myRs.getString("id")  +"\"/>";
            bookList += "<td><input type=\"submit\" name=\"deleteBtn\" value=\"delete\"></td>";
            bookList+= "</tr>";
            }
        bookList+="</form>";
        myRs.close();   
        
   return bookList;
 }   
 
 //return id of book to get info
   public HashMap getBookId(int id) throws SQLException, ClassNotFoundException{
     
            Connection myCon = null;
            Statement myStm = null;
             ResultSet rs = null;
           
            
         Class.forName("com.mysql.jdbc.Driver");
            myCon = DriverManager.getConnection(dbURL, user, pw);
            myStm = myCon.createStatement();
            // constructs SQL statement
            String sql = "SELECT * FROM Book WHERE id = \'" + id +"\'";
            PreparedStatement statement = myCon.prepareStatement(sql);
            rs = statement.executeQuery(sql);
        
            HashMap row = new HashMap(1);
            if(rs.next()){
            row.put(1, rs.getString("picture"));
            row.put(2, rs.getString("title"));
            row.put(3, rs.getString("ISBN"));
            row.put(4, rs.getString("description"));
            row.put(5, rs.getString("firstName"));
            row.put(6, rs.getString("lastName"));
            row.put(7, rs.getString("publisher_Company"));
            row.put(8, rs.getString("publisher_address"));
            }

     return row;
 
 }
 
 
 public HashMap getBookInfo(String isbn) throws SQLException, ClassNotFoundException{
     
            Connection myCon = null;
            Statement myStm = null;
             ResultSet rs = null;
           
            
         Class.forName("com.mysql.jdbc.Driver");
            myCon = DriverManager.getConnection(dbURL, user, pw);
            myStm = myCon.createStatement();
            // constructs SQL statement
            String sql = "SELECT * FROM Book WHERE ISBN = \'" + isbn +"\'";
            PreparedStatement statement = myCon.prepareStatement(sql);
            rs = statement.executeQuery(sql);
        
            HashMap row = new HashMap(1);
            if(rs.next()){
            row.put(1, rs.getString("picture"));
            row.put(2, rs.getString("title"));
            row.put(3, rs.getString("ISBN"));
            row.put(4, rs.getString("description"));
            row.put(5, rs.getString("firstName"));
            row.put(6, rs.getString("lastName"));
            row.put(7, rs.getString("publisher_Company"));
            row.put(8, rs.getString("publisher_address"));
            }

     return row;
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
        String publisherCompany = bookInfo.getPublisherCompany();
        String publisherAddress = bookInfo.getPublisherAddress();
 
        System.out.println("t:" + getTitle + " d:" + getDescription + " fn: " + firstName + " ln:" + lastName +" p: " + publisherCompany + " pa: " + publisherAddress);
        
      try {
        Class.forName("com.mysql.jdbc.Driver");
        myCon = DriverManager.getConnection(dbURL, user, pw);
        myStm = myCon.createStatement();
        
         String sql = "INSERT INTO book (title, description, ISBN, firstName, lastName, picture, publisher_company, publisher_address) VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
            PreparedStatement statement = myCon.prepareStatement(sql);
           statement.setString(1, getTitle);
           statement.setString(2,getDescription);
           statement.setString(3, getIsbn);
           statement.setString(4, firstName);
           statement.setString(5, lastName);
           statement.setString(6, "a picture");
           statement.setString(7, publisherCompany);
           statement.setString(8, publisherAddress);
           
           statement.execute();
           
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

         String sql = "UPDATE book SET title = ? SET description = ? SET firstName = ? SET lastName = ? WHERE ISBN = ?";
            PreparedStatement statement = myCon.prepareStatement(sql);
            statement.setString(1, getTitle);
            statement.setString(2, getDescription);
            statement.setString(3, firstName);
            statement.setString(4, lastName);
            statement.setString(5, getIsbn);
            statement.execute();
           
        myStm.close();
        } catch(SQLException e) {
        for (Throwable t : e)
        t.printStackTrace();
        }
}

public void setImage(Part filePart, String isbn) throws SQLException, IOException{
      // gets values of text fields
        
         
        InputStream inputStream = null; // input stream of the upload file
         
      
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
         
        
            Connection myCon = null;
            Statement myStm = null;
        
            // constructs SQL statement
            String sql = "UPDATE book SET picture = ? WHERE ISBN = " + "\""+ isbn +"\"";
            PreparedStatement statement = myCon.prepareStatement(sql);
            
            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                statement.setBlob(1, inputStream);
            }
          
}

public void deleteBook(int id) throws ClassNotFoundException{
    
        Connection myCon = null;
        Statement myStm = null;
      
      try {
        Class.forName("com.mysql.jdbc.Driver");
        myCon = DriverManager.getConnection(dbURL, user, pw);
        myStm = myCon.createStatement();
        
        myStm.executeUpdate("DELETE FROM book WHERE id =" + "\"" +id +"\"" );
        myStm.close();
        } catch(SQLException e) {
        for (Throwable t : e)
        t.printStackTrace();
        }
    
}


public void deleteAllBooks() throws ClassNotFoundException{
       
        Connection myCon = null;
        Statement myStm = null;
        
      try {
        Class.forName("com.mysql.jdbc.Driver");
        myCon = DriverManager.getConnection(dbURL, user, pw);
        myStm = myCon.createStatement();
        
         String sql = "DELETE FROM book;";
            PreparedStatement statement = myCon.prepareStatement(sql); 
           statement.execute();
           
        myStm.close();
        
        } catch(SQLException e) {
        for (Throwable t : e)
        t.printStackTrace();
        }     
}

public int getBookId(String isbn) throws ClassNotFoundException{
        Connection myCon = null;
        Statement myStm = null;
      int id = 0;
      try {
        Class.forName("com.mysql.jdbc.Driver");
        myCon = DriverManager.getConnection(dbURL, user, pw);
        myStm = myCon.createStatement();
        
        myStm.executeUpdate("DELETE FROM book;" );
        myStm.close();
        } catch(SQLException e) {
        for (Throwable t : e)
        t.printStackTrace();
        }
      
      return id;
}

  
}


