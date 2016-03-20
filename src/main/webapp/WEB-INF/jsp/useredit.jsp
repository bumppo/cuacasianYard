<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
    <title>Edit user</title>
</head>
<body class="myBody">
<div class="myHeader">
    <h2><a href="${pageContext.request.contextPath}/users"><span class="mySpan">Back to Visitors List</span></a></h2>
</div>
<hr>
<section>
    <jsp:useBean id="user" type="model.User" scope="request"/>
    <form method="post" action="${pageContext.request.contextPath}/users">
        <input type="hidden" name="id" value="${user.id}">
        <dl>
            <dt><span class="mySpan">Visitor's name:</span></dt>
            <dd><input type="text" name="name" value="${user.name}" required></dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()">Cancel</button>
    </form>
</section>
</body>
</html>
