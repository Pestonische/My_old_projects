<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 4/20/2021
  Time: 7:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<p>Name : ${sessionScope.user.name}</p>
<p>Surname : ${sessionScope.user.surname}</p>
<p>City : ${sessionScope.user.city}</p>
<p>Address : ${sessionScope.user.address}</p>
<p>BirthDate : ${sessionScope.user.birthDate}</p>
<p>Registered in : ${sessionScope.user.registrationDate}</p>

</body>
</html>
