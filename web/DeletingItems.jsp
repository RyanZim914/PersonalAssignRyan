<%-- 
    Document   : DeletingItems
    Created on : Dec 5, 2023, 2:49:16 AM
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
        <table border="1">
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Remove</th>
        </tr>
    </thead>
    <tbody>      
        <c:forEach var="item" items="${list}">
            <tr>
                <td>${item.key}</td>
                <td>${item.value.name}</td>
                <td>
                    <form method="Post" action="Private">
                        <input type="hidden" name="action" value="DeleteItemFromDatabase">
                        <input type="hidden" name="ItemID" value="${item.key}">
                        <input type="submit" value="Remove">
                    </form>
                </td>
            </tr>    
        </c:forEach>
    </tbody>
</table>

    </body>
</html>
