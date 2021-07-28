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
    <title>Success add page</title>
</head>
<body>

<%@ include file="header.jspf" %>

<h1>Here you can add some success to increase carrot level</h1>

<p>Current carrots: ${carrots}</p>
<form action="/success-add" method="post">
    <label>Choose kind of success:<br>
        <c:forEach items="${kinds}" var="kind" varStatus="count">
            <input type="radio" name="chosenKind" value="${kind.kindId}"><a href="/kind?name=${kind.kindName}">${kind.kindRatio} : ${kind.kindName}</a><c:if test="${count.count%5==0}"><br></c:if>
        </c:forEach>
    </label><br><br>
    <label>Choose day of success:<br>
        <input type="date" name="date" value="${currentDate}" max="${currentDate}">
    </label><br><br>
    <label>Describe this success:<br>
        <textarea name="description" cols="30" rows="3"></textarea>
    </label><br><br>
    <input type="submit" value="Add success"><br><br>
</form>

<%@ include file="footer.jspf" %>

</body>
</html>
