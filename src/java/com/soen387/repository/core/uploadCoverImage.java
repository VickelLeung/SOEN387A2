/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soen387.repository.core;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import servlets.addUpdateBook;

/**
 *
 * @author Vicke
 */
@WebServlet("/upload")
@MultipartConfig
public class uploadCoverImage extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet uploadCoverImage</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet uploadCoverImage at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
//        int id = 0;
//        
//        String ids = request.getParameter("addPic");
        
//        id = Integer.parseInt(ids);
        PrintWriter out = response.getWriter();
        
     
        
       
//        if(ids != null){
//        id = Integer.parseInt(ids);
        
//         out.write("id " + id);
        Part photo = request.getPart("photo");
        
//          File fBlob = new File ( request.getParameter("photo") );
//         out.write("id " + fBlob);
            repositoryCore repo = repositoryCore.getInstance();
        if(photo != null){
            
             int id = 0;
            String ids = request.getParameter("hdnbt");
            out.write("<p>You have uploaded the image</p>");
            out.write("<a href=\"/SOEN387A2/\">Click here to go back home</p>");
            id = Integer.parseInt(ids);	
            
            if (request.getParameter("uploadBtn") != null) {
            try {
                repo.setImage(photo, id);
            } catch (SQLException ex) {
                Logger.getLogger(uploadCoverImage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(uploadCoverImage.class.getName()).log(Level.SEVERE, null, ex);
            }
           }
                
        }
        
        
    }

   
   
}
