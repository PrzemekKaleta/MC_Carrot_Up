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
</head>
    <body>

        <h1>Chosen Tag Description</h1>
        <h2>${tag.tagName}</h2>
        <h2>${tag.tagDescription}</h2>


        <c:forEach var="tag" items="${tags}">
            <a href="/tag?name=${tag.tagName}">${tag.tagName}</a>
        </c:forEach>


    </body>
</html>
