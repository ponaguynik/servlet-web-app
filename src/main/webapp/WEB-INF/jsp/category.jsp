<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category - ${param.name}</title>
</head>
<body>
    <a href="<c:url value="/"/>">Home Page</a>
    <a href="<c:url value="/categories"/>">Categories</a>
    <br>
    <ul>
        <c:forEach var="product" items="${requestScope.products}">
            <li><a href="
                        <c:url value="/product">
                            <c:param name="category" value="${product.category}"/>
                            <c:param name="name" value="${product.name}"/>
                        </c:url>">
                    ${product.name}</a></li>
        </c:forEach>
    </ul>
</body>
</html>
