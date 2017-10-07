<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

    <h1>Order Details</h1>


    <table class="table table-striped">
        <tr>
            <th width="80">ID</th>
            <th width="120">productId</th>
            <th width="120">quantity</th>
            <th width="120">purdate</th>
        </tr>
        <c:forEach var="order" items="${myOrder}">
            <tr>
                <td>${order.id}</td>
                <td>${order.productId}</td>
                <td>${order.quantity}</td>
                <td>${order.purdate}</td>
            </tr>
        </c:forEach>
    </table>
