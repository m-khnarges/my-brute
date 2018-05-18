<%--
  Created by IntelliJ IDEA.
  User: narges
  Date: 5/18/18
  Time: 2:50 PM
  Review your opponent & your information
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>" %>
<html>
<head>
    <title>Play Game</title>
    <link rel="icon" href="assets/favicon.ico">
</head>
<body>
<h2>Home</h2>
<table cellpadding=5>
    <tr>
        <th></th>
        <th>Your Information</th>
        <th>Opponent Information</th>
    </tr>
    <tr>
        <th>ID</th>
        <td><%--@elvariable id="user" type="edu.db.myBrute.domain.GameUser"--%>
            <c:out value="${user.getHero().getHeroId()}"/></td>
        <td><%--@elvariable id="opponent" type="edu.db.myBrute.domain.GameUser"--%>
            <c:out value="${opponent.getHero().getHeroId()}"/></td>
    </tr>
    <tr>
        <th>Username</th>
        <td><c:out value="${user.getUsername()}"/></td>
        <td><c:out value="${opponent.getUsername()}"/></td>
    </tr>
    <tr>
        <th>Level</th>
        <td><c:out value="${user.getLevel().getLevelId()}"/></td>
        <td><c:out value="${opponent.getLevel().getLevelId()}"/></td>
    </tr>
    <tr>
        <th>Health Point</th>
        <td><c:out value="${user.getHealthPoint()}"/></td>
        <td><c:out value="${opponent.getHealthPoint()}"/></td>
    </tr>
    <tr>
        <th>Strength</th>
        <td><c:out value="${user.getHero().getStrength()}"/></td>
        <td><c:out value="${opponent.getHero().getStrength()}"/></td>
    </tr>
    <tr>
        <th>Agility</th>
        <td><c:out value="${user.getHero().getAgility()}"/></td>
        <td><c:out value="${opponent.getHero().getAgility()}"/></td>
    </tr>
    <tr>
        <th>Speed</th>
        <td><c:out value="${user.getHero().getSpeed()}"/></td>
        <td><c:out value="${opponent.getHero().getSpeed()}"/></td>
    </tr>
    <tr>
        <th>Type</th>
        <td><c:out value="${user.getHero().getHeroType()}"/></td>
        <td><c:out value="${opponent.getHero().getHeroType()}"/></td>
    </tr>
</table>

<a href="attack?opponent=${opponent.getUsername()}" style="margin-top: 15px;">ATTACK!</a>
</body>
</html>
