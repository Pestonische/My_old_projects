<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="user" type="org.bsu.web.lab8.model.entity.User"--%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--@elvariable id="userLocale" type="java.util.Locale"--%>
<fmt:setLocale value="${userLocale}"/>
<fmt:setBundle basename="MyBundle"/>
<html>
<head>
    <title><fmt:message key="title.makeOrder"/></title>
    <%@include file="include/header.jsp" %>
</head>
<body>
<%@include file="include/menu.jsp" %>
<header>
    <h1><fmt:message key="title.rest"/></h1>
    <h2><fmt:message key="title.makeOrder"/></h2>
</header>
<form
        id="make-order-form"
        action="${pageContext.request.contextPath}/serv?action=makeOrder"
        method="POST"
>
    <label for="client"><fmt:message key="msg.enterClientID"/></label>
    <input min="1"
           step="1"
           id="client"
           type="number"
           name="clientID"
           placeholder="ID"
    >
</form>
</body>
<p>
    <c:if test="${user!=null}">
        <fmt:message key="msg.your"/> id = ${user.id}
    </c:if>
</p>
<footer>
    <%@include file="include/footer.jsp" %>
</footer>
</html>
