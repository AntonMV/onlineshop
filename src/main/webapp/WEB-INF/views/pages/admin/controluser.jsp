<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<table id="prod" class="table table-striped table-bordered" cellspacing="0" width="100%">
    <thead>
    <tr>
        <th>ID</th>
        <th>Email</th>
        <th>Registered</th>
        <th>Enable</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <c:if test="${!empty allUsers}">
        <c:forEach var="user" items="${allUsers}">
            <tr style="text-align: center;">
                <td>${user.id}</td>
                <td>${user.email}</td>
                <td>${user.registered}</td>
                <td>${user.enable}</td>
                <td><a href="adminpanel"><span style="font-size: 15px; line-height: 0.8;" class="glyphicon glyphicon-pencil"/></a></td>
                <td><a href="adminpanel"><span style="font-size: 15px; line-height: 0.8;" class="glyphicon glyphicon-remove"/></a></td>
            </tr>
        </c:forEach>
    </c:if>
</table>
<div class="row" style="padding-left: 15px;">
    <hr>
    <button type="submit" class="btn btn-success">Добавить пользователя</button>
</div>