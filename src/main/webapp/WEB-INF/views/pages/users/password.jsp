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
        <label for="oldPassword" class="control-label">Введите старый пароль</label>
        <input id="oldPassword" name="oldPassword" type="password" data-toggle="validator" class="form-control" placeholder="Enter you password">
        <div class="help-block with-errors">
            <span class="error"><form:errors path="password" /></span>
        </div>
    </div>
    <div class="form-group">
        <label for="changePassword" class="control-label">Введите новый пароль</label>
        <input id="changePassword" name="password" type="password" data-toggle="validator" data-minlength="8" data-minlength-error="Мин. длинна 8 символов" class="form-control" placeholder="Enter you password">
    </div>
    <div class="form-group">
        <input type="password" class="form-control" id="inputPasswordConfirm" data-match="#changePassword" data-match-error="Ошибка! Пароли не совпадают!" placeholder="Повторите пароль">
        <div class="help-block with-errors"></div>
    </div>
    <div class="form-group">
        <hr>
        <button type="submit" class="btn btn-success">Отправить</button>
    </div>
</form:form>
