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
    <title>Play</title>
    <link rel="icon" href="assets/favicon.ico">
</head>
<body>
<h2>Play</h2>
<table cellpadding=5>
    <tr>
        <th></th>
        <th>ID</th>
        <th>Username</th>
        <th>Level</th>
        <th>Experience</th>
        <th>Health Point</th>
        <th>Strength</th>
        <th>Agility</th>
        <th>Speed</th>
        <th>Type</th>
    </tr>
    <tr>
        <th>Your Information</th>
        <td><%--@elvariable id="user" type="edu.db.myBrute.domain.GameUser"--%>
            <c:out value="${user.getHero().getHeroId()}"/></td>
        <td><c:out value="${user.getUsername()}"/></td>
        <td><c:out value="${user.getLevelId()}"/></td>
        <td><c:out value="${user.getExperience()}"/></td>
        <td><c:out value="${user.getHealthPoint()}"/></td>
        <td><c:out value="${user.getHero().getStrength()}"/></td>
        <td><c:out value="${user.getHero().getAgility()}"/></td>
        <td><c:out value="${user.getHero().getSpeed()}"/></td>
        <td><c:out value="${user.getHero().getHeroType()}"/></td>

    </tr>
    <tr>
        <th>Opponent Information</th>
        <td><%--@elvariable id="opponent" type="edu.db.myBrute.domain.GameUser"--%>
            <c:out value="${opponent.getHero().getHeroId()}"/></td>
        <td><c:out value="${opponent.getUsername()}"/></td>
        <td><c:out value="${opponent.getLevelId()}"/></td>
        <td><c:out value="${opponent.getExperience()}"/></td>
        <td><c:out value="${opponent.getHealthPoint()}"/></td>
        <td><c:out value="${opponent.getHero().getStrength()}"/></td>
        <td><c:out value="${opponent.getHero().getAgility()}"/></td>
        <td><c:out value="${opponent.getHero().getSpeed()}"/></td>
        <td><c:out value="${opponent.getHero().getHeroType()}"/></td>
    </tr>
</table>

<a href="result?opponentUsername=${opponent.getUsername()}" style="margin-top: 15px;">ATTACK!</a>
</body>
</html>
