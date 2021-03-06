<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
    <title>User without Meal</title>
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
    <jsp:useBean id="user" type="caucasianYard.model.User" scope="request"/>
    <h1 style="text-align: center"><span class="header">${user.name}</span></h1>
    <br><br><br>
    <h1 style="text-align: center"><span class="header">На диете!!!</span></h1>
</section>
</body>
</html>
