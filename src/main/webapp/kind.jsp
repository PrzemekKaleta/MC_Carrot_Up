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
</head>
<body>

<%@ include file="header.jspf" %>

<c:if test="${not empty kind}">

<h1>Here are parameters of choosen Kind</h1>
<h2>${kind.kindName}</h2>
    <h3>${kind.kindDescription}</h3>
    <h3>${kind.kindRatio}</h3>
    <h3>This kind of success was achieve ${count} times.</h3>
    <h3>This one succes is equals ${proportion} hours of learning.</h3>

</c:if>

<h1>Here you can see all kinds of success</h1>

<c:forEach var="kind" items="${kinds}">
    <a href="/kind?name=${kind.kindName}">${kind.kindRatio} : ${kind.kindName}</a><br>
</c:forEach>


<%@ include file="footer.jspf" %>

</body>
</html>
