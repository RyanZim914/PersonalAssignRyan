<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<link rel="stylesheet" href="main.css" type="text/css"/>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Index</title>
</head>
<body>

    <nav>
        <a href="Public?action=getList">Order Now</a>
        <a href="./Register.jsp">Register</a>
        <a href="./Login.jsp">Login</a>
        
        <% if (session.getAttribute("loginedUser") != null) { %>
            <a href="Private?action=CreateItemPage">Create Item</a>
            <a href="Private?action=DeleteItemsPage">Delete Item</a>
            <a href="Private?action=NewIngredientPage">Create Ingredient</a>
            <a href="Private?action=CartPage">Cart</a>
        <% } %>
    </nav>

    <h1>List of things to DO:</h1>
    <h2>Be able to click a button to add an item to the cart</h2>
    <h2>Add sessions for the cart</h2>
    <h2>Add sessions for the user to log in</h2>
    ${tests}

</body>
</html>
