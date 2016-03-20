<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <style type="text/css">
        table.myTable {
            font-family: verdana,arial,sans-serif;
            font-size:11px;
            color:#333333;
            border-width: 1px;
            border-color: #999999;
            border-collapse: collapse;
            width: 60%;
            height: 50px;
            margin-left:auto;
            margin-right:auto;
        }
        table.myTable th {
            background:#1ee2ff;
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #999999;
            text-align: center;
        }
        table.myTable td {
            background:#dcddc0 ;
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #999999;
            text-align: center;
        }
    </style>
    <title>Meal List</title>
</head>
<body>
<h2><a href="${pageContext.request.contextPath}/users">Show Visitors List</a></h2>
<h1 style="color:#d2691e; text-align:center">Meal List</h1>

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
<p><a href="${pageContext.request.contextPath}/meals/create">Add meal</a></p>
<br>
</body>
</html>
