<%-- 
    Document   : index
    Created on : 29-Oct-2019, 1:42:19 PM
    Author     : Vickel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/login.css" rel="stylesheet" type="text/css" />
        <title>Login page</title>
    </head>
    <body>
        <h1>SOEN 387 - Book Repository</h1>       
        <div id="loginContainer">
             <h3>Login</h3>
            <form method="POST" action="${pageContext.request.contextPath}/login">
                <div className="userInput">
                <p>Username: <input name="username" type="text"/> </p>
                </div>
                
                <divclassName="userInput">
                <p>Password: <input name="password" type="password"/> </p>
                </div>
                
                <div className="submitBtn">
                <input type="submit"/>
                </div>
            </form>
        </div>
        
    </body>
</html>
