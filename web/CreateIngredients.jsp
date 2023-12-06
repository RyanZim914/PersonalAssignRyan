<%-- 
    Document   : CreateIngredients
    Created on : Dec 4, 2023, 11:57:48 PM
    Author     : ryanz
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="./index.jsp">Home</a> 
        <a href="Private?action=CreateItemPage">Create Item</a>
       <h1>Add a New Ingredient</h1>
    <form action="Private" method="POST">
        <input type="hidden" name="action" value="addIngredient" />
        <label>Name:</label>
        <input type="text" name="ingName" required/>
        <br/>
        <label>Price:</label>
        <input type="text" name="ingPrice" required/>
        <input type="submit" value="Add Ingredient">
    </form>
    <br />
<table  border="1">
    <thead>
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Remove</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="ing" items="${ingredients}">
            <tr>
                <td>${ing.value.name}</td>
                <td>$${ing.value.price}</td>
                <td>
                    <form method="POST" action="Private">
                        <input type="hidden" value="${ing.key}" name="currIngID">
                        <input type="hidden" value="RemoveIngredient" name="action">
                        <input type="submit" value="Remove Ingredient">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

    </body>
</html>
