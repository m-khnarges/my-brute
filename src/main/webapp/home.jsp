<%--
  Created by IntelliJ IDEA.
  User: narges
  Date: 5/18/18
  Time: 12:45 PM
  Home page, View your hero characteristics
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h2>Home</h2>
<table cellpadding=5>
    <tr>
        <th>ID</th>
        <td><%--@elvariable id="user" type="edu.db.myBrute.domain.GameUser"--%>
        <c:out value="${user.getHero().getHeroId()}"/></td>
    </tr>
    <tr>
        <th>Username</th>
        <td><c:out value="${user.getUsername()}"/></td>
    </tr>
    <tr>
        <th>Level</th>
        <td><c:out value="${user.getLevel().getLevelId()}"/></td>
    </tr>
    <tr>
        <th>Health Point</th>
        <td><c:out value="${user.getHealthPoint()}"/></td>
    </tr>
    <tr>
        <th>Strength</th>
        <td><c:out value="${user.getHero().getStrength()}"/></td>
    </tr>
    <tr>
        <th>Agility</th>
        <td><c:out value="${user.getHero().getAgility()}"/></td>
    </tr>
    <tr>
        <th>Speed</th>
        <td><c:out value="${user.getHero().getSpeed()}"/></td>
    </tr>
    <tr>
        <th>Type</th>
        <td><c:out value="${user.getHero().getHeroType()}"/></td>
    </tr>
</table>

<a href="opponents">PLAY NOW!</a>
<a href="/">Return to Main Menu</a>
</body>
</html>
