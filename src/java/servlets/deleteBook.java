/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.soen387.repository.core.repositoryCore;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vicke
 */
@WebServlet(name = "deleteBook", urlPatterns = {"/deleteBook"})
public class deleteBook extends HttpServlet {

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
            out.println("<title>Servlet deleteBook</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet deleteBook at " + request.getContextPath() + "</h1>");
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
        
//        processRequest(request, response);
    
    repositoryCore repo = repositoryCore.getInstance();

    
      if (request.getParameter("deleteBtn") != null) {
        try {
            int id = 0;
            String ids = request.getParameter("hdnbt");
            id = Integer.parseInt(ids);	
            repo.deleteBook(id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(deleteBook.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
   
      if (request.getParameter("deleteAllBtn") != null) {
        try {
            repo.deleteAllBooks();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(deleteBook.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
        
        response.sendRedirect(response.encodeRedirectURL("http://localhost:8080/SOEN387A2/"));

    
    }

}
