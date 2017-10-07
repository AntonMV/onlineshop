<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <img class="img-responsive" src="/resources/img/logo.svg" style="height: 60pt; margin: 20px; width: 100%"/>
        </div>
        <div class="col-md-4">
            <div style="margin-left: 145px; margin-top: 15px;">
                <!--Hello component-->
                <sec:authorize access= "hasAnyRole('ROLE_ADMIN' , 'ROLE_USER')" var= "isUser"/>
                <c:if test= "${not isUser}">
                    <c:if test= "${empty param.error}">
                        <p class="text-right"><spring:message code="label.welcome"/></p>
                    </c:if>
                </c:if>
                <c:if test= "${isUser}">
                    <p class="text-right"><spring:message code="label.logwelcome"/>
                        <sec:authentication property = "principal.username"/><spring:message code="label.logrole"/>
                        <b><sec:authentication property= "principal.authorities"/></b>
                    </p>
                </c:if>
            </div>
        </div>
    </div>
