<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Edit meal</title>
</head>
<body>
<section>
    <h2><a href="${pageContext.request.contextPath}/meals">Back to Meal List</a></h2>
    <hr>
    <form:form modelAttribute="meal" id="meal" method="post" action="${pageContext.request.contextPath}/meals" >
        <form:hidden path="id"/>
        <dl>
            <dt>Meal's description:</dt>
            <dd>
                <form:input path="description"/>
            </dd>
        </dl>
        <dl>
            <dt>Meal's cost</dt>
            <dd>
                <form:input path="cost"/>
            </dd>
        </dl>
        <dl>
            <dt>Visitor</dt>
            <dd>
                <form:select path="user" id="user">
                    <form:option value="0" label="---Select One---"/>
                    <c:forEach items="${userList}" var="tempUser">
                        <c:choose>
                            <c:when test="${meal.user.name == tempUser.name}">
                                <option value="${tempUser.id}" selected="selected">${tempUser.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${tempUser.id}">${tempUser.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </form:select>
            </dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()">Cancel</button>
    </form:form>
</section>
</body>
</html>
