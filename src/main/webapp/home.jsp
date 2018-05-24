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
    <title>Home</title>
    <link rel="icon" href="assets/favicon.ico">
</head>
<body>
<h2>Home</h2>
<h3>My Information</h3>
<table cellpadding=5>
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Level</th>
        <th>Experience</th>
        <th>Health Point</th>
        <th>Left Fights</th>
        <th>Strength</th>
        <th>Agility</th>
        <th>Speed</th>
        <th>Type</th>
    </tr>
    <tr>
        <td><%--@elvariable id="user" type="edu.db.myBrute.domain.GameUser"--%>
        <c:out value="${user.getHero().getHeroId()}"/></td>
        <td><c:out value="${user.getUsername()}"/></td>
        <td><c:out value="${user.getLevelId()}"/></td>
        <td><c:out value="${user.getExperience()}"/></td>
        <td><c:out value="${user.getHealthPoint()}"/></td>
        <td><c:out value="${user.getLeftFights()}"/></td>
        <td><c:out value="${user.getHero().getStrength()}"/></td>
        <td><c:out value="${user.getHero().getAgility()}"/></td>
        <td><c:out value="${user.getHero().getSpeed()}"/></td>
        <td><c:out value="${user.getHero().getHeroType()}"/></td>
    </tr>
</table>

<h3>My Weapons</h3>
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
            <td><c:out value="${weapon.getWeaponId()}"/></td>
            <td><c:out value="${weapon.getLevelId()}"/></td>
            <td><c:out value="${weapon.getChance()}"/></td>
            <td><c:out value="${weapon.getStrength()}"/></td>
            <td><c:out value="${weapon.getAgility()}"/></td>
            <td><c:out value="${weapon.getSpeed()}"/></td>
        </tr>
    </c:forEach>
</table>

<a href="opponents" style="margin-top: 15px;">PLAY NOW!</a>
<a href="logout" style="margin-top: 15px;">LOGOUT</a>
</body>
</html>
