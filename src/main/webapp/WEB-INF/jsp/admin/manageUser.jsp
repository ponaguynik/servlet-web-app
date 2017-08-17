<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="<c:url value="/admin/users/manageUser/update"/>" method="post">
    <label for="username-input">Username:</label>
    <input id="username-input" type="text" name="username" value="${requestScope.user.username}" maxlength="15" required>
    <br>
    <label for="email-input">Email:</label>
    <input id="email-input" type="email" name="email" value="${requestScope.user.email}" maxlength="30" required>
    <input type="hidden" name="userId" value="${requestScope.user.id}">
    <input type="submit" value="Update">
</form>
<form action="<c:url value="/admin/users/manageUser/updateRoles"/>" method="post">
    <c:forEach var="role" items="${requestScope.roles}" varStatus="count">
        <label for="role${count}"><c:out value="${role.name}"/></label>
        <c:set var="contains" value="false"/>
        <c:forEach var="r" items="${requestScope.user.roles}">
            <c:if test="${r eq role}">
                <c:set var="contains" value="true"/>
            </c:if>
        </c:forEach>
        <c:choose>
            <c:when test="${contains eq true}">
                <input id="role${count}" type="checkbox" name="role" value="${role.id}" checked>
            </c:when>
            <c:otherwise>
                <input id="role${count}" type="checkbox" name="role" value="${role.id}">
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <input type="hidden" name="userId" value="${requestScope.user.id}">
    <input type="submit" value="Update">
</form>
<form action="<c:url value="/admin/users/manageUser/updateAvatar"/>" method="post">
    <img src="${pageContext.request.contextPath}/resources/images/user/avatar/${requestScope.user.username}.jpg" alt="user-avatar">
    <input type="hidden" name="userId" value="${requestScope.user.id}">
</form>