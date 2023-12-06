<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cart Page</title>
</head>
<body>
    <a href="Public?action=getList">Order Now</a>
    <a href="./index.jsp">Home</a> 
    <c:if test="${cartList.size() > 0}">
        <table border="1">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Total</th>
                    <th>Remove</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${cartList}" varStatus="status">
                    <tr>
                        <td>${item.name}</td>
                        <td>$${item.totalPrice}</td>
                        <td>
                            <form method="Post" action="Private">
                                <input type="hidden" name="action" value="RemoveFromCart">
                                <input type="hidden" name="ItemIndex" value="${status.index}">
                                <input type="submit" value="Remove">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        Your total is $${grandTotal}
        <form method="Post" action="Private">
            <input type="hidden" name="action" value="SubmitCart">
            <input type="submit" value="Pay Now">
        </form>
    </c:if>
    <c:if test="${empty cartList}">
        <p>Your cart is empty.</p>
    </c:if>

</body>
</html>
