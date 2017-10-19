<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>


<table id="prod" class="table table-striped table-bordered" cellspacing="0" width="100%">
    <thead>
    <tr>
        <th>ID</th>
        <th>Description</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
    </tr>
    </thead>
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