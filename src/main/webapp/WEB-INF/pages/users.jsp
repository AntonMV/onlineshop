<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>


<!-- Site headtag -->
<jsp:include page="frame/headtag.jsp"/>
<body>
<div class="container">
    <!-- Site header -->
    <jsp:include page="frame/header.jsp"/>

    <h1>Users</h1>

    <c:forEach var="user" items="${allUsers}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.registered}</td>
        </tr>
    </c:forEach>

    <!-- Site footer -->
    <jsp:include page="frame/footer.jsp"/>

</div>
</body>
</html>
