<%--
  Created by IntelliJ IDEA.
  User: narges
  Date: 5/13/18
  Time: 7:31 PM
  View login form
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Login</title>
    <link rel="icon" href="assets/favicon.ico">
    <script src="assets/submit.js" language="JavaScript" type="text/javascript"></script>
</head>
<body>
<h2>Login</h2>
<form action="login" method="POST" name="login">
    <label for="username">Username: </label>
    <input type="text" id="username" name="username" autocomplete="off" autofocus tabindex="1"/>

    <label for="password">Password: </label>
    <input type="password" id="password" name="password" autocomplete="off" tabindex="2"/>

    <input type="button" value="LOGIN" tabindex="3" onclick="submit('login')"/>
</form>
</body>
</html>
