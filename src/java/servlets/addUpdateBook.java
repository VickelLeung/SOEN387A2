/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.soen387.repository.core.Author;
import com.soen387.repository.core.Book;
import com.soen387.repository.core.CoverImage;
import com.soen387.repository.core.repositoryCore;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Vicke
 */
public class addUpdateBook extends HttpServlet {

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

        } finally {
            out.close();
        }
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
          response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String isbn = request.getParameter("isbn");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String publisherCompany = request.getParameter("company");
        String publisherAddress = request.getParameter("address");

        
        InputStream inputStream = null; // input stream of the upload file
         
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("photo");  
        System.out.print("file :  " +filePart);
        repositoryCore repo = repositoryCore.getInstance();
        
        Author a1 = new Author(firstName, lastName);
        Book b1 = new Book(isbn, title, description, a1, publisherCompany ,publisherAddress);
        
        if(!"".equals(isbn) && !"".equals(title) && !"".equals(description) ){
            if (request.getParameter("addBtn") != null) {
                  try {
                      repo.addNewBook(b1);
//                     repo.setImage(filePart, isbn);
                  } catch (ClassNotFoundException ex) {
                      Logger.getLogger(addUpdateBook.class.getName()).log(Level.SEVERE, null, ex);
                  }
                out.println("updated book");
            }
            else if(request.getParameter("updateBtn") != null){
                  try {
                      repo.updateBookInfo(1, b1);
                  } catch (ClassNotFoundException ex) {
                      Logger.getLogger(addUpdateBook.class.getName()).log(Level.SEVERE, null, ex);
                  }
                out.println("show");
            }
        }
            
        out.println("Sucessfully addeed to respository for book.\n");
        out.println("Title: " + title + "\nisbn: " + isbn + "\ndescription: " + description + " ");
            
       response.sendRedirect(response.encodeRedirectURL("http://localhost:8080/SOEN387A2/"));
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
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>

}
