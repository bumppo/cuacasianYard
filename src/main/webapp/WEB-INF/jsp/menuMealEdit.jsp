<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
    <title>Edit Menu meal</title>
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
    <div class="myDiv">
        <form:form modelAttribute="menuMeal" id="menuMeal" method="post" action="${pageContext.request.contextPath}/menuMeal">
            <form:hidden path="id"/>
            <form:hidden path="menu.id"/>
            <span class="editForm">Menu meal's description:</span>
            <form:input path="description" cssClass="editForm"/>
            <span class="spaces">     </span>
            <span class="editForm">Menu meal's cost:</span>
            <form:input path="cost" cssClass="editForm" cssStyle="width: 100px"/>
            <br><br>
            <input class="myInput" type="submit" value="Save">
            <span class="spaces">                           </span>
            <input class="myInput" type="button" onclick="window.history.back()" value="Cancel">
        </form:form>
    </div>
</section>
</body>
</html>
