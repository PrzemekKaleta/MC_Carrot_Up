<%--
  Created by IntelliJ IDEA.
  User: przemo
  Date: 16.07.21
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Tool buffer add</title>
</head>
<body>
<%@ include file="header.jspf" %>

<form action="/buffer-add" method="post">
    <legend>Please add buffer by this tool:</legend>
    <label>Add date:
        <input type="date" name="bufferDate" value=${currentDate}>
    </label>
    <label>Add upload:
        <input type="number" step="0.01" name="bufferUpload" value="0.1">
    </label>
    <label>Add buffer:
        <input type="number" step="0.01" name="bufferCarrot" value="1">
    </label>
        <input type="submit" value="Save buffer">



</form>

<%@ include file="footer.jspf" %>
</body>
</html>