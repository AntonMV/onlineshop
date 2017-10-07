<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<hr>
<div class="tab-pane fade active in" id="detail">
    <table class="table table-th-block">
        <tbody>
        <tr><td class="active">Имя</td><td>${objUser.contact.name}</td></tr>
        <tr><td class="active">Email:</td><td>${objUser.email}</td></tr>
        <tr><td class="active">Зарегистрирован:</td><td>${objUser.registered}</td></tr>
        <tr><td class="active">День рождения:</td><td>${objUser.contact.birthday}</td></tr>
        <tr><td class="active">Телефон:</td><td>${objUser.contact.phone}</td></tr>
        <tr><td class="active">Адрес:</td><td>${objUser.contact.address}</td></tr>
        </tbody>
    </table>
</div>