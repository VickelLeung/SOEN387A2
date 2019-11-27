/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableDataGateway;

import com.soen387.repository.core.repositoryCore;
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
public class bookGateway {
   
    final String dbURL = "jdbc:mysql://SG-soen-1578-master.servers.mongodirector.com:3306/soen";
    final String userName = "sgroot";
    final String password = "pSIfClQJ6fMkZK-r";
   
     public HashMap findByID(int id) throws ClassNotFoundException, SQLException{
         // find book by id.
        HashMap bookSet = new HashMap(1);
        
        Connection myCon = null;
        ResultSet rs = null;
            
         Class.forName("com.mysql.jdbc.Driver");
         myCon = DriverManager.getConnection(dbURL, userName, password);

            // constructs SQL statement
            String sql = "SELECT * FROM Book WHERE id = \'"+ id +"\'";
            PreparedStatement statement = myCon.prepareStatement(sql);
            rs = statement.executeQuery(sql);
        
            HashMap row = new HashMap(1);
            
            if(rs.next()){
            bookSet.put(1, rs.getString("picture"));
            bookSet.put(2, rs.getString("title"));
            bookSet.put(3, rs.getString("ISBN"));
            bookSet.put(4, rs.getString("description"));
            bookSet.put(5, rs.getString("firstName"));
            bookSet.put(6, rs.getString("lastName"));
            bookSet.put(7, rs.getString("publisher_Company"));
            bookSet.put(8, rs.getString("publisher_address"));
            bookSet.put(9, rs.getString("id"));
            }
         
         return bookSet;
    }
     
    public HashMap findByISBN(String isbn) throws ClassNotFoundException, SQLException{
        // find book by isbn.
        HashMap bookSet = new HashMap(1);
        
        
            Connection myCon = null;
            ResultSet rs = null;
            
         Class.forName("com.mysql.jdbc.Driver");
         myCon = DriverManager.getConnection(dbURL, userName, password);
            // constructs SQL statement
            String sql = "SELECT * FROM Book WHERE ISBN = \'"+ isbn +"\'";
            PreparedStatement statement = myCon.prepareStatement(sql);
            rs = statement.executeQuery(sql);
            
            if(rs.next()){
            bookSet.put(1, rs.getString("picture"));
            bookSet.put(2, rs.getString("title"));
            bookSet.put(3, rs.getString("ISBN"));
            bookSet.put(4, rs.getString("description"));
            bookSet.put(5, rs.getString("firstName"));
            bookSet.put(6, rs.getString("lastName"));
            bookSet.put(7, rs.getString("publisher_Company"));
            bookSet.put(8, rs.getString("publisher_address"));
            bookSet.put(9, rs.getString("id"));
            }
         
         return bookSet;
    }
    
    public void update(String isbn, String title, String description, String firstName, String lastName, String company, String address) throws ClassNotFoundException, SQLException{
       
       Connection myCon = null;
       Statement myStm = null;
     
       HashMap bookSet = new HashMap();
       
       bookSet = findByISBN(isbn);
       
       if(title.equals(""))
       {
           title = bookSet.get(2).toString();
       }
       if(description.equals("")){
           description= bookSet.get(4).toString();
       }
       if(firstName.equals("")){
           firstName = bookSet.get(5).toString();
       }
       if(lastName.equals("")){
           lastName = bookSet.get(6).toString();
       }
       if(company.equals("")){
           company = bookSet.get(7).toString();
       }
       if(address.equals("")){
           address = bookSet.get(7).toString();
       }
       
       System.out.println("t: " + title);
       
      try {
        Class.forName("com.mysql.jdbc.Driver");
        myCon = DriverManager.getConnection(dbURL, userName, password);
        myStm = myCon.createStatement();
     
            String sql = "UPDATE Book SET title = ? , description = ? , firstName = ? , lastName = ?, publisher_company = ?, publisher_address = ?  WHERE ISBN = ?";
            PreparedStatement statement = myCon.prepareStatement(sql);
            statement.setString(1, title);
            statement.setString(2, description);
            statement.setString(3, firstName);
            statement.setString(4, lastName);
            statement.setString(5, company);
            statement.setString(6, address);
            statement.setString(7, isbn);
            statement.execute();
           
        myStm.close();
        } catch(SQLException e) {
        for (Throwable t : e)
        t.printStackTrace();
        }
    
    }
    public void insert(int id, String isbn, String title, String description, String firstName, String lastName, String publisherCompany, String publisherAddress) throws ClassNotFoundException{
         // insert book entity.
        
       Connection myCon = null;
       Statement myStm = null;
        
          try {
            Class.forName("com.mysql.jdbc.Driver");
            myCon = DriverManager.getConnection(dbURL, userName, password);
            myStm = myCon.createStatement();
// INSERT INTO book (id ,title, description, ISBN, firstName, lastName, picture, publisher_company, publisher_address) 
            String sql = "INSERT INTO Book (id ,title, description, ISBN, firstName, lastName, publisher_company, publisher_address, picture) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
               PreparedStatement statement = myCon.prepareStatement(sql);
               statement.setInt(1, id);
               statement.setString(2, title);
               statement.setString(3,description);
               statement.setString(4, isbn);
               statement.setString(5, firstName);
               statement.setString(6, lastName);
    //           statement.setBinaryStream(7, img.getInputStream(), (int)  img.getSize());
//               statement.setString(7, "a picture");
               statement.setString(7, publisherCompany);
               statement.setString(8, publisherAddress);
                statement.setString(9, "");

               statement.execute();

            myCon.commit();
            myStm.close();
            myCon.close();

            //book added
//            ok = 1;
            } catch(SQLException e) {
            for (Throwable t : e)
            t.printStackTrace();
            }     
    }
    public void delete(int id) throws ClassNotFoundException{
        // Delete book record by id from database.
        
        Connection myCon = null;
        Statement myStm = null;
      
      try {
        Class.forName("com.mysql.jdbc.Driver");
      myCon = DriverManager.getConnection(dbURL, userName, password);
        myStm = myCon.createStatement();
        
        myStm.executeUpdate("DELETE FROM Book WHERE id =" + "\"" +id +"\"" );
        myStm.close();
        } catch(SQLException e) {
        for (Throwable t : e)
        t.printStackTrace();
        }
    }    
    
    public void deleteAll() throws ClassNotFoundException{
        //Delete all book record from database
        
        Connection myCon = null;
        Statement myStm = null;
        
      try {
        Class.forName("com.mysql.jdbc.Driver");
        myCon = DriverManager.getConnection(dbURL, userName, password);
        myStm = myCon.createStatement();
        
         String sql = "DELETE FROM Book;";
            PreparedStatement statement = myCon.prepareStatement(sql); 
           statement.execute();
           
        myStm.close();
        
        } catch(SQLException e) {
        for (Throwable t : e)
        t.printStackTrace();
        }     
    }
    
    public void setBookImage(Part filePart, int id) throws ClassNotFoundException, SQLException, IOException{
        InputStream inputStream = null; // input stream of the upload file
        Connection myCon = null;
        Statement myStm = null;
      
        if (filePart != null) {

            Class.forName("com.mysql.jdbc.Driver");
                myCon = DriverManager.getConnection(dbURL, userName, password);
            myStm = myCon.createStatement();
            
            InputStream is = null;
            if(filePart != null){
                String fileSize = filePart.getContentType();
                is = filePart.getInputStream();
            }
            
            // constructs SQL statement
            String sql = "UPDATE Book SET picture = ? WHERE id = " + "\""+ id +"\"";
            PreparedStatement statement = myCon.prepareStatement(sql);

                statement.setBlob(1, is);
                statement.execute();
                
                 System.out.println("b: " + is);
        } 
        
       
    }
    
    
    public HashMap<Integer,ArrayList<String>> getBookList() throws ClassNotFoundException, SQLException{
        
         HashMap<Integer, ArrayList<String>> bookList = new HashMap<>();
       
        Connection myCon = null;
        Statement myStm = null;
        ResultSet myRs = null;
      
        Class.forName("com.mysql.jdbc.Driver");
        myCon = DriverManager.getConnection(dbURL, userName, password);
        myStm = myCon.createStatement();
            
           String sql ="SELECT * FROM Book";
            PreparedStatement statement = myCon.prepareStatement(sql);
           
            myRs = myStm.executeQuery(sql);
            while(myRs.next()){
        
            ArrayList<String> book = new ArrayList();
            book.add(myRs.getString("title"));
            book.add(myRs.getString("ISBN"));
            book.add(myRs.getString("description")); 
            book.add(myRs.getString("firstName")); 
            book.add(myRs.getString("lastName")); 
            book.add(myRs.getString("publisher_company"));
            book.add(myRs.getString("publisher_address"));
            System.out.println("id: " + myRs.getInt("id"));
            System.out.println("title: " + myRs.getString("title"));
            bookList.put(myRs.getInt("id"), book);
            
            }
  
        myRs.close();   
        
        return bookList;
    }
    
    
    public int getLastId() throws ClassNotFoundException{
        int id = 0;

        Connection myCon = null;
        Statement myStm = null;
        ResultSet rs = null;
        
      try {
        Class.forName("com.mysql.jdbc.Driver");
        myCon = DriverManager.getConnection(dbURL, userName, password);
        myStm = myCon.createStatement();
        
        String sql = "SELECT id FROM Book ORDER BY id DESC LIMIT 1;";
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
    
}
