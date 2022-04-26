<%-- 
    Document   : plain-login
    Created on : Apr 22, 2022, 2:50:32 PM
    Author     : Dell
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Custom Login Form</title>
        
        <style>
            .failed{
                color: red;
            }
        </style>
    </head>
    
    <body>
        <h3>My Custom Login Page</h3>
        
        <form:form action="${pageContext.request.contextPath}/authenthicateTheUser" method="POST">
            
            <!--Check The Error-->
            <c:if test="${param.error !=null}">
                <i class="failed"> Sorry! You entered invalid username/password</i>
            </c:if>
                
            <p>
                User Name: <input type="text" name="username" />
            </p>
            
            <p>
                User Password: <input type="password" name="password" />
            </p>
            
            <input type="submit" value="Login" />
        </form:form>
        
    </body>
</html>
