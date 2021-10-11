<%--

  Created by IntelliJ IDEA.
  User: przemo
  Date: 28.07.21
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Kind Page</title>
    <link rel="stylesheet" type="text/css" href="style/style5.css">
    <script src="js/jquery-3.6.0.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display&display=swap" rel="stylesheet">
    <script src="js/app4.js" type="text/javascript"></script>
</head>
<body>

<h1>Here you can check more information about Kinds of success</h1>

<%@ include file="header.jspf" %>

<c:if test="${not empty kind}">

    <section>
        <div class="information">
            <h2>More information about choosen Kind:</h2>
        </div>
    </section>
    <div class="information-box">
        <div>
            <h2 class="title">Name:</h2>
            <h1>${kind.kindName}</h1>
        </div>

        <div>
            <h2 class="title">Description:</h2>
            <h1>${kind.kindDescription}</h1>
        </div>

        <div>
            <h2 class="title">Ratio:</h2>
            <h1>${kind.kindRatio}</h1>
        </div>
        <div>
            <h2 class="title">Others:</h2>
            <h2>This kind of success was achieve ${count} times. <c:if test="${count>0}">Last time at ${lastDate}.</c:if> </h2>
            <h2>This one succes is equals ${proportion} hours of learning.</h2>
        </div>
    </div>
</c:if>


<section>
    <div class="information">
        <h2>Here are all kinds of success:</h2>
    </div>
</section>
<section id="tagKind">
    <div class="tag-box">
        <c:forEach var="kind" items="${kinds}">
            <div>
                <a class="tag-box" href="/kind?name=${kind.kindName}">${kind.kindRatio} : ${kind.kindName}</a>
            </div>
        </c:forEach>
    </div>
</section>

<%@ include file="footer.jspf" %>

</body>
</html>
