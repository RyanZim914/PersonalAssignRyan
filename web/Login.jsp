<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
</head>
<body>
    
    <a href="./index.jsp">Home</a> 
    <a href="./Register.jsp">Register</a>
    <br>
    
    <%-- Check if the user is logged in --%>
    <% if (session.getAttribute("loginedUser") != null) { %>
        <%-- Display a form with a signout button --%>
        <form action="Public" method="post">
            <input type="hidden" name="action" value="logout">
            <input type="submit" value="Sign Out">
        </form>
    <% } else { %>
        <%-- Display the login form --%>
        ${errorMessage}
        <form action="Public" method="post">
            <input type="hidden" name="action" value="login">
            <label for="email">UserName:</label>
            <input type="text" name="username">

            <label for="password">Password:</label>
            <input type="password" name="password">

            <input type="submit" value="Login">
        </form>
    <% } %>
</body>
</html>
