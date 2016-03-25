<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
    <title>Edit meal</title>
</head>
<body class="myBody">
<div class="myHeader">
    <h2><a href="${pageContext.request.contextPath}/meals"><span class="header">Back caucasianYard.to Meal List</span></a></h2>
</div>
<hr>
<section>
    <div class="myDiv">
    <form:form modelAttribute="meal" id="meal" method="post" action="${pageContext.request.contextPath}/meals" >
        <form:hidden path="id"/>
        <span class="editForm">Meal's description:</span>
        <form:input path="description" cssClass="editForm"/>
        <span class="spaces">     </span>
        <span class="editForm">Meal's cost:</span>
        <form:input path="cost" cssClass="editForm" cssStyle="width:100px"/>
        <span class="spaces">     </span>
        <span class="editForm">Visitor:</span>
        <form:select path="user" id="user" cssClass="editForm">
            <form:option value="0" label="---Select Visitor---"/>
            <form:options items="${userList}" itemValue="id" itemlabel="name"/>
        </form:select>
        <br><br>
        <input class="myInput" type="submit" value="Save">
        <span class="spaces">                           </span>
        <input class="myInput" type="button" onclick="window.history.back()" value="Cancel">
    </form:form>
    </div>
</section>
</body>
</html>
