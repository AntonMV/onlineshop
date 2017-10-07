<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form:form method="POST" modelAttribute="objUser" data-toggle="validator" role="form">
        <div class="form-group">
            <form:input path="id" type = "hidden"/>
        </div>
        <div class="form-group">
            <form:input path="contact.id" type = "hidden"/>
        </div>
        <div class="form-group">
            <label for="inputName" class="control-label">Ваше имя</label>
            <form:input  id="inputName" path="contact.name" type="text" class="form-control rounded" placeholder="Ваше имя"></form:input>
            <div class="help-block with-errors">
                <span class="error"><form:errors path="contact.name" /></span>
            </div>
        </div>
        <div class="form-group">
            <label for="inputBirthday" class="control-label">День рождения</label>
            <form:input id="inputBirthday" data-date-format="DD.MM.YYYY" path="contact.birthday" value="${objUser.contact.birthday}" type="Date" class="form-control rounded" placeholder="Ваш день рождения"></form:input>
            <div class="help-block with-errors">
                <span class="error"><form:errors path="contact.birthday" /></span>
            </div>
        </div>
        <div class="form-group">
            <label for="inputPhone" class="control-label">Ваш телефон</label>
            <form:input id="inputPhone" path="contact.phone" type="text" class="form-control rounded" placeholder="+7-900-123-45-67"></form:input>
            <div class="help-block with-errors">
                <span class="error"><form:errors path="contact.phone" /></span>
            </div>
        </div>
        <div class="form-group">
            <label for="inputAddress" class="control-label">Ваш адрес</label>
            <form:input id="inputAddress" path="contact.address" type="text" class="form-control rounded" placeholder="Ваш адрес"></form:input>
            <div class="help-block with-errors">
                <span class="error"><form:errors path="contact.address" /></span>
            </div>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-success" data-original-title="" title="">Сохранить</button>
        </div>
</form:form>