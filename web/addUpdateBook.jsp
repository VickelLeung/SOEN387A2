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
         
                <span>Title</span><input name="title" type="text" />
                <span>Description</span><input name="description" type="text" />       
                <span>ISBN</span><input name="isbn" type="text" />   
                <p>Author</p>
                <span>First Name</span><input name="firstName" type="text" />         
                <span>Last Name</span><input name="lastName" type="text" />  
                <p>Publisher</p>
                <span>Publisher company</span><input name="company" type="text" />       
                <span>Publisher address</span><input name="address" type="text" />           
                <!--<span>Cover</span><input type="file" name="photo"/>-->
            <input type="submit" name="addBtn" value="Add book" />
            <input type="submit" name="updateBtn" value="Update book" />
        </form>   
<!--        
        <form action="${pageContext.request.contextPath}/addUpdateBook" method="POST">
          
            <input type="submit" name="updateBtn" value="Update book" />
        </form>-->
    </body>
</html>
