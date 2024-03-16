<%--
  Created by IntelliJ IDEA.
  User: 陈浩
  Date: 2024/3/11
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h2>Register</h2>
<form  action="register" method="post">
    <div>
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
    </div>
    <div>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
    </div>
    <div>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
    </div>
    <div>
        <label for="birthdate">Birthdate:</label>
        <input type="text" id="birthdate" name="birthdate" required>
    </div>
    <div>
        <%--@declare id="gender"--%><label for="gender">Gender:</label>
        <input type="radio" id="male" name="gender" value="male">
        <label for="male">Male</label><br>
        <input type="radio" id="female" name="gender" value="female">
        <label for="female">Female</label><br>
    </div>
    <div>
        <input type="submit" value="Register">
    </div>
</form>
</body>
</html>
