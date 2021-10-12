<%--
  Created by IntelliJ IDEA.
  User: przemo
  Date: 18.07.21
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Add training</title>
    <link rel="stylesheet" type="text/css" href="style/style5.css">
    <script src="js/jquery-3.6.0.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display&display=swap" rel="stylesheet">
    <script src="js/app4.js" type="text/javascript"></script>
</head>
<body>

<h1>Here you can add new Training. Choose suitable tags and describe it.</h1>

<%@ include file="header.jspf"%>


<section>
    <div class="information">
        <h2>Some information about last training:</h2>
    </div>
</section>
<div class="information-box">
    <div>

        <h1>Last training <c:if test="${duration == 0}"> was today.</c:if>
            <c:if test="${duration == 1}"> was yesterday.</c:if>
            <c:if test="${duration > 1}"> was ${duration} days ago.</c:if>

        </h1>
    </div>
    <div>
        <h2 class="title">Date:</h2>
        <h1>${trainingDate}</h1>
    </div>
    <div>
        <h2 class="title">Hours:</h2>
        <h1>${trainingHours}</h1>
    </div>
    <div>
        <h2 class="title">Description:</h2>
        <h2>${trainingDescription}</h2>
    </div>
</div>

<section>
    <div class="information">
        <h2>Add new Training:</h2>
    </div>
</section>

<form class="form-box" action="/trainingAdd" method="post">
    <div class="form-title">Write hours of training:</div>
    <label>
        <input type="number" step="0.25" name="hours" min="0.25" max="18.00" value="1.0">
    </label>
    <div class="form-title">Choose day of training:</div>
    <label>
        <input type="date" name="date" value="${currentDate}" max="${currentDate}">
    </label>
    <div class="form-title">Describe training:</div>
    <label>
        <textarea name="description" cols="30" rows="3"></textarea>
    </label>
    <div class="form-title">Chose tags suitable to training:</div>
    <label>

        <c:forEach items="${tags}" var="tag" varStatus="count">
            <input type="checkbox" name="chosenTags" value="${tag.tagId}"><a href="/tag?name=${tag.tagName}">${tag.tagName}</a><c:if test="${count.count%5==0}"><br></c:if>
        </c:forEach>

    </label>
    <input type="submit" value="Add training">


</form>


<%@ include file="footer.jspf"%>

</body>
</html>
