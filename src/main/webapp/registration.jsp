<%--
  Created by IntelliJ IDEA.
  User: vvvit
  Date: 17.09.2022
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h1>Registration</h1>
<form method="post" action="http://localhost:8080/reg">
    <p>Last Name</p>
    <input type="text" name="lastname" id="lastname" maxlength="30">
    <p>Name</p>
    <input type="text" name="name" id="name" maxlength="30">
    <p>Age</p>
    <input type="text" name="age" id="age">
    <p>Email</p>
    <input type="email" name="email" id="email">
    <p>Password</p>
    <input type="password" name="password" id="password">
    <p></p>
    <input type="submit">
    <input type="reset">
</form>
</body>
</html>
