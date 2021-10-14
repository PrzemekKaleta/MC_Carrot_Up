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
    <link rel="stylesheet" type="text/css" href="style/style.css">
    <script src="js/jquery-3.6.0.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display&display=swap" rel="stylesheet">
    <script src="js/app4.js" type="text/javascript"></script>
</head>
    <body>

    <h1>Here you can add new Game that eat your carrots</h1>

    <%@ include file="header.jspf" %>

    <section>
        <div class="information">
            <h2>Each hour of the game is equals to 20 hours of learning, come here rarely to avoid eating all the carrots.</h2>
        </div>
    </section>


    <section>
        <div class="information">
            <h2>Current carrots: ${carrots}</h2>
        </div>
    </section>

    <form action="/game-add" method="post" class="form-box">
        <div class="form-title">Write hours of gaming:</div>
        <label>
            <input type="number" step="0.25" name="hours" min="0.25" value="1.0" max="18.00">
        </label>
        <div class="form-title">Choose day of gaming:</div>
        <label>
            <input type="date" name="date" value="${currentDate}" max="${currentDate}">
        </label>
        <div class="form-title">Describe gaming:</div>
        <label>
            <textarea name="description" cols="30" rows="3">just a game :)</textarea>
        </label><br><br>
        <input type="submit" value="Add gaming"><br><br>
    </form>


    <%@ include file="footer.jspf" %>

    </body>
</html>
