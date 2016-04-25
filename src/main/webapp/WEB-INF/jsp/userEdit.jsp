<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
    <title>Edit user</title>
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
    <jsp:useBean id="user" type="caucasianYard.model.User" scope="request"/>
    <form method="post" action="${pageContext.request.contextPath}/users">
        <input type="hidden" name="id" value="${user.id}">
        <span class="editForm">Visitor's name:</span>
        <input class="editForm" type="text" name="name" value="${user.name}" style="width:250px" required>
        <br><br>
        <input class="myInput" type="submit" value="Save">
        <span class="spaces">                           </span>
        <input class="myInput" type="button" onclick="window.history.back()" value="Cancel">
    </form>
    </div>
</section>
</body>
</html>
