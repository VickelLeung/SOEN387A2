/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soen387.repository.core;

import java.util.HashMap;
import javax.servlet.http.Part;

/**
 *
 * @author Vicke
 */
interface IBookRepository {
          
public String listAllBooks();
 
public HashMap getBookId(int i);
 
public HashMap getBookInfo(String i);
    
public int addNewBook(Book bookInfo);
    
public void updateBookInfo(int i, Book b);

public void setImage(Part f, String i);
public void deleteBook(int i);

public void deleteAllBooks();

public int getBookId(String i);

public int autoIncrement();
public void setAutoId(int i);

public int getAutoId();
   

    
}
