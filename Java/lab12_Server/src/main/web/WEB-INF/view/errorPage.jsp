<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="bundle"/>

<html lang="${language}">
<head>
    <meta charset="UTF-8" />
    <title>KKW Hotel</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
          crossorigin="anonymous">
    <style>
        <%@include file="styles.css"%>
    </style>
</head>
<body>
<form method="get">
    <select id="language" name="language" onchange="submit()">
        <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
        <option value="ru" ${language == 'ru' ? 'selected' : ''}>Russian</option>
    </select>
</form>
<a href="${pageContext.request.contextPath}/serv?command=home"><h3 align = "center"><fmt:message key="index.kkwhotel" /></h3></a>


<div class="sm-padding">
    <div class="container-fluid">
        <div class="row">
            <div class ="col-md-4 offset-md-4">
                <div class="card error-card">
                    <div class="card-body">
                        <h1 align="center"><fmt:message key="error.oops" /> ${pageContext.errorData.statusCode}</h1>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class ="col-md-6 offset-md-3">
                <div class="card error-card">
                    <div class="card-body">
                        <p align="center">${pageContext.errorData.throwable.toString()}</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>