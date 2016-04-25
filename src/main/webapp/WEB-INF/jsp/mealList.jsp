<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
    <title>Meal List</title>
</head>
<body class="myBody">
<div class="myHeader">
    <h2><a href="${pageContext.request.contextPath}"><span class="header">Home</span></a></h2>
    <h2><a href="${pageContext.request.contextPath}/menu"><span class="header">Menu</span></a></h2>
    <h2><a href="${pageContext.request.contextPath}/users"><span class="header">Visitors</span></a></h2>
    <h2><a href="${pageContext.request.contextPath}/meals"><span class="header">Meals</span></a></h2>
</div>
<hr>
<h1 style="text-align:center"><span class="header">Meal List</span></h1>
<table class="myTable">
    <thead>
    <tr>
        <th>Description</th>
        <th>Cost without discount</th>
        <th>Cost with discount</th>
        <th>Visitor</th>
        <th colspan="2">Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${mealList}" var="meal">
        <jsp:useBean id="meal" class="caucasianYard.model.Meal" scope="page"/>
        <tr>
            <c:url var="editUrl" value="/meals/update?id=${meal.id}" />
            <c:url var="deleteUrl" value="/meals/delete?id=${meal.id}" />
            <td>${meal.description}</td>
            <td>${meal.cost}</td>
            <td><fmt:formatNumber value="${meal.cost*(1-toMoney.discount/100)}" maxFractionDigits="0"/></td>
            <td>${meal.user.name}</td>
            <td><a href="${editUrl}">Edit</a></td>
            <td><a href="${deleteUrl}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<form action="${pageContext.request.contextPath}/meals/create">
    <div class="myDiv">
        <input class="myInput" type="submit" value="Add Meal">
    </div>
</form>
<hr>
<section>
    <div class="myDiv">
    <form:form modelAttribute="toMoney" id="toMoney" method="post" action="${pageContext.request.contextPath}/money" >
        <form:hidden path="id"/>
        <span class="money">Payed in fact:</span>
        <form:input path="payed" cssClass="money"/>
        <span class="spaces">     </span>
        <span class="money">Lucky hours:</span>
        <form:input path="lucky" cssClass="money"/>
        <br><br>
        <input class="myInput" type="submit" value="Save">
    </form:form>
    </div>
</section>
<hr>
<table class="myTable">
    <thead>
    <tr>
        <th>Sum without discount</th>
        <th>Discount</th>
        <th>Sum with discount</th>
        <th>Tips</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${toMoney.sumWithOutDiscount}</td>
        <td><fmt:formatNumber value="${toMoney.discount}" maxFractionDigits="2"/>%</td>
        <td>${toMoney.sumWithDiscount}</td>
        <td>${toMoney.tips}</td>
    </tr>
    </tbody>
</table>
</body>
</html>
