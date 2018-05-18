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
<h3>Winner</h3>
<table cellpadding=5>
    <tr>
        <th>ID</th>
        <td><%--@elvariable id="winner" type="edu.db.myBrute.domain.GameUser"--%>
            <c:out value="${winner.getHero().getHeroId()}"/></td>
    </tr>
    <tr>
        <th>Username</th>
        <td><c:out value="${winner.getUsername()}"/></td>
    </tr>
    <tr>
        <th>Level</th>
        <td><c:out value="${winner.getLevel().getLevelId()}"/></td>
    </tr>
    <tr>
        <th>Experience</th>
        <td><c:out value="${winner.getExperience()}"/></td>
    </tr>
    <tr>
        <th>Health Point</th>
        <td><c:out value="${winner.getHealthPoint()}"/></td>
    </tr>
    <tr>
        <th>Strength</th>
        <td><c:out value="${winner.getHero().getStrength()}"/></td>
    </tr>
    <tr>
        <th>Agility</th>
        <td><c:out value="${winner.getHero().getAgility()}"/></td>
    </tr>
    <tr>
        <th>Speed</th>
        <td><c:out value="${winner.getHero().getSpeed()}"/></td>
    </tr>
    <tr>
        <th>Type</th>
        <td><c:out value="${winner.getHero().getHeroType()}"/></td>
    </tr>
</table>
<h3>Looser</h3>
<table cellpadding=5>
    <tr>
        <th>ID</th>
        <td><%--@elvariable id="looser" type="edu.db.myBrute.domain.GameUser"--%>
            <c:out value="${looser.getHero().getHeroId()}"/></td>
    </tr>
    <tr>
        <th>Username</th>
        <td><c:out value="${looser.getUsername()}"/></td>
    </tr>
    <tr>
        <th>Level</th>
        <td><c:out value="${looser.getLevel().getLevelId()}"/></td>
    </tr>
    <tr>
        <th>Experience</th>
        <td><c:out value="${looser.getExperience()}"/></td>
    </tr>
    <tr>
        <th>Health Point</th>
        <td><c:out value="${looser.getHealthPoint()}"/></td>
    </tr>
    <tr>
        <th>Strength</th>
        <td><c:out value="${winner.getHero().getStrength()}"/></td>
    </tr>
    <tr>
        <th>Agility</th>
        <td><c:out value="${winner.getHero().getAgility()}"/></td>
    </tr>
    <tr>
        <th>Speed</th>
        <td><c:out value="${winner.getHero().getSpeed()}"/></td>
    </tr>
    <tr>
        <th>Type</th>
        <td><c:out value="${winner.getHero().getHeroType()}"/></td>
    </tr>
</table>

<a href="opponents" style="margin-top: 15px;">PLAY AGAIN!</a>
</body>
</html>
