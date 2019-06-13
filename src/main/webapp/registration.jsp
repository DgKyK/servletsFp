<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 11.06.2019
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h2>Registration</h2>
<form method="post" action="${pageContext.request.contextPath}/registration">
    <label>Login</label><input type="text" name="login"><br>
    <label>password</label><input type="password" name="password"><br>
    <label>email</label><input type="email" name="email"><br>
    <input type="submit" value="Register">
</form>
</body>
</html>
