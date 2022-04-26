<%-- 
    Document   : index
    Created on : Apr 22, 2022, 3:01:07 PM
    Author     : Dell
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>
    </head>
    <body>
        
        <h1>Access Denied! You are not authorized for this Page!</h1>
        
        <hr>
        
        <form:form action="${pageContext.request.contextPath}/" method="POST" >
            <input type="submit" value="Logout">
        </form:form>   
    </body>
</html>
