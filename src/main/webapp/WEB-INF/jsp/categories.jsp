<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categories</title>
</head>
<body>
    <a href="<c:url value="/"/>">Home Page</a>
    <br>
    <ul>
        <c:forEach var="category" items="${requestScope.categories}">
            <li><a href="
                    <c:url value="/category">
                        <c:param name="name" value="${category.name}"/>
                    </c:url>">
                    ${category.name}</a></li>
        </c:forEach>
    </ul>
</body>
</html>
