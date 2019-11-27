
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
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
        <link href="css/index.css" rel="stylesheet" type="text/css" />
        <title>index</title>
    </head>
    <body>
        <h1>SOEN 387 - Book Repository</h1>
           <a href="logout.jsp" >Logout</a>
        <div class="home">
             <h3>Homepage</h3>
            
             <a href="addUpdateBook.jsp" > Add/Update Book</a>
             
             <a href="getBookPage.jsp" >Search Book</a>
             <!-- Trigger/Open The Modal -->
            <button id="myBtn">Delete all books</button>

            
             <!-- The Modal -->
            <div id="myModal" class="modal">

              <!-- Delete all Modal content -->
              <div class="modal-content">
             
                <p>Are you sure you want to delete all books?</p>
                <div class="btnContainer">   
                    <form action="${pageContext.request.contextPath}/deleteBook" method="POST">
                     <span><input type="submit" class="succeed" name="deleteAllBtn" value="delete All Book"> </span>
                    </form>
                    <button class="close">Cancel</button>
                </div>
              </div>
            </div>
                
<!--             The Modal 
            <div id="myModal" class="modal">

               Delete  Modal content 
              <div class="modal-content">
                <p>Are you sure you want to delete?</p>
                <div class="btnContainer">   
                    <form action="${pageContext.request.contextPath}/deleteBook" method="POST">
                     <span><input type="submit" class="succeed" name="deleteAllBtn" value="delete All Book"> </span>
                    </form>
                    <button class="close">Cancel</button>
                </div>
              </div>
            </div>       -->
                     

             
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
           
            <tr bgcolor="#E0FFFF">

            
            <% 
                repositoryCore repo = repositoryCore.getInstance();
                HashMap<Integer,ArrayList<String>> list = repo.listAllBooks();
                
                  for (HashMap.Entry<Integer, ArrayList<String>> entry : list.entrySet() ) {
                    
                    int key = entry.getKey();
                    
                    
                   ArrayList<String> row = entry.getValue();
                   String title = row.get(0);
                   String isbn = row.get(1);
                   String description = row.get(2);
                   String firstName = row.get(3);
                   String lastName = row.get(4);
                   String company = row.get(5);
                   String address = row.get(6);
                   
                 %>
                 
                 <tr>
                 <td>
                     <img width="250" src="imageServlet?id=<%=key %>"  />
                     <form enctype="multipart/form-data"  action="uploadCoverImage" method="POST">
                     <input type="hidden" name="hdnbt" value="<%=key %>" />    
                     <input type="file" name="photo"  />    
                     <input type="submit" name="uploadBtn" value="Upload Cover" />
                        </form>
                 </td>
                 
                 <td><%=title %></td>
                <td> <%=isbn %> </td>
                <td> <%=description%> </td>
                <td> <%=firstName %></td>
                <td> <%=lastName %></td>
                <td> <%=company%> </td>
                <td> <%=address%> </td>
                 
           <div>
               
               <td>
            <form action="viewBookDetails"  />    
                  <input type="hidden" name="id" value="<%=key %>" />
                   <input type="hidden" name="view" value="true" />
               
                      <input type="submit" value="View Cover">
                
            </form>
                  
            <form action="viewBookDetails" />    
                <input type="hidden" name="id" value="<%=key %>" />
                <input type="hidden" name="view" value="false" />
                
                    <input type="submit"  value="View details">
                
            </form>
                
            </td>
               
            <form action="deleteBook" method="Post" />    
                  <input type="hidden" name="hdnbt" value="<%=key %>" />
                  <td>
                      <input type="submit" name="deleteBtn" value="delete">
                  </td>
            </form>
                
           </div>
            </tr>
           
              <%   
                 }
            %>
              
            </tr>
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
