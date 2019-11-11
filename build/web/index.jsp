<%-- 
    Document   : index
    Created on : 29-Oct-2019, 1:42:19 PM
    Author     : Vickel
--%>

<%@page import="com.soen387.repository.core.repositoryCore"%>
<%@page import="com.soen387.repository.core.Session"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
if (session.getAttribute("user") == null) {
    response.sendRedirect("/SOEN387A2/login.jsp");
}
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/index.css" rel="stylesheet" type="text/css" />
        <title>index</title>
    </head>
    <body>
        <h1>SOEN 387 - Book Repository</h1>
           <a href="logout.jsp" >Logout</a>
        <h2>Hello: <%= session.getAttribute("user") %></h2>
        <div class="home">
             <h3>Homepage</h3>
            
             <a href="addUpdateBook.jsp" > Add/Update Book</a>
             
             <a href="getBookPage.jsp" >Search Book</a>
             <!-- Trigger/Open The Modal -->
            <button id="myBtn">Delete all books</button>

            
             <!-- The Modal -->
            <div id="myModal" class="modal">

              <!-- Modal content -->
              <div class="modal-content">
                <!--<span >&times;</span>-->
                <p>Are you sure you want to delete all books?</p>
                <div class="btnContainer">
                    
                        <form action="${pageContext.request.contextPath}/deleteBook" method="POST">
                         <span><input type="submit" class="succeed" name="deleteAllBtn" value="delete All Book"> </span>
                        </form>
                    <button class="close">Cancel</button>
                </div>
              </div>
            </div>

             
              <h2 align="center"><font><strong>Retrieve data from database in book</strong></font></h2>
            <table align="center" cellpadding="5" cellspacing="5" border="1">
            <tr>

            </tr>
            <tr bgcolor="#87CEFA">
            <td><b>Cover</b></td>
            <td><b>Title</b></td>
            <td><b>ISBN</b></td>
            <td><b>Description</b></td>
             <td><b>First Name</b></td>
            <td><b>Last Name</b></td>          
            <td><b>Publisher Company</b></td>
            <td><b>Publisher address</b></td>
            </tr>
            <%
                 repositoryCore repo = repositoryCore.getInstance();
                String display = repo.listAllBooks();
            %>
            <tr bgcolor="#E0FFFF">
            
            <%= display %>
                
            </tr>

            </table>             
        </div>
<script>
    // Get the modal
    var modal = document.getElementById("myModal");

    // Get the button that opens the modal
    var btn = document.getElementById("myBtn");

    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];

    // When the user clicks the button, open the modal 
    btn.onclick = function() {
    modal.style.display = "block";
    }

    // When the user clicks on <span> (x), close the modal
    span.onclick = function() {
    modal.style.display = "none";
    }

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
    if (event.target == modal) {
    modal.style.display = "none";
    }
    }
</script>      
    </body>
    
</html>
