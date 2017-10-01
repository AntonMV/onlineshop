<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!-- Site headtag -->
<jsp:include page="frame/headtag.jsp"/>
<body>
<div class="container">

    <!-- Site header -->
    <jsp:include page="frame/header.jsp"/>

    <!-- Form registartion -->
    <div class="row">
        <div class="col-md-6 col-md-offset-3">

            <form:form method="POST" modelAttribute="userForm" data-toggle="validator" role="form">
                <spring:bind path="email">
                <div class="form-group">
                    <label for="inputEmail" class="control-label">Ваш E-mail</label>
                    <form:input path="email" type="email" class="form-control" id="inputEmail" placeholder="Email" data-error="Вы не правильно ввели Ваш E-mail"></form:input>
                    <div class="help-block with-errors">
                        <span class="error"><form:errors path="email" /></span>
                    </div>
                </div>
                </spring:bind>
                <div class="form-group">
                    <label for="inputPassword" class="control-label">Введите пароль</label>
                    <div class="form-inline row">
                        <spring:bind path="password">
                        <div class="form-group col-sm-6">
                            <form:input path="password" type="password" data-toggle="validator" data-minlength="8" class="form-control" id="inputPassword" placeholder="Enter you password"></form:input>
                            <div class="help-block with-errors">
                                <span class="error"><form:errors path="password" /></span>
                            </div>
                            <span class="help-block">Минимум 8 значений</span>
                        </div>
                        </spring:bind>
                        <div class="form-group col-sm-6">
                            <input type="password" class="form-control" id="inputPasswordConfirm" data-match="#inputPassword" data-match-error="Ошибка! Пароли не совпадают!" placeholder="Повторите пароль">
                            <div class="help-block with-errors"></div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" id="terms" data-error="Прежде чем оправить данные" required>
                            Докажите что Вы человек
                        </label>
                        <div class="help-block with-errors"></div>
                    </div>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Отправить</button>
                </div>
            </form:form>
        </div>
    </div>

    <!-- Site footer -->
    <jsp:include page="frame/footer.jsp"/>


</div>
</body>
</html>