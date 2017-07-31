<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<c:if test="${requestScope.message != null}">
    <p style="color: red;">${requestScope.message}</p>
</c:if>
<form method="post" action="<c:url value="/login"/>">
    <input title="Username" type="text" name="username"><br>
    <input title="Password" type="password" name="password"><br>
    <input type="submit" value="Login">
</form>
</body>
</html>
