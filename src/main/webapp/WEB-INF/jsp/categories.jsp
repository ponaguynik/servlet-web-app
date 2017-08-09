<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp">
    <jsp:param name="css" value="categories.css" />
    <jsp:param name="title" value="Categories" />
</jsp:include>
<main class="flex-container">
    <ul class="flex-container">
        <c:forEach var="category" items="${requestScope.categories}">
            <li><a href="
                    <c:url value="/category">
                        <c:param name="name" value="${category.name}"/>
                    </c:url>">
                    ${category.name}</a></li>
        </c:forEach>
    </ul>
</main>
<jsp:include page="footer.jsp" />