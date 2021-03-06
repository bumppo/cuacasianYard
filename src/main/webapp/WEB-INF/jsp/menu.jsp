<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
    <title>Menu</title>
</head>
<body class="myBody">
<div class="myHeader">
    <h2><a href="${pageContext.request.contextPath}"><span class="header">Home</span></a></h2>
    <h2><a href="${pageContext.request.contextPath}/menu"><span class="header">Menu</span></a></h2>
    <h2><a href="${pageContext.request.contextPath}/users"><span class="header">Visitors</span></a></h2>
    <h2><a href="${pageContext.request.contextPath}/meals"><span class="header">Meals</span></a></h2>
</div>
<hr>
<section>
    <table class="myTable">
        <tbody>
        <c:forEach items="${menu}" var="menuItem">
            <jsp:useBean id="menuItem" class="caucasianYard.model.Menu" scope="page"/>
            <tr>
                <td><a href="${pageContext.request.contextPath}/menu/${menuItem.id}"> ${menuItem.name} </a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>
</body>
</html>
