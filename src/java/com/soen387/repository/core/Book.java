/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soen387.repository.core;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Vicke
 */
@Entity
public class Book implements Serializable {
      
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private static String isbn;
    private static String title;
    private static String description;
    private static final long serialVersionUID = 1L;
    private static String firstName;
    private static String lastName;
  
    public Book(){

        isbn = null;
        title = null;
        description = null;
    }
    
    public Book(String is, String t, String desc , Author a){
        
        
        setFirstName(a.getFirstName());
        setLastName(a.getLastName());
        title = t;
        description = desc;
        isbn = is;
    }
    
    public void setId(long i){
        id = i;
    }
    
    public void setIsbn(String isbn){
        isbn = this.isbn;
    }
    
    public void setTitle(String t){
        title = t;
    }
    
    public void setDescription(String desc){
        description = desc;
    }
    
    public long getId(){
        return id;
    }
    
    public String getIsbn(){
        return isbn;
    }
    
    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public void setFirstName(String fn){
        firstName = fn;
    }
    public void setLastName(String ln){
        lastName = ln;
    }
    
    @Override
    public String toString() {
        return "com.soen387.repository.core.Book[ id=" + id + " ]";
    }
    
}
