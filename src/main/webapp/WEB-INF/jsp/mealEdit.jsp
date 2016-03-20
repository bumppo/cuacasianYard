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
    <%--<jsp:useBean id="meal" type="model.Meal" scope="request"/>--%>
    <form:form modelAttribute="meal" id="meal" method="post" action="${pageContext.request.contextPath}/meals" >
        <form:hidden path="id"/>
        <%--<input type="hidden" name="id" value="${meal.id}">--%>
        <dl>
            <dt>Meal's description:</dt>
            <dd>
                <form:input path="description"/>
                <%--<input type="text" name="description" value="${meal.description}" required>--%>
            </dd>
        </dl>
        <dl>
            <dt>Meal's cost</dt>
            <dd>
                <form:input path="cost"/>
                <%--<input type="number" name="cost" value="0" required>--%>
            </dd>
        </dl>
        <dl>
            <dt>Visitor</dt>
            <dd>
                <form:select path="user_id">
                    <form:option value="0" label="---Select One---"/>
                    <%--<form:options items="${userList}" itemValue="id" itemLabel="name"/>--%>
                    <c:forEach items="${userList}" var="user">
                        <c:choose>
                            <c:when test="${meal.user_id == user.id}">
                                <option value="${user.id}" selected="selected">${user.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${user.id}">${user.name}</option>
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
