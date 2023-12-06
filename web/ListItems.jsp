<%-- 
    Document   : ListItems
    Created on : Oct 26, 2023, 11:10:09 PM
    Author     : ryanz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View All Items</title>
    </head>
    <body>
        <a href="./index.jsp">Home</a>   
        <a href="Private?action=CartPage">Cart</a>
        <h1>List Of Items</h1>
    <c:forEach var="item" items="${list}">
        <h1>${item.value.name}</h1>
            ${item.value.ingString()}
            <form action="Private" method="Post">
                <input type="hidden" name="action" value="AddToCart">
                <input type="hidden" name="ItemID" value="${item.value.itemID}">
                <input type="submit" value="Add to Cart">
            </form>    
    </c:forEach>

    </body>
</html>
