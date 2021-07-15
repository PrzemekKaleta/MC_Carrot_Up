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

        <h1>Here you can add new TAG for training</h1>

        <p>Please consider that TAG should have unique name.</p>
        <form action="/tag-add" method="post">
            <legend>Please add new tag</legend>
            <label>Tag name:
                <input type="text" name="name">
            </label>
            <label>Tag description:
                <input type="text" name="description">
            </label>
                <input type="submit" value="Create">
        </form>

        <c:forEach var="tag" items="${tags}">
                <a href="/tag?name=${tag.tagName}">${tag.tagName}</a>
        </c:forEach>

    </body>
</html>
