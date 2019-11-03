/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.soen387.repository.core.repositoryCore;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Add Update Book</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet addUpdateBook at " + request.getContextPath() + "</h1>");
//            
////            out.println(" ");
//            out.println("<form action=\"${pageContext.request.contextPath}/myservlet\" method=\"post\"> ");
//            out.println("<input type=\"submit\" name=\"addBtn\" value=\"addBtn\" /> ");
//            out.println("<input type=\"submit\" name=\"button2\" value=\"Button 2\" /> ");   
//            out.println("</form> ");
//                  
//            
//            out.println("</body>");
//            out.println("</html>");
            
//                
//            <form action="${pageContext.request.contextPath}/myservlet" method="post">
//    <input type="submit" name="button1" value="Button 1" />
//    <input type="submit" name="button2" value="Button 2" />
//    <input type="submit" name="button3" value="Button 3" />
//</form>
        } finally {
            out.close();
        }
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        repositoryCore repo = new repositoryCore();
        
          response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        if (request.getParameter("addBtn") != null) {
            repo.updateBookInfo(1, "hi");
            out.println("updated book");
        }
        else if(request.getParameter("showBtn") !=null){
            int t = repo.getBookInfo(1);
            out.println("show");
            out.println(t);
        }
        
       
        
        
        out.println("book added sucessfully.");
        
        
//           out.println("Error, the book was not added.");
        
//            else if (request.getParameter("button2") != null) {
//            myClass.method2();
//        } else if (request.getParameter("button3") != null) {
//            myClass.method3();
//        } else {
//            // ???
//        }

//        request.getRequestDispatcher("/WEB-INF/some-result.jsp").forward(request, response);
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
