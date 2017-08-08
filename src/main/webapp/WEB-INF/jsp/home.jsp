<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<c:if test="${requestScope.message != null}">
    <p style="color: green;"><c:out value="${requestScope.message}"/></p>
</c:if>
<c:choose>
    <c:when test="${sessionScope.user != null}">
        <p><c:out value="Hello ${sessionScope.user.username}!"/></p>
        <form method="post" action="<c:url value="/logout"/>">
            <input type="submit" value="Logout">
        </form>
    </c:when>
    <c:otherwise>
        <a href="<c:url value="/login"/>">Login</a>
    </c:otherwise>
</c:choose>
<a href="<c:url value="/categories"/>">Categories</a>
</body>
</html>
