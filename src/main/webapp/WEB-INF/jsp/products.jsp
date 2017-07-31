<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${requestScope.category}</title>
</head>
<body>
    <a href="<c:url value="/"/>">Home Page</a>
    <br>
    <table>
        <tr>
            <th>Product Name</th>
            <th>Price</th>
        </tr>
        <c:forEach var="product" items="${requestScope.products}">
            <tr>
                <td>${product.name}</td>
                <td>${product.price}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
