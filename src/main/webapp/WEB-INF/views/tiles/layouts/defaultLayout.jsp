<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="Site CORIUM lether working">
    <meta name="author" content="Mikhaylov Anton">

    <link rel="icon" href="/resources/favicon.ico">

    <title><spring:message code="label.title"/></title>

    <base href="${pageContext.request.contextPath}/"/>
    <!-- Bootstrap core CSS -->
    <link href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" rel="stylesheet">
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="/resources/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="/resources/css/justified-nav.css" rel="stylesheet">
    <link href="/resources/css/user.css" rel="stylesheet">
    <!-- Font Awesome-->
    <link rel="stylesheet" href="/resources/css/font-awesome.min.css">
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="/resources/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="/resources/js/ie-emulation-modes-warning.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="/resources/js/html5shiv.min.js"></script>
    <script src="/resources/js/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript" src="/webjars/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js" defer></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script type="text/javascript" src="/resources/js/ie10-viewport-bug-workaround.js"></script>
    <!--Custom scripts-->
    <script type="text/javascript" src="/resources/js/scripts.js"></script>
    <!--Validator-->
    <script type="text/javascript" src="/webjars/bootstrap-validator/0.7.3/js/validator.js"></script>

</head>

<body>
<div class="container">
    <div class="masthead">
        <header id="header">
            <tiles:insertAttribute name="header" />
        </header>
        <section id="sidemenu">
            <tiles:insertAttribute name="menu" />
        </section>
    </div>
    <section id="site-content">
        <tiles:insertAttribute name="body" />
    </section>
    <footer id="footer">
        <tiles:insertAttribute name="footer" />
    </footer>
</div>
</body>
</html>