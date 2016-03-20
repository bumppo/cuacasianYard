<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
    <title>Edit meal</title>
</head>
<body class="myBody">
<div class="myHeader">
    <h2><a href="${pageContext.request.contextPath}/meals"><span class="mySpan">Back to Meal List</span></a></h2>
</div>
<hr>
<section>
    <form:form modelAttribute="meal" id="meal" method="post" action="${pageContext.request.contextPath}/meals" >
        <form:hidden path="id"/>
        <dl>
            <dt><span class="mySpan">Meal's description:</span></dt>
            <dd>
                <form:input path="description"/>
            </dd>
        </dl>
        <dl>
            <dt><span class="mySpan">Meal's cost:</span></dt>
            <dd>
                <form:input path="cost"/>
            </dd>
        </dl>
        <dl>
            <dt><span class="mySpan">Visitor:</span></dt>
            <dd>
                <form:select path="user" id="user">
                    <form:option value="0" label="---Select Visitor---"/>
                    <form:options items="${userList}" itemValue="id" itemlabel="name"/>
                </form:select>
            </dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()">Cancel</button>
    </form:form>
</section>
</body>
</html>
