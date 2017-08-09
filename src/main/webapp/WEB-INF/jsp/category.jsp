<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp">
    <jsp:param name="css" value="categories.css" />
    <jsp:param name="title" value="Category" />
</jsp:include>
<main class="flex-container">
    <ul class="flex-container">
        <c:forEach var="product" items="${requestScope.products}">
            <li><a href="
                        <c:url value="/product">
                            <c:param name="category" value="${product.category}"/>
                            <c:param name="name" value="${product.name}"/>
                        </c:url>">
                    ${product.name}</a></li>
        </c:forEach>
    </ul>
</main>
<jsp:include page="footer.jsp" />