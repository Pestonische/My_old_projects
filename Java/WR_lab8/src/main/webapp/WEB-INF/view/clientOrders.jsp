<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="main" uri="/WEB-INF/mytaglib.tld" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--@elvariable id="userLocale" type="java.util.Locale"--%>
<fmt:setLocale value="${userLocale}"/>
<fmt:setBundle basename="MyBundle"/>

<html>
<head>
    <title><fmt:message key="title.clientOrders"/></title>
    <%@include file="include/header.jsp" %>
</head>
<body>
<%@include file="include/menu.jsp" %>
<header>
    <h1><fmt:message key="title.rest"/></h1>
    <h2><fmt:message key="title.clientOrders"/></h2>
</header>

<form
        id="get-orders-form"
        action="${pageContext.request.contextPath}/serv"
        method="get"
>
    <input type="hidden" name="action" value="clientOrders">
    <div>
        <label for="clientID"><fmt:message key="msg.enterClientID"/></label>
        <input id="clientID" type="number" step="1" min="1" name="clientID">
    </div>
    <input type="submit" value=<fmt:message key="btn.go"/>>
</form>

<%--@elvariable id="clientOrders" type="java.util.List<org.bsu.web.lab8.model.entity.Order>"--%>
<c:if test="${!empty clientOrders}">
    <div class="page-table">
        <main:tableTag
                orders="${clientOrders}"
                admin="${sessionScope['usertype'] == 'admin'}"
        />
            <%--        <table class="table">--%>
            <%--            <thead>--%>
            <%--            <tr>--%>
            <%--                <th>ID</th>--%>
            <%--                <th>Дата заказа</th>--%>
            <%--                <th>Подтвержден</th>--%>
            <%--                <th>Оплачен</th>--%>
            <%--                <th>ID клиента</th>--%>
            <%--                <th>ID админа</th>--%>
            <%--                <th>Позиции</th>--%>
            <%--                <th>Стоимость</th>--%>
            <%--            </tr>--%>
            <%--            </thead>--%>
            <%--            <tbody>--%>
            <%--            <c:forEach items="${clientOrders}" var="order">--%>
            <%--                &lt;%&ndash;@elvariable id="orderDao" type="OrderDao"&ndash;%&gt;--%>
            <%--                <tr>--%>
            <%--                    <td>${order.id}</td>--%>
            <%--                    <td>${order.orderDate}</td>--%>
            <%--                    <td>${order.confirmed}</td>--%>
            <%--                    <td>${order.payed}</td>--%>
            <%--                    <td>${order.client.id}</td>--%>
            <%--                    <td>${order.admin.id}</td>--%>
            <%--                    <td>--%>
            <%--                        <c:forEach items="${order.positions}" var="orderPosition">--%>
            <%--                            <p>--%>
            <%--                                    ${orderPosition.position.itemName}: ${orderPosition.amount}--%>
            <%--                            </p>--%>
            <%--                        </c:forEach>--%>
            <%--                    </td>--%>
            <%--                    <td>${orderDao.getOrderCost(order.id)}</td>--%>
            <%--                </tr>--%>
            <%--            </c:forEach>--%>
            <%--            </tbody>--%>
            <%--        </table>--%>
    </div>
</c:if>
</body>
<footer>
    <%@include file="include/footer.jsp" %>
</footer>
</html>
