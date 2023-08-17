<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--@elvariable id="userLocale" type="java.util.Locale"--%>
<fmt:setLocale value="${userLocale}"/>
<fmt:setBundle basename="MyBundle"/>
<html>
<head>
    <title><fmt:message key="nav.login"/></title>
    <%@include file="include/header.jsp" %>
    <style>
        .main-content {
            width: 50%;
            border-radius: 20px;
            box-shadow: 0 5px 5px rgba(0, 0, 0, .4);
            margin: 5em auto;
            display: flex;
        }

        @media screen and (max-width: 640px) {
            .main-content {
                width: 90%;
            }

            .login_form {
                border-radius: 20px;
            }
        }

        @media screen and (min-width: 642px) and (max-width: 800px) {
            .main-content {
                width: 70%;
            }
        }

        .row > h2 {
            color: #008080;
        }

        .login_form {
            background-color: #fff;
            border-radius: 20px;
            border-top: 1px solid #ccc;
            border-right: 1px solid #ccc;
        }

        form {
            padding: 0 2em;
        }

        .form__input {
            width: 100%;
            border: 0 solid transparent;
            border-radius: 0;
            border-bottom: 1px solid #aaa;
            padding: 1em .5em .5em 2em;
            outline: none;
            margin: 1.5em auto;
            transition: all .5s ease;
        }

        .form__input:focus {
            border-bottom-color: #008080;
            box-shadow: 0 0 5px rgba(0, 80, 80, .4);
            border-radius: 4px;
        }

        .btn {
            transition: all .5s ease;
            width: 100%;
            border-radius: 30px;
            color: #008080;
            font-weight: 600;
            background-color: #fff;
            border: 1px solid #008080;
            margin-top: 1.5em;
            margin-bottom: 1em;
        }

        .btn:hover, .btn:focus {
            background-color: #008080;
            color: #fff;
        }
    </style>

</head>
<body>
<%@include file="include/menu.jsp" %>
<!-- Main Content -->
<div class="container-fluid">
    <div class="row main-content bg-success text-center">
        <div class="login_form ">
            <div class="container-fluid">
                <div class="row">
                    <form class="form-group" action="${pageContext.request.contextPath}/serv"
                          method="get">
                        <div class="row">
                            <input type="text" name="username" id="username" class="form__input"
                                   placeholder="<fmt:message key="placeholder.username"/>">
                        </div>
                        <div class="row">
                            <input type="password" name="password" id="password" class="form__input"
                                   placeholder="<fmt:message key="placeholder.password"/>">
                        </div>
                        <div class="row">
<%--                            <input type="hidden" name="action" value="login">--%>
                            <input type="submit" value="login" class="btn" name="action">
                        </div>
                        <div class="row">
<%--                            <input type="hidden" name="action" value="signup">--%>
                            <input type="submit" value="signup" class="btn" name="action">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
