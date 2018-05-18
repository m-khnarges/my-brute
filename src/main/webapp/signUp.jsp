<%--
  Created by IntelliJ IDEA.
  User: narges
  Date: 5/13/18
  Time: 10:25 PM
  View sign up form
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Sign Up</title>
    <link rel="icon" href="assets/favicon.ico">
    <script src="assets/submit.js" language="JavaScript" type="text/javascript"></script>
</head>
<body>
<h2>Sign Up</h2>
<form action="signUp" method="POST" name="signUp">
    <label for="username">Username: </label>
    <input type="text" id="username" name="username" tabindex="1" autofocus required autocomplete="username"/>

    <label for="password">Password: </label>
    <input type="password" id="password" name="password" tabindex="2" required autocomplete="new-password"/>

    <label for="confirmPassword">Confirm Password: </label>
    <input type="password" id="confirmPassword" name="confirmPassword" tabindex="3" required
           autocomplete="new-password"/>

    <input type="button" value="SIGN UP" tabindex="4" onclick="submit('signUp')"/>
</form>
</body>
</html>
