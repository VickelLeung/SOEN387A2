/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soen387.repository.core;

/**
 *
 * @author Vickel
 */
public class entity {
    
    private static int id; //have to be auto generate
    private static String title;
    private static String description;
    private static String isb; //unique
    private static String author;
    private static String publisher;
    private static String cover;
    
    public entity(){
       
//       Book();
//       Author();
//       CoverImage();
       
    }
    
    public void Book(int id, String isbn, String title, String description, String author, String cover){
        
    }
    
    public void Author(String firstName, String lastName){
        
    }
    
    public void CoverImage(String mimeType, String imageData){
        
    }
    
}


//Book (id, isbn, title, description, author, cover)
//- Author (firstname, lastname)
//- CoverImage (mimetype, imagedata)