<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
    <title>Visitors List</title>
</head>
<body class="myBody">
<div class="myHeader">
    <h2><a href="${pageContext.request.contextPath}/meals"><span class="header">Show Meal List</span></a></h2>
</div>
<hr>
<h1 style="text-align:center"><span class="header">Visitors List</span></h1>
<table class="myTable">
    <thead>
    <tr>
        <th>Name</th>
        <th colspan="2">Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${userList}" var="tempUser">
        <jsp:useBean id="user" class="model.User" scope="page"/>
        <tr>
            <c:url var="editUrl" value="/users/update?id=${tempUser.id}" />
            <c:url var="deleteUrl" value="/users/delete?id=${tempUser.id}" />
            <td><a href="${pageContext.request.contextPath}/users/${tempUser.id}">${tempUser.name}</a></td>
            <td><a href="${editUrl}">Edit</a></td>
            <td><a href="${deleteUrl}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<form action="${pageContext.request.contextPath}/users/create">
    <div class="myDiv">
        <input class="myInput" type="submit" value="Add Visitor">
    </div>
</form>
</body>
</html>
