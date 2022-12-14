<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"
           uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<h1>Users list</h1>
<table border="1" cellpadding="8" cellspacing="0">
    <thead>
    <tr>
        <td>userId</td>
        <td>Last Name</td>
        <td>Name</td>
        <td>Age</td>
        <td>email</td>
        <td>Role</td>
    </tr>
    </thead>
    <c:forEach var="user" items="${users.toArray()}">
        <tr>
            <td>${user.id}</td>
            <td><c:out value="${user.lastName}"/></td>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.age}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><c:out value="${user.role}"/></td>

            <td><a href="http://localhost:8080/registration?id=${user.id}"> Update </a></td>
            <td><a href="http://localhost:8080/delete?id=${user.id}"> Delete </a></td>
        </tr>
    </c:forEach>

</table>
<p>
    <a href="http://localhost:8080"> Main page </a>
</p>
<p>
    <a href="http://localhost:8080/registration"> Create user</a>
</p>
<p>
    <a href="http://localhost:8080/logout">Log out</a>
</p>
</body>
</html>
