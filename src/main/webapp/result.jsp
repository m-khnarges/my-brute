<%--
  Created by IntelliJ IDEA.
  User: narges
  Date: 5/18/18
  Time: 3:33 PM
  Result page, view winner & users new characteristics
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Result</title>
    <link rel="icon" href="assets/favicon.ico">
</head>
<body>
<h2>Result</h2>
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
        <th>Winner</th>
        <td><%--@elvariable id="winner" type="edu.db.myBrute.domain.GameUser"--%>
            <c:out value="${winner.getHero().getHeroId()}"/></td>
        <td><c:out value="${winner.getUsername()}"/></td>
        <td><c:out value="${winner.getLevelId()}"/></td>
        <td><c:out value="${winner.getExperience()}"/></td>
        <td><c:out value="${winner.getHealthPoint()}"/></td>
        <td><c:out value="${winner.getHero().getStrength()}"/></td>
        <td><c:out value="${winner.getHero().getAgility()}"/></td>
        <td><c:out value="${winner.getHero().getSpeed()}"/></td>
        <td><c:out value="${winner.getHero().getHeroType()}"/></td>
    </tr>
    <tr>
        <th>Looser</th>
        <td><%--@elvariable id="looser" type="edu.db.myBrute.domain.GameUser"--%>
            <c:out value="${looser.getHero().getHeroId()}"/></td>
        <td><c:out value="${looser.getUsername()}"/></td>
        <td><c:out value="${looser.getLevelId()}"/></td>
        <td><c:out value="${looser.getExperience()}"/></td>
        <td><c:out value="${looser.getHealthPoint()}"/></td>
        <td><c:out value="${looser.getHero().getStrength()}"/></td>
        <td><c:out value="${looser.getHero().getAgility()}"/></td>
        <td><c:out value="${looser.getHero().getSpeed()}"/></td>
        <td><c:out value="${looser.getHero().getHeroType()}"/></td>
    </tr>
</table>

<a href="opponents" style="margin-top: 15px;">PLAY AGAIN!</a>
</body>
</html>
