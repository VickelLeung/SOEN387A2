<%-- 
    Document   : index
    Created on : 29-Oct-2019, 1:42:19 PM
    Author     : Vickel
--%>

<%@page import="com.soen387.repository.core.repositoryCore"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/login.css" rel="stylesheet" type="text/css" />
        <title>index</title>
    </head>
    <body>
        <h1>SOEN 387 - Book Repository</h1>
          
        <div id="loginContainer">
             <h3>Homepage</h3>
            
             <a href="addUpdateBook.jsp" > Add/Update Book</a>
             <a href="deleteBook.jsp" >Delete Book</a>
             <a href="getBook.jsp" >Search Book</a>
             <a href="logout.jsp" >Logout</a>
             
              <h2 align="center"><font><strong>Retrieve data from database in book</strong></font></h2>
            <table align="center" cellpadding="5" cellspacing="5" border="1">
            <tr>

            </tr>
            <tr bgcolor="#87CEFA">
            <td><b>title</b></td>
            <td><b>ISBN</b></td>
            <td><b>Description</b></td>
            <td><b>First Name</b></td>
             <td><b>Last Name</b></td>
            <td><b>Publisher</b></td>
            </tr>
            <%
                 repositoryCore repo = new repositoryCore();
                String display = repo.listAllBooks();
            %>
            <tr bgcolor="#E0FFFF">

            <td><%= display %></td>
 
            </tr>
           
            </table>             
        </div>
                 
    </body>
</html>
