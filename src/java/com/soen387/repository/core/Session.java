/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soen387.repository.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;


/**
 *
 * @author Vicke
 */
public class Session {
    
    
    public String getCurrentUser(){
    
        return "";
    }
    
    public boolean isUserLoggedIn(){
        
        return false;
    }
    
    public boolean login(String username, String password){
        JSONParser jsonParser = new JSONParser();
        
//        try (FileReader reader = new FileReader("C:\\Users\\zheng\\Desktop\\SOEN387A2\\src\\java\\authentication\\userCredentials.json"))
//        {
//            //Read JSON file
//            Object obj = jsonParser.parse(reader);
// 
//            JSONArray credentials = (JSONArray) obj;
//            System.out.println(credentials);
//             
//            JSONObject jo;
//            //Iterate over employee array
//            for(Object o : credentials){
//                jo = (JSONObject) o;
//                
//                if (username.equals(jo.get("username")) && password.equals(jo.get("pass")))
//                    return true;
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        
        return false;
    }
    
    public void logout(){
        
    }

    
    
}
