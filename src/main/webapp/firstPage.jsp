<%--
  Created by IntelliJ IDEA.
  User: narges
  Date: 5/18/18
  Time: 12:45 PM
  First page, View your hero characteristics
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>First Page</title>
    <link rel="icon" href="assets/favicon.ico">
</head>
<body>
<h2>First Page</h2>
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
        <th>Experience</th>
        <td><c:out value="${user.getExperience()}"/></td>
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

<table cellpadding=5>
    <tr>
        <th>ID</th>
        <th>Level</th>
        <th>Chance</th>
        <th>Strength</th>
        <th>Agility</th>
        <th>Speed</th>
    </tr>
    <c:forEach var="weapon" items="${user.getWeapons()}">
        <tr>
            <td><c:out value="${weapon.getWeaponId}"/></td>
            <td><c:out value="${opponent.getLevel().getLevelId}"/></td>
            <td><c:out value="${opponent.getChance}"/></td>
            <td><c:out value="${opponent.getStrength()}"/></td>
            <td><c:out value="${opponent.getAgility()}"/></td>
            <td><c:out value="${opponent.getSpeed()}"/></td>
        </tr>
    </c:forEach>
</table>

<a href="opponents" style="margin-top: 15px;">PLAY NOW!</a>
<a href="logout" style="margin-top: 15px;">LOGOUT</a>
</body>
</html>
