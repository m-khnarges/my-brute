<%--
  Created by IntelliJ IDEA.
  User: narges
  Date: 5/13/18
  Time: 7:31 PM
  View all available opponents
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Opponents</title>
    <script src="js/submit.js" language="JavaScript" type="text/javascript"></script>
</head>
<body>
<h2>Opponents</h2>

<table cellpadding=5>
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Level</th>
        <th>Health Point</th>
        <th>Strength</th>
        <th>Agility</th>
        <th>Speed</th>
        <th>Type</th>
        <th>Actions</th>
    </tr>
    <%--@elvariable id="opponents" type="java.util.List"--%>
    <c:forEach var="opponent" items="${opponents}">
        <tr>
            <td><c:out value="${opponent.getHero().getHeroId()}"/></td>
            <td><c:out value="${opponent.getUsername()}"/></td>
            <td><c:out value="${opponent.getLevel().getLevelId()}"/></td>
            <td><c:out value="${opponent.getHealthPoint()}"/></td>
            <td><c:out value="${opponent.getHero().getStrength()}"/></td>
            <td><c:out value="${opponent.getHero().getAgility()}"/></td>
            <td><c:out value="${opponent.getHero().getSpeed()}"/></td>
            <td><c:out value="${opponent.getHero().getHeroType()}"/></td>
            <td>
                <form action="playGame" method="POST" style="margin-bottom: 0">
                    <input type="hidden" name="opponentUsername" value="${opponent.getUsername()}"/>
                    <input type="submit" name="playGame" value="PLAY GAME" style="border: none; background: none" onclick="submit('playGame')">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

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

<a href="/">Return to Main Menu</a>
</body>
</html>
