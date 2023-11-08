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
        <h1>Test</h1>
        <h1>Test2</h1>
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
            <input type="submit" value="Register">
        </form>
        <form action=Public method="POST">
            <input type="hidden" name="action" value="getList" />
            <input type="submit" value="Register">
        </form>
    </body>
</html>