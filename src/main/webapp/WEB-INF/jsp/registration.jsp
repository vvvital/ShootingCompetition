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
<form method="post" action="http://localhost:8080/update">
    <input type="hidden" name="id" value="${user.id}">
    <p>Last Name</p>
    <label for="lastname"></label><input type="text" name="lastname" id="lastname" maxlength="30"
                                         value="${user.lastName}">
    <p>Name</p>
    <label for="name"></label><input type="text" name="name" id="name" maxlength="30" value="${user.name}">
    <p>Age</p>
    <label for="age"></label><input type="text" name="age" id="age" value="${user.age}">
    <p>Email</p>
    <label for="email"></label><input type="email" name="email" id="email" value="${user.email}">
    <p>Password</p>
    <label for="password"></label><input type="password" name="password" id="password" value="${user.password}">
    <p>Role

        <input type=radio id="user" name="role" value="USER" checked>
        <label for="user">USER</label>
        <input type=radio id="admin" name="role" value="ADMIN">
        <label for="admin">ADMIN</label>
    </p>
    <input type="submit">
    <input type="reset">
</form>
</body>
</html>
