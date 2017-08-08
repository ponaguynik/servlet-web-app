<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up Page</title>
</head>
<body>
    <c:if test="${requestScope.error != null}">
        <p style="color: red;"><c:out value="${requestScope.error}"/></p>
    </c:if>
    <form action="/signup" method="post">
        Username: <input type="text" title="username" name="username" required><br>
        Password: <input type="password" title="password" name="password" required><br>
        <input type="submit" value="Sign Up">
    </form>
</body>
</html>
