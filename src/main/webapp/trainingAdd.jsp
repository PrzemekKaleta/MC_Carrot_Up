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
    <title>Page to add training</title>
</head>
<body>

<%@ include file="header.jspf"%>

<h2>Last training <c:if test="${duration == 0}"> was today.</c:if>
    <c:if test="${duration == 1}"> was yesterday.</c:if>
    <c:if test="${duration > 1}"> was ${duration} days ago.</c:if>

</h2>
<p>Date: ${trainingDate}</p>
<p>Hours: ${trainingHours}</p>
<p>Description: ${trainingDescription}</p>


<form action="/trainingAdd" method="post">
    <legend><h2>Add new Training</h2></legend>

    <label>Write hours of training:<br>
        <input type="number" step="0.25" name="hours" min="0.25" max="18.00" value="1.0">
    </label><br><br>
    <label>Choose day of training:<br>
        <input type="date" name="date" value="${currentDate}" max="${currentDate}">
    </label><br><br>
    <label>Describe training:<br>
        <textarea name="description" cols="30" rows="3"></textarea>
    </label><br><br>
    <label>Chose tags suitable to training:<br>

        <c:forEach items="${tags}" var="tag" varStatus="count">
            <input type="checkbox" name="chosenTags" value="${tag.tagId}"><a href="/tag?name=${tag.tagName}">${tag.tagName}</a><c:if test="${count.count%5==0}"><br></c:if>
        </c:forEach>

    </label><br><br>
    <input type="submit" value="Add training"><br><br>


</form>


<%@ include file="footer.jspf"%>

</body>
</html>
