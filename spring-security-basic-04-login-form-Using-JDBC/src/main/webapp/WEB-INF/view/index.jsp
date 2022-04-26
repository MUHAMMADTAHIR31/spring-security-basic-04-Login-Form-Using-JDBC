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
        
        <h1>Welcome! Login Page !</h1>
        <hr>
        
        <p>
            User: <security:authentication property="principal.username"/>
            <br><br>
            Role(s): <security:authentication property="principal.authorities"/>
        </p>  
        
        <security:authorize access="hasRole('ADMIN')">
            <!--Add a link to point to /leaders --- this is for Manager-->
            <p>
                <a href="${pageContext.request.contextPath}/systems">IT System Meeting</a>
                (only for Admin peeps)
            </p>
        </security:authorize>     
                
        <security:authorize access="hasRole('MANAGER')">
            <!--Add a link to point to /leaders --- this is for Manager-->
            <p>
                <a href="${pageContext.request.contextPath}/leaders">Leader Meeting</a>
                (only for Manager peeps)
            </p>
        </security:authorize>
                
        <form:form action="${pageContext.request.contextPath}/logout" method="POST" >
            <input type="submit" value="Logout">
        </form:form>   
    </body>
</html>
