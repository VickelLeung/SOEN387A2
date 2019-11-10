/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.soen387.repository.core.Author;
import com.soen387.repository.core.Book;
import com.soen387.repository.core.repositoryCore;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
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
public class findBook extends HttpServlet {

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
            out.println("<title>Servlet findBook</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet findBook at " + request.getContextPath() + "</h1>");
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
      
          
        String id =  request.getParameter("idBtn");
        String isbn = request.getParameter("isbnBtn");
        
        int idNum = Integer.parseInt(id);
        
        HashMap bookInfo = new HashMap();
        repositoryCore repo = repositoryCore.getInstance();
        PrintWriter out = response.getWriter();
            if (request.getParameter("idBtn") != null) {
            try {
                bookInfo = repo.getBookId(idNum);
            } catch (SQLException ex) {
                Logger.getLogger(findBook.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(findBook.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            }
            else if(request.getParameter("isbnBtn") != null){
            try {
                bookInfo = repo.getBookInfo(isbn);
            } catch (SQLException ex) {
                Logger.getLogger(findBook.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(findBook.class.getName()).log(Level.SEVERE, null, ex);
            }
               
            }
            
          String cover = bookInfo.get(1).toString();
          String title = bookInfo.get(2).toString();
          String ISBN = bookInfo.get(3).toString();
          String description =  bookInfo.get(4).toString();
          String firstName = bookInfo.get(5).toString();
          String lastName =  bookInfo.get(6).toString();
          String company = bookInfo.get(7).toString();
          String address = bookInfo.get(8).toString();
           
//            display book information 
            
            out.write("<p><b>Here is the book you were trying to look for in our repository!</b></p>");
            out.write("<table align=\"center\" border=\"1\">");
            out.write("<tr>");
            out.write("<td><b>Cover</b></td>");
            out.write("<td><b>Title</b></td>");
            out.write("<td><b>ISBN</b></td>");
            out.write("<td><b>Description</b></td>");
            out.write("<td><b>First Name</b></td>"); 
            out.write("<td><b>Last Name</b></td>"); 
            out.write("<td><b>Publisher Company</b></td>");
            out.write("<td><b>Publisher address</b></td>");
            out.write("<tr>");
            
            out.write("<tr>");
//            out.write("<td>");
            
            out.write("<td>" + cover + "</td>");
            out.write("<td>" + title + "</td>");
            out.write("<td>" + ISBN + "</td>");
            out.write("<td>" + description + "</td>");
            out.write("<td>" + firstName + "</td>");
            out.write("<td>" + lastName + "</td>");
            out.write("<td>" + company + "</td>");
            out.write("<td>" + address + "</td>");
            
//            out.write("</td>");
            out.write("</tr>");
            out.write("</table>");
            
//              out.write("<p>" + title +"</p>");
//             out.write("<p>" + ISBN +"</p>");
//              out.write("<p>" + description +"</p>");
//          
        }
        
        

   

}
