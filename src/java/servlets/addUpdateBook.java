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
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            
          response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String isbn = request.getParameter("isbn");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String publisher = request.getParameter("publisher");
        String cover = request.getParameter("cover");
           
        repositoryCore repo = new repositoryCore();
        
//         public Book(String isbn, String title, String description, String firstName, String lastName){
////         isbn = this.id;
//        Author a = new Author(firstName, lastName);
//        title = this.title;
//        description = this.description;
//    }
        Author a1 = new Author(firstName, lastName);
        Book b1 = new Book(isbn, title, description, a1);
        
        if(!"".equals(isbn) && !"".equals(title) && !"".equals(description) ){
            if (request.getParameter("addBtn") != null) {
                  try {
                      repo.addNewBook(b1);
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
//           out.println("Error, the book was not added.");
        
//            else if (request.getParameter("button2") != null) {
//            myClass.method2();
//        } else if (request.getParameter("button3") != null) {
//            myClass.method3();
//        } else {
//            // ???
//        }

//        request.getRequestDispatcher("/WEB-INF/some-result.jsp").forward(request, response);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(addUpdateBook.class.getName()).log(Level.SEVERE, null, ex);
//        }
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
