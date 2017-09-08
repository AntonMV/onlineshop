<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Product</title>
    <link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
    <script type="text/javascript" src="webjars/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js" defer></script>
</head>
<body>
    <h1>Product Details ${Hello}</h1>


    <table class="table table-striped">
        <tr>
            <th width="80">ID</th>
            <th width="120">Description</th>
            <th width="120">Name</th>
            <th width="120">Price</th>
            <th width="120">Quantity</th>
        </tr>
        <c:if test="${!empty allProduct}">
        <c:forEach var="product" items="${allProduct}">
            <tr>
                <td>${product.id}</td>
                <td>${product.description}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.quantity}</td>
            </tr>
        </c:forEach>
        </c:if>
    </table>
</body>
</html>