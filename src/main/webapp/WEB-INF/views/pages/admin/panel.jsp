<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<div id="toolbar" class="btn-group">
    <button type="button" class="btn btn-default">
        <i class="glyphicon glyphicon-plus"></i>
    </button>
    <button type="button" class="btn btn-default">
        <i class="glyphicon glyphicon-heart"></i>
    </button>
    <button type="button" class="btn btn-default">
        <i class="glyphicon glyphicon-trash"></i>
    </button>
</div>

<table class="table table-striped">
    <thead>
    <tr>
        <th>ID</th>
        <th>Description</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
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
    </thead>
</table>
