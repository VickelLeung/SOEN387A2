<%-- 
    Document   : getBookPage
    Created on : 7-Nov-2019, 4:52:25 PM
    Author     : Vicke
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <h1>Get a book in the repository</h1>
        
        <div></div>
        <p>Get book by id</p>
       
            <span>Please enter an id to find the book. </span>
           <form action="${pageContext.request.contextPath}/findBook" method="POST">
              <input type="text" name="idBtn"/>
              <input type="submit" value="Submit">
           </form>
        <div>
            <p>Get book by ISBN</p>
            <span>Please enter an ISBN to find the book. </span>
             <form action="${pageContext.request.contextPath}/findBook" method="POST">
                <input type="text" name="isbnBtn"/>
                <input type="submit" value="Submit">
             </form>
        </div>
        
    </body>
</html>
