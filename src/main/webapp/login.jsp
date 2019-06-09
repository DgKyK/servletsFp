<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 26.05.2019
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/login">
        <input type="text" name="login"><br>
        <input type="password" name="password"><br>
        <input type="submit" value="Enter">
    </form>
<h1>Login</h1>
<h2><a href="${pageContext.request.contextPath}/index.jsp">index.jsp</a> </h2>
</body>
</html>
