/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
@WebServlet(name = "imageServlet", urlPatterns = {"/imageServlet"})
public class imageServlet extends HttpServlet {

    
     private static final String user = "soen387a2";
     private static final String pw = "Lr00IQ5T~!Ma";
     private static final String dbURL = "jdbc:mysql://den1.mysql2.gear.host/soen387a2";
    
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
            out.println("<title>Servlet imageServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet imageServlet at " + request.getContextPath() + "</h1>");
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
        
        String getId = request.getParameter("id");
       
          Connection myCon = null;
        Statement myStm = null;
        ResultSet rs = null;
        
      try {
        Class.forName("com.mysql.jdbc.Driver");
        myCon = DriverManager.getConnection(dbURL, user, pw);
        myStm = myCon.createStatement();
        if(getId !=null){
        int id = Integer.parseInt(getId);
       
        String sql = "SELECT picture FROM book where id =" + id + ";";
        PreparedStatement statement = myCon.prepareStatement(sql); 
//       statement.execute();
        rs = statement.executeQuery(sql);
        
      if(rs.next()){
//          id = rs.getInt("id");
           Blob b = rs.getBlob("picture");
      
//      
        response.setContentType("image/jpeg");
        response.setContentLength((int) b.length());
        InputStream is = b.getBinaryStream();
        OutputStream os = response.getOutputStream();
        byte buf[] = new byte[(int) b.length()];
        is.read(buf);
        os.write(buf);
        os.close();
       }
        myStm.close();
    }
        } catch(SQLException e) {
        for (Throwable t : e)
        t.printStackTrace();
        } catch (ClassNotFoundException ex) {     
             Logger.getLogger(imageServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
