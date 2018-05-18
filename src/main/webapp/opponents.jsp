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
    <title>Home</title>
</head>
<body>
<h1>Home</h1>
<h2>All Opponents</h2>

<table cellpadding=5>
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Level</th>
        <th>Health Point</th>
        <th>Strength</th>
        <th>Agility</th>
        <th>Speed</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="opponent" items="${opponents}">
        <tr>
            <td>
                <c:out value="${opponent.getHero().getHeroId()}"/>
            </td>
            <td>
                <c:out value="${opponent.getUsername()}"/>
            </td>
            <td>
                <c:out value="${auction.getLevel().getLevelId()}"/>
            </td>
            <td>
                <c:out value="${auction.getHealthPoint()}"/>
            </td>
            <td>
                <c:out value="${auction.getStrength()}"/>
            </td>
            <td>
                <c:out value="${auction.getAgility()}"/>
            </td>
            <td>
                <c:out value="${auction.getSpeed()}"/>
            </td>
            <td>
                <form action="playGame" style="margin-bottom: 0">
                    <input type="hidden" name="username" value="${opponent.getUsername()}"/>
                    <input type="submit" name="playGame" value="PLAY GAME" style="border: none; background: none">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="/">Return to Main Menu</a>
</body>
</html>
