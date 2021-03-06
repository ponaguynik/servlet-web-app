<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/reset.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/${param.css}">
    <title>${param.title}</title>
</head>
<body>
<div id="content">
    <nav class="flex-container">
        <a href="<c:url value="/home"/>">Home</a>
        <a href="<c:url value="/categories"/>">Categories</a>
        <c:choose>
            <c:when test="${cookie.TOKEN == null}">
                <a href="<c:url value="/login"/>" class="login-menu-item"><img src="${pageContext.request.contextPath}/resources/images/login.png" alt="Login"></a>
            </c:when>
            <c:otherwise>
                <a href="<c:url value="/profile"/>">Profile</a>
                <form class="login-menu-item" action="<c:url value="/logout"/>" method="post">
                    <input type="image" src="${pageContext.request.contextPath}/resources/images/logout.png" alt="Logout">
                </form>
            </c:otherwise>
        </c:choose>
    </nav>
    <section class="flex-container">
