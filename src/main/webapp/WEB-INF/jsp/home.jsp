<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<c:choose>
    <c:when test="${sessionScope.user != null}">
        <h2><c:out value="Hello ${sessionScope.user.username}!"/></h2><br>
        <form method="post" action="<c:url value="/logout"/>">
            <input type="submit" value="Logout">
        </form>
    </c:when>
    <c:otherwise>
        <a href="<c:url value="/login"/>">Login</a>
    </c:otherwise>
</c:choose>
</body>
</html>
