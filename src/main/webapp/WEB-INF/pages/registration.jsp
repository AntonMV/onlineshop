<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/resources/favicon.ico">

    <title>CORIUM Lether working</title>

    <!-- Bootstrap core CSS -->
    <link href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="/resources/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/resources/css/justified-nav.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="resources/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="resources/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="resources/js/html5shiv.min.js"></script>
    <script src="resources/js/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript" src="webjars/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js" defer></script>
</head>

<body>

<div class="container">

    <!-- Site header -->
    <jsp:include page="frame/header.jsp"/>

    <!-- Form registartion -->
    <div class="row">
        <div class="col-md-6 col-md-offset-3">

            <form:form method="POST" modelAttribute="userForm" data-toggle="validator" role="form">
                <spring:bind path="name">
                <div class="form-group">
                    <label for="inputName" class="control-label">Ваше имя</label>
                    <input type="text" class="form-control" id="inputName" placeholder="Введите Ваше имя" required>
                </div>
                </spring:bind>
                <spring:bind path="email">
                <div class="form-group">
                    <label for="inputEmail" class="control-label">Ваш E-mail</label>
                    <input type="email" class="form-control" id="inputEmail" placeholder="Email" data-error="Вы не правильно ввели Ваш E-mail" required>
                    <div class="help-block with-errors"></div>
                </div>
                </spring:bind>
                <div class="form-group">
                    <label for="inputPassword" class="control-label">Введите пароль</label>
                    <div class="form-inline row">
                        <spring:bind path="password">
                        <div class="form-group col-sm-6">
                            <input type="password" data-toggle="validator" data-minlength="8" class="form-control" id="inputPassword" placeholder="Enter you password" required>
                            <span class="help-block">Минимум 6 значений</span>
                        </div>
                        </spring:bind>
                        <div class="form-group col-sm-6">
                            <input type="password" class="form-control" id="inputPasswordConfirm" data-match="#inputPassword" data-match-error="Ошибка! Пароли не совпадают!" placeholder="Повторите пароль" required>
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