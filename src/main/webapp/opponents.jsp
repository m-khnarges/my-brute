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
    <link rel="icon" href="assets/favicon.ico">
    <script src="assets/submit.js" language="JavaScript" type="text/javascript"></script>
</head>
<body>
<h2>Opponents</h2>

<p><%--@elvariable id="user" type="edu.db.myBrute.domain.GameUser"--%>
    You have <c:out value="${user.getLeftFights()}"/> fights left!
</p>

<c:choose>
    <c:when test="${user.leftFights >= 1}">
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
                <th></th>
            </tr>
                <%--@elvariable id="opponents" type="java.util.List"--%>
            <c:forEach var="opponent" items="${opponents}">
                <tr>
                    <td><c:out value="${opponent.getHero().getHeroId()}"/></td>
                    <td><c:out value="${opponent.getUsername()}"/></td>
                    <td><c:out value="${opponent.getLevelId()}"/></td>
                    <td><c:out value="${opponent.getExperience()}"/></td>
                    <td><c:out value="${opponent.getHealthPoint()}"/></td>
                    <td><c:out value="${opponent.getLeftFights()}"/></td>
                    <td><c:out value="${opponent.getHero().getStrength()}"/></td>
                    <td><c:out value="${opponent.getHero().getAgility()}"/></td>
                    <td><c:out value="${opponent.getHero().getSpeed()}"/></td>
                    <td><c:out value="${opponent.getHero().getHeroType()}"/></td>
                    <td><a href="play?opponentUsername=${opponent.getUsername()}">Choose for Play</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td><c:out value="${user.getHero().getHeroId()}"/></td>
                <td><c:out value="${user.getUsername()}"/></td>
                <td><c:out value="${user.getLevelId()}"/></td>
                <td><c:out value="${user.getExperience()}"/></td>
                <td><c:out value="${user.getHealthPoint()}"/></td>
                <td><c:out value="${user.getLeftFights()}"/></td>
                <td><c:out value="${user.getHero().getStrength()}"/></td>
                <td><c:out value="${user.getHero().getAgility()}"/></td>
                <td><c:out value="${user.getHero().getSpeed()}"/></td>
                <td><c:out value="${user.getHero().getHeroType()}"/></td>
                <td>IT'S ME!</td>
            </tr>
        </table>
    </c:when>
    <c:otherwise>
        <a href="logout">LOGOUT</a>
    </c:otherwise>
</c:choose>


</body>
</html>
