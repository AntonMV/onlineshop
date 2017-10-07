<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form:form method="POST" modelAttribute="objUser" data-toggle="validator" role="form" cssStyle="width: 50%">
    <div class="form-group">
        <form:input path="id" type = "hidden"/>
    </div>
    <div class="form-group">
        <form:input path="contact.id" type = "hidden"/>
    </div>
    <div class="form-group">
        <label for="oldEmail" class="control-label">Введите старый email</label>
        <input id="oldEmail" name="oldEmail" type="email" data-toggle="validator" class="form-control" placeholder="старый">
        <div class="help-block with-errors">
            <span class="error"><form:errors path="email" /></span>
        </div>
    </div>
    <div class="form-group">
        <label for="changeEmail" class="control-label">Введите новый email</label>
        <input id="changeEmail" name="email" type="email" data-toggle="validator" class="form-control" placeholder="новый">
    </div>
    <div class="form-group">
        <input type="email" class="form-control" id="inputEmailConfirm" data-match="#changeEmail" data-match-error="Ошибка! Адреса не совпадают!" placeholder="повторите email">
        <div class="help-block with-errors"></div>
    </div>
    <div class="form-group">
        <hr>
        <button type="submit" class="btn btn-success">Отправить</button>
    </div>
</form:form>