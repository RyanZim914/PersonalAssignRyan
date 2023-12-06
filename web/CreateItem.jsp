<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <a href="./index.jsp">Home</a> 
    <a href="Private?action=NewIngredientPage">Create ing</a>
    
    <table  border="1">
        <thead>
            <tr>
                <th>Name</th>
                <th>Price</th>
                <th>Add To Item</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="ing" items="${ingredients}">
                <tr>
                    <td>${ing.value.name}</td>
                    <td>$${ing.value.price}</td>
                    <td>
                        <form method="POST" action="Private">
                            <input type="hidden" value="${ing.key}" name="ingID">
                            <input type="hidden" value="${newItemName}" name="newItemName">
                            <input type="hidden" value="AddIngToItem" name="action">
                            <input type="submit" value="Add Ingredient">
                       </form>

                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <br />
    <form method="POST" action="Private">
        <label>Name:</label>
        <input type="text" name="newItemName" value="${newItemName}" required>
        <input type="hidden" value="CreateNewItem" name="action">
        <input type="submit" value="Create">
    </form>
        <form method="Post" action="Private">
            <input type="hidden" value="ResetIngredients" name="action">
            <input type="submit" value="Reset">
        </form>
    
    ${itemDescription}
    <h3>Total: ${total}</h3>

    <!-- Add appropriate input fields or buttons for removing ingredients in the "Current Item" section -->
</body>
</html>
