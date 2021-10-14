<%--

  Created by IntelliJ IDEA.
  User: przemo
  Date: 15.07.21
  Time: 23:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tag page</title>
    <link rel="stylesheet" type="text/css" href="style/style.css">
    <script src="js/jquery-3.6.0.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display&display=swap" rel="stylesheet">
    <script src="js/app4.js" type="text/javascript"></script>
</head>
    <body>

    <h1>Here you can see more informations about tags learning</h1>

    <%@ include file="header.jspf" %>

    <c:if test="${not empty tag.tagName}">

        <section>
            <div class="information">
                <h2>More information about choosen Tag:</h2>
            </div>
        </section>
        <div class="information-box">
            <div>
                <h2 class="title">Name:</h2>
                <h1>${tag.tagName}</h1>
            </div>

            <div>
                <h2 class="title">Description:</h2>
                <h1>${tag.tagDescription}</h1>
            </div>
            <div>
                <h2 class="title">Others:</h2>
                <h2>This tag was use ${count} times.</h2>
            </div>
            <div>
                <h2 class="title">Is active?</h2>
                <h1><c:if test="${tag.tagActive == true}">YES</c:if></h1>
                <h1><c:if test="${tag.tagActive != true}">NO</c:if></h1>
                <button class="change-button" value="Change activity"><a href="/tag?name=${tag.tagName}&change=true"><i class="fas fa-power-off fa-2x"></i></a></button>
            </div>

        </div>

    </c:if>


    <section>
        <div class="information">
            <h2>Here are all Active tags:</h2>
        </div>
    </section>
    <section>
        <div class="tag-box">
            <c:forEach var="tag" items="${activeTags}">
                <div>
                    <a class="tag-box" href="/tag?name=${tag.tagName}">${tag.tagName}</a>
                </div>
            </c:forEach>
        </div>
    </section>

    <section>
        <div class="information">
            <h2>Here are all Non-Active tags:</h2>
        </div>
    </section>
    <section id="tagKind">
        <div class="tag-box2">
            <c:forEach var="tag" items="${nonActiveTags}">
                <div>
                    <a class="tag-box2" href="/tag?name=${tag.tagName}">${tag.tagName}</a>
                </div>
            </c:forEach>
        </div>
    </section>

    <%@ include file="footer.jspf" %>

    </body>
</html>
