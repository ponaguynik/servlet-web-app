<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product - ${requestScope.product.name}</title>
</head>
<body>
    <a href="<c:url value="/"/>">Home Page</a>
    <a href="<c:url value="/categories"/>">Categories</a>
    <a href="
                    <c:url value="/category">
                        <c:param name="name" value="${requestScope.product.category}"/>
                    </c:url>">${requestScope.product.category}</a>
    <p>Name: <c:out value="${requestScope.product.name}"/></p>
    <p>Price: <c:out value="${requestScope.product.price}"/></p>
</body>
</html>
