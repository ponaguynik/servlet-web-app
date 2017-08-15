<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp">
    <jsp:param name="css" value="profile.css" />
    <jsp:param name="title" value="Profile" />
</jsp:include>
<main class="flex-container">
    <h1>Hello, <c:out value="${requestScope.user.username}"/></h1>
    <h2>Your roles:</h2>
    <c:forEach var="role" items="${requestScope.user.roles}">
        <p>${role.id} - ${role.name}</p><br>
    </c:forEach>
</main>
<jsp:include page="footer.jsp" />
