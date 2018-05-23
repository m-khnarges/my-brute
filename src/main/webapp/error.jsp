<%--
  Created by IntelliJ IDEA.
  User: narges
  Date: 5/18/18
  Time: 11:31 AM
  Error page
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="icon" href="assets/favicon.ico">
    <title>Error</title>
</head>
<body>
<h3>ERROR</h3>
<p><%--@elvariable id="message" type="java.lang.String"--%>
    <c:out value="${message}"/></p>

<a style="margin-top: 15px;" href="/myBrute">Return to Main Menu</a>
</body>
</html>