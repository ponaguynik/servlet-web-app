<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp">
    <jsp:param name="css" value="product.css" />
    <jsp:param name="title" value="${requestScope.product.name}" />
</jsp:include>
<main class="flex-container">
    <table>
        <tr>
            <td>Name:</td>
            <td><c:out value="${requestScope.product.name}"/></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><c:out value="${requestScope.product.price}"/></td>
        </tr>
    </table>
</main>
<jsp:include page="footer.jsp" />