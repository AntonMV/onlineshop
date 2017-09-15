<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!-- The justified navigation menu is meant for single line per list item.
Multiple lines will require custom code not provided by Bootstrap. -->
<div class="masthead">
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
                        <sec:authentication property= "principal.username"/><spring:message code="label.logrole"/>
                        <b><sec:authentication property= "principal.authorities"/></b>
                    </p>
                </c:if>
            </div>
        </div>
    </div>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/"><span class="glyphicon glyphicon-home"></span></a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/product">Products <span class="sr-only">(current)</span></a></li>
                    <li><a href="/order">Order</a></li>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <li><a href="/users">Users</a></li>
                    </sec:authorize>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Action</a></li>
                            <li><a href="#">Another action</a></li>
                            <li><a href="#">Something else here</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">Separated link</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">One more separated link</a></li>
                        </ul>
                    </li>
                </ul>
                <form class="navbar-form navbar-left">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
                <div class="nav navbar-nav navbar-right">
                    <li><a class="navbar-brand" href="#"><span style="font-size: 25px; line-height: 0.8;" class="glyphicon glyphicon-shopping-cart"><span class="badge">0</span></span></a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Language <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="?lang=ru">Russian</a></li>
                            <li><a href="?lang=en">English</a></li>
                            <li><a href="#">Something else here</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">Separated link</a></li>
                        </ul>
                    </li>
                    <sec:authorize access="!isAuthenticated()">
                        <button onClick='location.href="/login"' type="button" class="btn btn-default navbar-btn " style="margin-left: 15px">Sign in</button>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <button onClick="document.getElementById('logout').submit();" type="button" class="btn btn-default navbar-btn " style="margin-left: 15px">Logout</button>
                        <form:form action="/logout" id="logout" method="post"/>
                    </sec:authorize>
                </div>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</div>
