<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Edit user</title>
</head>
<body>
<section>
    <h2><a href="${pageContext.request.contextPath}/users">Back to Visitors List</a></h2>
    <hr>
    <jsp:useBean id="user" type="model.User" scope="request"/>
    <form method="post" action="${pageContext.request.contextPath}/users">
        <input type="hidden" name="id" value="${user.id}">
        <dl>
            <dt>Visitor's name:</dt>
            <dd><input type="text" name="name" value="${user.name}"></dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()">Cancel</button>
    </form>
</section>
</body>
</html>
