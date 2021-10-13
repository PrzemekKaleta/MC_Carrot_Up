<%--
  Created by IntelliJ IDEA.
  User: przemo
  Date: 14.07.21
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Add new tag</title>
    <link rel="stylesheet" type="text/css" href="style/style5.css">
    <script src="js/jquery-3.6.0.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display&display=swap" rel="stylesheet">
    <script src="js/app4.js" type="text/javascript"></script>
</head>
    <body>

    <h1>Here you can add new TAG for training. It is an additive information to group your learning time.</h1>

   <%@ include file="header.jspf" %>

    <section>
        <div class="information">
            <h2>Please consider that TAG should have unique name and you can not change it after all. It is only posible to deactivate it. Fresh tag is always active.</h2>
        </div>
    </section>


        <form action="/tag-add" method="post" class="form-box">

            <div class="form-title">Write a name for new tag:</div>
            <label>
                <input type="text" name="name" required="required">
                <div class="watchOut"><c:if test="${added==false}">This name is exist, cannot save this tag.</c:if></div>
                <div class="watchOut"><c:if test="${added==true}">Tag was saved.</c:if></div>
            </label>
            <div class="form-title">Write Tag description:</div>
            <label>
                <textarea name="description" cols="30" rows="3"></textarea>
            </label>
            <input type="submit" value="Create">
        </form>

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
