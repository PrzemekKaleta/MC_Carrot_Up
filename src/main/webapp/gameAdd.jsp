<%--
  Created by IntelliJ IDEA.
  User: przemo
  Date: 23.07.21
  Time: 00:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new game</title>
</head>
    <body>
    <%@ include file="header.jspf" %>

    <h1>Here you can add new Game that eat your carrots</h1>

    <p>Current carrots: ${carrots}</p>
    <form action="/game-add" method="post">
        <label>Write hours of gaming:<br>
            <input type="number" step="0.25" name="hours" min="0.25" value="1.0">
        </label><br><br>
        <label>Choose day of gaming:<br>
            <input type="date" name="date" value="${currentDate}">
        </label><br><br>
        <label>Describe gaming:<br>
            <textarea name="description">just a game :)</textarea>
        </label><br><br>
        <input type="submit" value="Add gaming"><br><br>
    </form>


    <%@ include file="footer.jspf" %>

    </body>
</html>
