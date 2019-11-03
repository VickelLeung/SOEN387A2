<%-- 
    Document   : addUpdateBook
    Created on : 2-Nov-2019, 6:33:08 PM
    Author     : Vicke
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>add/update Page</title>
    </head>
    <body>
        <h1>Add or Update your book!</h1>
        <form action="${pageContext.request.contextPath}/addUpdateBook" method="POST">
         
                <span>Title</span><input type="text" />
                <span>Description</span><input type="text" />       
                <span>ISBN</span><input type="text" />          
                <span>Author</span><input type="text" />           
                <span>Publisher</span><input type="text" />           
                <span>Cover</span><input type="text" />
            <input type="submit" name="addBtn" value="Add book" />
        </form>   
        
        <form action="${pageContext.request.contextPath}/addUpdateBook" method="POST">
          
            <input type="submit" name="showBtn" value="Show book" />
        </form>
    </body>
</html>
