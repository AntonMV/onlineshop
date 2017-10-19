<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

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
                        <c:set var="StrVar" value="${objUser.contact.avatar}"/>
                        <c:choose>
                            <c:when test="${empty StrVar}">
                                <img style="width: 222px; height: 222px;" src="resources/img/myprofile.jpg">
                            </c:when>
                            <c:otherwise>
                                <img style="width: 222px; height: 222px;" src="resources/${objUser.contact.avatar}">
                            </c:otherwise>
                        </c:choose>
                        <h3>${objUser.contact.name}</h3>
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
                    <div class="tab-content">
                        <ul id="panuser" class="nav nav-pills">
                            <li><a href="users">О пользователе</a></li>
                            <li><a href="users/edit">Редактировать</a></li>
                            <li><a href="users/email">Сменить email</a></li>
                            <li><a href="users/password">Сменить пароль</a></li>
                        </ul>
                        <tiles:insertAttribute name="body" />
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>