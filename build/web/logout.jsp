<%-- 
    Document   : logout
    Created on : Nov. 11, 2019, 12:11:08 a.m.
    Author     : zheng
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% session.invalidate(); %>
<% response.sendRedirect("/SOEN387A2/login.jsp"); %>
