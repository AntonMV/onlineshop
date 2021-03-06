<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>


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
