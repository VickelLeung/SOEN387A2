/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soen387.repository.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.Part;
import tableDataGateway.bookGateway;

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
    
  
//    final String dbURL = "jdbc:mysql://den1.mysql2.gear.host/soencourse";
//    final String userName = "soencourse";
//    final String pw = "Gy51!A1G~5uH";
     private bookGateway bg = new bookGateway();
     
    static repositoryCore obj = new repositoryCore();
    
    private repositoryCore(){}
    
    public static repositoryCore getInstance(){
        return obj;
    }
     
    
 public HashMap<Integer,ArrayList<String>> listAllBooks() throws ClassNotFoundException, SQLException{
      
   HashMap<Integer,ArrayList<String>> bookList = bg.getBookList();
        
   return bookList;
 }   
 
 //return id of book to get info
   public HashMap getBookInfo(int id) throws SQLException, ClassNotFoundException{
         
            HashMap row = bg.findByID(id);

     return row;
 
 }
 
 
 public HashMap getBookInfo(String isbn) throws SQLException, ClassNotFoundException{

        HashMap row = bg.findByISBN(isbn);
            
     return row;
 }
    
public int addNewBook(Book bookInfo) throws ClassNotFoundException, IOException{
        int ok = 0;


        generateId();
        
//        //check if there is any duplicate isbn
           
            String title = bookInfo.getTitle();
            String description = bookInfo.getDescription();
            String isbn = bookInfo.getIsbn();
            String firstName = bookInfo.getFirstName();
            String lastName = bookInfo.getLastName();
            String publisherCompany = bookInfo.getPublisherCompany();
            String publisherAddress = bookInfo.getPublisherAddress();
            
            bg.insert(id, isbn, title, description, firstName, lastName, publisherCompany, publisherAddress);
            
    
    return ok;
}
    
public void updateBookInfo(Book b) throws ClassNotFoundException, SQLException{
   
        String getIsbn = b.getIsbn();
        String getTitle = b.getTitle();
        String getDescription = b.getDescription();
        String firstName = b.getFirstName();
        String lastName = b.getLastName();
        String company = b.getPublisherCompany();
        String address = b.getPublisherAddress();
        
    bg.update(getIsbn, getTitle, getDescription, firstName, lastName, company, address);
}

public void setImage(Part filePart, int id) throws SQLException, IOException, ClassNotFoundException{
     
    bg.setBookImage(filePart, id);
           
}

public void deleteBook(int id) throws ClassNotFoundException{
    
         bg.delete(id);
}


public void deleteAllBooks() throws ClassNotFoundException{
       
      bg.deleteAll();
}

public void generateId() throws ClassNotFoundException{
    
    int getCurrentId = getLastId();
    
    id = ++getCurrentId; 
    
}

public int getLastId() throws ClassNotFoundException{
    
    int id = bg.getLastId();
    
    return id;
   
}


public static void main(String[] args) throws ClassNotFoundException{
    
   repositoryCore re = new repositoryCore();
    
   int ids =  re.getLastId();
   System.out.println(ids);
   re.generateId();
   System.out.println(id);
   
    
   
}

}



