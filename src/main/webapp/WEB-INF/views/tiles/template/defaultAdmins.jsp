<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-3">
            <ul id="panprod" class="nav nav-pills nav-stacked">
                <li><a href="adminpanel">Товары</a></li>
                <li><a href="orrder">Заказы</a></li>
                <li><a href="controluser">Пользователи</a></li>
            </ul>
        </div>
        <div class="col-sm-9">
            <tiles:insertAttribute name="body" />
        </div>
    </div>
</div>