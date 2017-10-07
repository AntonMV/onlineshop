<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

    <div class="row">
        <div class="center-block" style="width: 30%">
            <form:form action="/spring_security_check" method="post" >
            <div class="form-group">
                <label for="exampleInputEmail1">Email address</label>
                <input name="username" type="email" class="form-control" id="exampleInputEmail1" placeholder="Email"/>
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input name="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password"/>
            </div>
            <div class="form-group" style="margin-bottom: 15px; display: inline-table; width: 100%">
                <div style="display: table-row;">
                    <div style="text-align: left; display: table-cell; width: 50%;">
                        <div class="checkbox">
                            <label>
                                <input name ="remember-me" type="checkbox"/> Check me out
                            </label>
                        </div>
                    </div>
                    <div style="text-align: right; display: table-cell; width: 50%;">
                        <a style="text-decoration: none;" href="/registration">Зарегистрироваться!</a>
                    </div>
                </div>
            </div>
            <button type="submit" class="btn btn-lg btn-success">Submit</button>
        </div>
        </form:form>
        <div style="padding: 10px;">
            <c:if test="${param.error}">
                <div class="error">
                        ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                </div>
            </c:if>
            <c:if test="${param.logout}">
                You have been logged out.
            </c:if>
        </div>
    </div>
</div>