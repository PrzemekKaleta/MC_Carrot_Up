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
</head>
    <body>

    <%@ include file="header.jspf" %>

        <h1>Here you can add new TAG for training</h1>

        <p>Please consider that TAG should have unique name.</p>
        <form action="/tag-add" method="post">
            <legend>Please add new tag</legend>
            <label>Tag name:<br>
                <input type="text" name="name">
            </label><br>
            <label>Tag description:<br>
                <textarea name="description" cols="50" rows="5"></textarea>
            </label><br>
                <input type="submit" value="Create">
        </form>

    <p>Active tags:</p>
    <c:forEach var="tag" items="${activeTags}">
        <a href="/tag?name=${tag.tagName}">${tag.tagName}</a>
    </c:forEach><br>

    <p>Non active tags:</p>
    <c:forEach var="tag" items="${nonActiveTags}">
        <a href="/tag?name=${tag.tagName}">${tag.tagName}</a>
    </c:forEach><br>

    <%@ include file="footer.jspf" %>

    </body>
</html>
