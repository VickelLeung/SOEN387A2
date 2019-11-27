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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class viewBookDetails extends HttpServlet {
    
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
         PrintWriter out = response.getWriter();
        
        
//          String getId =  request.getParameter("id");
      
        HashMap bookInfo = new HashMap();
        repositoryCore repo = repositoryCore.getInstance();
        
         
                try {
//                    id = Integer.parseInt(getId);
                    int id = Integer.parseInt(request.getParameter("id"));
                    bookInfo = repo.getBookInfo(id);
                } catch (SQLException ex) {
                    Logger.getLogger(findBook.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(findBook.class.getName()).log(Level.SEVERE, null, ex);
                }

          String cover = bookInfo.get(1).toString();
          String title = bookInfo.get(2).toString();
          String ISBN = bookInfo.get(3).toString();
          String description =  bookInfo.get(4).toString();
          String firstName = bookInfo.get(5).toString();
          String lastName =  bookInfo.get(6).toString();
          String company = bookInfo.get(7).toString();
          String address = bookInfo.get(8).toString();
           

           if(request.getParameter("view").equals("true")){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link href=\"css/viewDetail.css\" rel=\"stylesheet\" type=\"text/css\" />");
            out.println("<title>Servlet viewBookDetails</title>");            
            out.println("</head>");
            
            
            out.println("<body>");
            
            out.println("<div class=container>");
            out.println("<h1>"+ title +"</h1>");
            out.println("<h2>"+ firstName + " " + lastName +"</h2>");
            out.write("<td><img width=\"250px\" height=\"300px\" src=\"imageServlet?id=" + request.getParameter("id") + "\" /> </td>");
            out.println("<h4>"+ company +"</h4>");
            out.println("<h4>"+ address +"</h4>");
            out.println("<h4>"+ ISBN +"</h4>");
            out.println("</div>");
            
            out.println("</body>");
            out.println("</html>");
            }
            else if(request.getParameter("view").equals("false")){
                 out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link href=\"css/viewDetail.css\" rel=\"stylesheet\" type=\"text/css\" />");
            out.println("<title>Servlet viewBookDetails</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.write("<div class=container>");
            out.write("<table align=\"center\" border=\"1\">");
            out.write("<tr>");
            out.write("<td><b>Title</b></td>");
            out.write("<td><b>ISBN</b></td>");
            out.write("<td><b>Description</b></td>");
            out.write("<td><b>First Name</b></td>"); 
            out.write("<td><b>Last Name</b></td>"); 
            out.write("<td><b>Publisher Company</b></td>");
            out.write("<td><b>Publisher address</b></td>");
            out.write("<tr>");
            
            out.write("<tr>");
            out.write("<td>" + title + "</td>");
            out.write("<td>" + ISBN + "</td>");
            out.write("<td>" + description + "</td>");
            out.write("<td>" + firstName + "</td>");
            out.write("<td>" + lastName + "</td>");
            out.write("<td>" + company + "</td>");
            out.write("<td>" + address + "</td>");
            out.write("</tr>");
            out.write("</table>");
            out.write("<a class=link href=addUpdateBook.jsp>Click to edit book </a>");
            out.write("<div>");
            
            out.println("</body>");
            out.println("</html>");
            }
               
          
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
       
                     
        }
        
}


