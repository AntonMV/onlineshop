<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<table id="prod" class="table table-striped table-bordered" cellspacing="0" width="100%">
    <thead>
    <tr>
        <th>ID</th>
        <th>productId</th>
        <th>quantity</th>
        <th>purdate</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <c:if test="${!empty allOrder}">
        <c:forEach var="order" items="${allOrder}">
            <tr style="text-align: center;">
                <td>${order.id}</td>
                <td>${order.productId}</td>
                <td>${order.quantity}</td>
                <td>${order.purdate}</td>
                <td><a href="adminpanel"><span style="font-size: 15px; line-height: 0.8;" class="glyphicon glyphicon-pencil"/></a></td>
                <td><a href="adminpanel"><span style="font-size: 15px; line-height: 0.8;" class="glyphicon glyphicon-remove"/></a></td>
            </tr>
        </c:forEach>
    </c:if>
</table>