<%-- 
    Document   : index
    Created on : Oct 26, 2023, 11:41:43 PM
    Author     : ryanz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <nav>
        <h1>List of things to DO:</h1>
        <h2>Add Database.</h2>
        <h2>Proliferate database with some basic data</h2>
        <h2>Add area to create Items</h2>
        <h2>Hash The User Passwords</h2>
        <h2>Figure how to css Nav</h2>
        <h2>Users should be able to change password, email.</h2>
        <h2>Add sessions for the cart</h2>
        
        
        
    </nav>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
        <form action=Public method="POST">
            <input type="hidden" name="action" value="registerForm" />
            <input type="submit" value="Register">
        </form>
        <form action=Public method="POST">
            <input type="hidden" name="action" value="loginForm" />
            <input type="submit" value="Login">
        </form>
        <form action=Public method="POST">
            <input type="hidden" name="action" value="getList" />
            <input type="submit" value="Buy Now">
        </form>
    </body>
</html>