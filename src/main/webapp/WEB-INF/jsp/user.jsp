<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
    <title>User</title>
</head>
<body class="myBody">
<div class="myHeader">
    <h2><a href="${pageContext.request.contextPath}/users"><span class="mySpan">Back to Visitors List</span></a></h2>
    <h2><a href="${pageContext.request.contextPath}/meals"><span class="mySpan">Show Meal List</span></a></h2>
</div>
<hr>
<section>
    <jsp:useBean id="user" type="model.User" scope="request"/>
    <c:set var="total" value="${0}"/>
    <h1 style="color:#d2691e; text-align: center"><span class="mySpan">${user.name}</span></h1>
    <table class="myTable">
        <thead>
        <tr>
            <th>Description</th>
            <th>Cost</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${user.meals}" var="meal">
            <jsp:useBean id="meal" class="model.Meal" scope="page"/>
            <c:set var="total" value="${total + meal.cost}"/>
            <tr>
                <td> ${meal.description} </td>
                <td> ${meal.cost} </td>
            </tr>
        </c:forEach>
        <tr>
            <th>Total</th>
            <th>${total}</th>
        </tr>
        </tbody>
    </table>
</section>
</body>
</html>
