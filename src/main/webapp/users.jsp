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
        <td>Last Name</td>
        <td>Name</td>
        <td>Age</td>
        <td>email</td>
    </tr>
    </thead>
    <c:forEach var="user" items="${users.toArray()}">
        <tr>
            <td><c:out value="${user.lastName}"/></td>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.age}"/></td>
            <td><c:out value="${user.email}"/></td>
        </tr>
    </c:forEach>

</table>

<a href="index.jsp"> Main page </a>
</body>
</html>
