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
    <script src="js/app.js" type="text/javascript"></script>
</head>
    <body>

    <%@ include file="header.jspf" %>

    <c:if test="${not empty tag.tagName}">

    <h1>Chosen Tag Description</h1>
        <h2>${tag.tagName}</h2>
        <h3>${tag.tagDescription}</h3>
        <h3>This tag was use ${count} times.</h3>
        <c:if test="${tag.tagActive == true}">ACTIVE</c:if>
        <c:if test="${tag.tagActive != true}">NON ACTIVE</c:if>

        <button value="Change activity"><a href="/tag?name=${tag.tagName}&change=true">Change</a></button>

    </c:if>


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
