<%--
  Created by IntelliJ IDEA.
  User: vvvit
  Date: 17.09.2022
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>LOGIN</h1>
<form method="get" action="http://localhost:8080/login">
    <p>Login</p>
    <label for="login"></label><input type="text" id="login" name="login" maxlength="30">
    <p>Password</p>
    <input type="text" id="password" name="password" maxlength="30">
    <p></p>
    <input type="submit">
    <input type="reset">
</form>
<button><a href="registration.jsp"> Registration </a></button>
</body>
</html>
