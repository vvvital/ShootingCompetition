<html>
<body>
<h2>Hello!</h2>
<p>Welcome to Shooting Competition</p>
<p>${massage}</p>
<form action="http://localhost:8080/login" method="get">
    <p>email</p>
    <label for="email"></label><input type="text" name="email" id="email" maxlength="30" value="example@mail.ua">
    <p>password</p>
    <label for="password"></label><input type="text" name="password" id="password" maxlength="30" value="password">
    <p>
        <input type="submit"> <input type="reset">
    </p>
</form>
<p>
<button><a href="http://localhost:8080/registration"> Registration</a></button>
</p>
<p>
<button><a href="http://localhost:8080/users"> User list</a></button>
</p>
</body>
</html>
