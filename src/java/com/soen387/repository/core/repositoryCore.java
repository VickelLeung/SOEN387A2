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
    
     
    static repositoryCore obj = new repositoryCore();
    
    private repositoryCore(){}
    
    public static repositoryCore getInstance(){
        return obj;
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
            PreparedStatement statement = myCon.prepareStatement(sql);
           
            myRs = myStm.executeQuery(sql);
            while(myRs.next()){
         
            bookList+= "<tr bgcolor='#E0FFFF'>";
           
            bookList += "<td><img width=\"250px\" height=\"300px\" src=\"imageServlet?id=" +myRs.getString("id")+ "\"/>"
                    +" <form enctype=\"multipart/form-data\"  action=\"uploadCoverImage\" method=\"POST\">"
                    + "<input type=\"hidden\" name=\"test\" value=\""+ myRs.getString("id")+"\"/>"
                    + "<input type=\"file\" name=\"photo\" value=\"Add a cover picture\">"
                    + "<input type=\"submit\" name=\"uploadBtn\" value=\"upload cover\" />"
                    + "</form></td>";
            bookList += "<td>"+myRs.getString("title")+"</td>";
            bookList += "<td>"+myRs.getString("ISBN")+"</td>";
            bookList += "<td>"+myRs.getString("description")+"</td>";
            bookList += "<td>"+myRs.getString("firstName")+"</td>";
            bookList += "<td>"+myRs.getString("lastName")+"</td>";
            bookList += "<td>"+myRs.getString("publisher_company")+"</td>";
            bookList += "<td>"+myRs.getString("publisher_address")+"</td>";
            bookList +="<form action=\"deleteBook\" method=\"Post\">";
            bookList += "<input type=\"hidden\" name=\"hdnbt\" value=\""+ myRs.getString("id")+"\"/>";
            bookList += "<td><input type=\"submit\" name=\"deleteBtn\" value=\"delete\"></td>";
            bookList+="</form>";
            bookList+= "</tr>";
            }
       
        myRs.close();   
        
   return bookList;
 }   
 
 //return id of book to get info
   public HashMap getBookInfo(int id) throws SQLException, ClassNotFoundException{
     
            Connection myCon = null;
//            Statement myStm = null;
             ResultSet rs = null;
           
            
         Class.forName("com.mysql.jdbc.Driver");
            myCon = DriverManager.getConnection(dbURL, user, pw);
//            myStm = myCon.createStatement();
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
//            Statement myStm = null;
             ResultSet rs = null;
            
         Class.forName("com.mysql.jdbc.Driver");
            myCon = DriverManager.getConnection(dbURL, user, pw);
//            myStm = myCon.createStatement();
            // constructs SQL statement
            String sql = "SELECT * FROM Book WHERE ISBN = \'"+ isbn +"\'";
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
    
public int addNewBook(Book bookInfo) throws ClassNotFoundException, IOException{
        int ok = 0;
        
        Connection myCon = null;
        Statement myStm = null;

        generateId();
        String getTitle = bookInfo.getTitle();
        String getDescription = bookInfo.getDescription();
        String getIsbn = bookInfo.getIsbn();
        String firstName = bookInfo.getFirstName();
        String lastName = bookInfo.getLastName();
        String publisherCompany = bookInfo.getPublisherCompany();
        String publisherAddress = bookInfo.getPublisherAddress();
//        Part img = bookInfo.getPicture();
        
        System.out.println("t:" + getTitle + " d:" + getDescription + " fn: " + firstName + " ln:" + lastName +" p: " + publisherCompany + " pa: " + publisherAddress);
//        System.out.println("img: " + img);
        
      try {
        Class.forName("com.mysql.jdbc.Driver");
        myCon = DriverManager.getConnection(dbURL, user, pw);
        myStm = myCon.createStatement();
        
        String sql = "INSERT INTO book (id ,title, description, ISBN, firstName, lastName, picture, publisher_company, publisher_address) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
           PreparedStatement statement = myCon.prepareStatement(sql);
           statement.setInt(1, id);
           statement.setString(2, getTitle);
           statement.setString(3,getDescription);
           statement.setString(4, getIsbn);
           statement.setString(5, firstName);
           statement.setString(6, lastName);
//           statement.setBinaryStream(7, img.getInputStream(), (int)  img.getSize());
           statement.setString(7, "a picture");
           statement.setString(8, publisherCompany);
           statement.setString(9, publisherAddress);
           
           statement.execute();
        
        myCon.commit();
        myStm.close();
        myCon.close();
        
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

public void setImage(Part filePart, int id) throws SQLException, IOException, ClassNotFoundException{
        // gets values of text fields
                
        InputStream inputStream = null; // input stream of the upload file
        Connection myCon = null;
        Statement myStm = null;
      
        if (filePart != null) {
//            // prints out some information for debugging
//            System.out.println(filePart.getName());
//            System.out.println(filePart.getSize());
//            System.out.println(filePart.getContentType());
//             
//            // obtains input stream of the upload file
//            inputStream = filePart.getInputStream();
//        }
         
            Class.forName("com.mysql.jdbc.Driver");
            myCon = DriverManager.getConnection(dbURL, user, pw);
            myStm = myCon.createStatement();
            
//            File fBlob = filePart;
//            FileInputStream is = new FileInputStream ( fBlob );
            InputStream is = null;
            if(filePart != null){
                String fileSize = filePart.getContentType();
                is = filePart.getInputStream();
            }
            
            // constructs SQL statement
            String sql = "UPDATE book SET picture = ? WHERE id = " + "\""+ id +"\"";
            PreparedStatement statement = myCon.prepareStatement(sql);
                
//            if (is != null) {
//                 fetches input stream of the upload file for the blob column
                statement.setBlob(1, is);
//                statement.setBinaryStream(1, inputStream);
//                statement.setBinaryStream (2, is, (int) fBlob.length() );
                statement.execute();

//            }          
            
            
            
//        pstmt.setBinaryStream (2, is, (int) fBlob.length() );
//        pstmt.execute ();
            
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

public void generateId() throws ClassNotFoundException{
    
    int getCurrentId = getLastId();
    
    id = ++getCurrentId; 
    
}

public int getLastId() throws ClassNotFoundException{
    
    int id = 0;

        Connection myCon = null;
        Statement myStm = null;
        ResultSet rs = null;
        
      try {
        Class.forName("com.mysql.jdbc.Driver");
        myCon = DriverManager.getConnection(dbURL, user, pw);
        myStm = myCon.createStatement();
        
        String sql = "SELECT id FROM book ORDER BY id DESC LIMIT 1;";
        PreparedStatement statement = myCon.prepareStatement(sql); 
//       statement.execute();
      rs = statement.executeQuery(sql);
        
      if(rs.next()){
          id = rs.getInt("id");
      }
           
        myStm.close();
        
        } catch(SQLException e) {
        for (Throwable t : e)
        t.printStackTrace();
        }     
      
      if(id == 0)
          return id= 0;
      
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



