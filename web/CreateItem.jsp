<%-- 
    Document   : CreateItem
    Created on : Nov 8, 2023, 7:58:26 PM
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
        <table>
            <tr>
                <thead>
                    <th>Name</th>
                    <th>Price</th>
                    <th /> 
                </thead>
            </tr>

            <tbody>
    <c:forEach var="ing" items="${ingredients}">
            <tr>
                <td>${ing.value.name}</td>
                <td>$${ing.value.price}</td>
                 <form method="POST" action="Public">
                     <input type="hidden" value="${ing.key}" name="ingID">
                     <input type="hidden" value="AddIngToItem" name="action">
                <td><input type="submit" Value="Add Ingredient"></td>
            </tr>
        </form>
    </c:forEach>
            </tbody>
        </table>
        <br />
            <form>
                <label>Name: </label>
                <input type="hidden" value="CreateItem" name="action">
                <input type="text" name="ItemName" required/>
                <input type="submit" Create>
            </form>
        <br/>
        <br/>
            ${itemDescription}<br/>
            ${total}
            <h1>Add a New Ingredient</h1>
           <form action="Public" method="POST">
               <input type="hidden" name="action" value="addIngredient" />
               <label>Name: </label>
               <input type="text" name="ingName" required/>
               <br/>
               <label>Price: </label>
               <input type="text" name="ingPrice" required/>
               
            <input type="submit">
        </form>
    </body>
</html>
