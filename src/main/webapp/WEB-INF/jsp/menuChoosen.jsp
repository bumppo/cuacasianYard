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
<br>
<section>
    <table class="myTable">
        <thead>
        <tr>
            <th>Description</th>
            <th>Cost</th>
            <th colspan="3">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${menuChoosen.menuMeals}" var="menuMeal">
            <jsp:useBean id="menuMeal" class="caucasianYard.model.MenuMeal" scope="page"/>
            <tr>
                <c:url var="buyUrl" value="/menuMeal/buy?id=${menuMeal.id}&menuId=${menuMeal.menu.id}"/>
                <c:url var="editUrl" value="/menuMeal/update?id=${menuMeal.id}"/>
                <c:url var="deleteUrl" value="/menuMeal/delete"/>
                <td> ${menuMeal.description} </td>
                <td> ${menuMeal.cost} </td>
                <td><a href="${buyUrl}">Buy</a></td>
                <td><a href="${editUrl}">Edit</a></td>
                <td><a href="${deleteUrl}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <form action="${pageContext.request.contextPath}/menuMeal/create?menuId=${menuChoosen.id}">
        <div class="myDiv">
            <input class="myInput" type="submit" value="Add Meal to Menu">
        </div>
    </form>
</section>
</body>
</html>
