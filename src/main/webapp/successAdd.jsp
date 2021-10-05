<%--
  Created by IntelliJ IDEA.
  User: przemo
  Date: 28.07.21
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Success add</title>
    <link rel="stylesheet" type="text/css" href="style/style5.css">
    <script src="js/jquery-3.6.0.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display&display=swap" rel="stylesheet">
    <script src="js/app4.js" type="text/javascript"></script>
</head>
<body>

<h1>Here you can add success to increase carrot level</h1>

<%@ include file="header.jspf" %>

<section>
    <div class="information">
        <h2>Current carrots: ${carrots}</h2>
    </div>
</section>
<section>
    <form action="/success-add" method="post" class="form-box">
        <div class="form-title">Choose kind of success:</div>
        <div class="radio-box">
            <c:forEach items="${kinds}" var="kind" varStatus="count">
                <label>
                    <input type="radio" name="chosenKind" value="${kind.kindId}">
                    <div class="circle"></div>
                    <span>${kind.kindRatio} : ${kind.kindName}</span>
                    <a href="/kind?name=${kind.kindName}"><i class="fas fa-info-circle fa-2x dot"></i></a>
                </label>
            </c:forEach>
        </div>
        <label class="form-title">Choose day of success:<br>
            <input type="date" name="date" value="${currentDate}" max="${currentDate}">
        </label><br><br>
        <label class="form-title">Describe this success:<br>
            <textarea name="description" cols="30" rows="3"></textarea>
        </label><br><br>
        <input type="submit" value="Add success"><br><br>
    </form>
</section>

<%@ include file="footer.jspf" %>

</body>
</html>
