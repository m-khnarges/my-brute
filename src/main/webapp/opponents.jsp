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
                    <input type="hidden" name="username" value="${opponent.getUsername()}"/>
                    <input type="submit" name="playGame" value="PLAY GAME" style="border: none; background: none" onclick="submit('playGame')">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="/">Return to Main Menu</a>
</body>
</html>
