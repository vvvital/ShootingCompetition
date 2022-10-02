<%@ page import="java.text.AttributedString" %>
<%@ page import="org.springframework.ui.Model" %><%--
  Created by IntelliJ IDEA.
  User: vvvit
  Date: 28.09.2022
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>User Page</h1>
<h3>Here will be showing user info </h3>
<p>Welcome</p>
<p>${user.lastName}  ${user.name}</p>
<a href="http://localhost:8080"> Main page </a>

</body>
</html>
