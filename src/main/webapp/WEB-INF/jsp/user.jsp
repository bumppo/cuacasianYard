<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
    <title>User</title>
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
    <jsp:useBean id="user" type="caucasianYard.model.User" scope="request"/>
    <c:set var="total" value="${0}"/>
    <h1 style="text-align: center"><span class="header">${user.name}</span></h1>
    <table class="myTable">
        <thead>
        <tr>
            <th>Description</th>
            <th>Cost without discount</th>
            <th>Cost with discount</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${user.meals}" var="meal">
            <jsp:useBean id="meal" class="caucasianYard.model.Meal" scope="page"/>
            <c:set var="total" value="${total + meal.cost}"/>
            <tr>
                <td> ${meal.description} </td>
                <td> ${meal.cost} </td>
                <td><fmt:formatNumber value="${meal.cost*(1-toMoney.discount/100)}" maxFractionDigits="0"/></td>
            </tr>
        </c:forEach>
        <tr>
            <th colspan="2">Tips</th>
            <th><fmt:formatNumber value="${tipsPerUser}" maxFractionDigits="0"/></th>
        </tr>
        <tr>
            <th colspan="2">Total</th>
            <th><fmt:formatNumber value="${total*(1-toMoney.discount/100)+tipsPerUser}" maxFractionDigits="0"/></th>
        </tr>
        </tbody>
    </table>
</section>
</body>
</html>
