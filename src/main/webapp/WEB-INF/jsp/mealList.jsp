<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
    <title>Meal List</title>
</head>
<body class="myBody">
<div class="myHeader">
    <h2><a href="${pageContext.request.contextPath}/users"><span class="mySpan">Show Visitors List</span></a></h2>
</div>
<hr>
<h1 style="text-align:center"><span class="mySpan">Meal List</span></h1>
<table class="myTable">
    <thead>
    <tr>
        <th>Description</th>
        <th>Cost</th>
        <th>Visitor</th>
        <th colspan="2">Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${mealList}" var="meal">
        <jsp:useBean id="meal" class="model.Meal" scope="page"/>
        <tr>
            <c:url var="editUrl" value="/meals/update?id=${meal.id}" />
            <c:url var="deleteUrl" value="/meals/delete?id=${meal.id}" />
            <td> ${meal.description} </td>
            <td> ${meal.cost} </td>
            <td> ${meal.user.name}</td>
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
</body>
</html>
