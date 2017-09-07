<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Order</title>
</head>
<body>
<c:forEach var="order" items="${myOrder}">
    <tr>
        <td>${order.id}</td>
        <td>${order.productId}</td>
        <td>${order.quantity}</td>
    </tr>
</c:forEach>
</body>
</html>
