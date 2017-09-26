<html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- Site headtag -->
<jsp:include page="frame/headtag.jsp"/>
<body>
<div class="container">
    <!-- Site header -->
    <jsp:include page="frame/header.jsp"/>

    <div id="main">
        <div class="row" id="real-estates-detail">
            <div class="col-lg-4 col-md-4 col-xs-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <header class="panel-title">
                            <div class="text-center">
                                <strong>
                                Пользователь
                                </strong>
                            </div>
                        </header>
                    </div>
                    <div class="panel-body">
                        <div class="text-center" id="author">
                            <img src="resources/img/myprofile.jpg">
                            <h3>${objUser.name}</h3>
                            <small class="label label-warning">Российская Федерация</small>
                            <p class="sosmed-author">
                                <a href="#"><i class="fa fa-facebook" title="Facebook"></i></a>
                                <a href="#"><i class="fa fa-twitter" title="Twitter"></i></a>
                                <a href="#"><i class="fa fa-google-plus" title="Google Plus"></i></a>
                                <a href="#"><i class="fa fa-linkedin" title="Linkedin"></i></a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-8 col-md-8 col-xs-12">
                <div class="panel">
                    <div class="panel-body">
                        <h4>Данные пользователя</h4>
                        <div id="myTabContent" class="tab-content">
                            <ul id="myTab" class="nav nav-pills">
                                <li class="active"><a href="#detail" data-toggle="tab">О пользователе</a></li>
                                <li class=""><a href="#contact" data-toggle="tab">Редактировать</a></li>
                            </ul>
                            <hr>
                            <div class="tab-pane fade active in" id="detail">
                                <table class="table table-th-block">
                                    <tbody>
                                    <tr><td class="active">Имя</td><td>${objUser.name}</td></tr>
                                    <tr><td class="active">Email:</td><td>${objUser.email}</td></tr>
                                    <tr><td class="active">Зарегистрирован:</td><td>${objUser.registered}</td></tr>
                                    <tr><td class="active">День рождения:</td><td>${objUser.birthday}</td></tr>
                                    <tr><td class="active">Телефон:</td><td>${objUser.phone}</td></tr>
                                    <tr><td class="active">Адрес:</td><td>${objUser.address}</td></tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="tab-pane fade" id="contact">
                                <p></p>
                                <form:form method="POST" modelAttribute="objUser" data-toggle="validator" role="form">
                                    <spring:bind path="id">
                                        <div class="form-group">
                                            <form:input  id="inputName" path="id" type = "hidden"></form:input>
                                        </div>
                                    </spring:bind>
                                    <spring:bind path="name">
                                        <div class="form-group">
                                            <label for="inputName" class="control-label">Ваше имя</label>
                                            <form:input  id="inputName" path="name" type="text" class="form-control rounded" placeholder="Ваше имя"></form:input>
                                            <div class="help-block with-errors">
                                                <span class="error"><form:errors path="name" /></span>
                                            </div>
                                        </div>
                                    </spring:bind>
                                    <spring:bind path="birthday">
                                        <div class="form-group">
                                            <label for="inputBirthday" class="control-label">День рождения</label>
                                            <form:input id="inputBirthday" data-date-format="DD.MM.YYYY" path="birthday" value="${objUser.birthday}" type="Date" class="form-control rounded" placeholder="Ваш день рождения"></form:input>
                                            <div class="help-block with-errors">
                                                <span class="error"><form:errors path="birthday" /></span>
                                            </div>
                                        </div>
                                    </spring:bind>
                                    <spring:bind path="phone">
                                        <div class="form-group">
                                            <label for="inputPhone" class="control-label">Ваш телефон</label>
                                            <form:input id="inputPhone" path="phone" type="text" class="form-control rounded" placeholder="+7-900-123-45-67"></form:input>
                                            <div class="help-block with-errors">
                                                <span class="error"><form:errors path="phone" /></span>
                                            </div>
                                        </div>
                                    </spring:bind>
                                    <spring:bind path="address">
                                        <div class="form-group">
                                            <label for="inputAddress" class="control-label">Ваш адрес</label>
                                            <form:input id="inputAddress" path="address" type="text" class="form-control rounded" placeholder="Ваш адрес"></form:input>
                                            <div class="help-block with-errors">
                                                <span class="error"><form:errors path="address" /></span>
                                            </div>
                                        </div>
                                    </spring:bind>
                                    <div class="form-group">
                                        <button type="submit" class="btn btn-success" data-original-title="" title="">Сохранить</button>
                                    </div>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Site footer -->
    <jsp:include page="frame/footer.jsp"/>

</div>
</div>
</body>
</html>