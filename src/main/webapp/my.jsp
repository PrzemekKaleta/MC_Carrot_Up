<%--
  Created by IntelliJ IDEA.
  User: przemo
  Date: 18.07.21
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page isELIgnored="false" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<html>
<head>
    <title>My page</title>
    <link rel="stylesheet" type="text/css" href="style/style2.css">
    <script src="js/app2.js" type="text/javascript"></script>

</head>

<body>

<%@ include file="header.jspf" %>

<h1>Welcome to Carrot</h1>

<h2>Current Carrots:</h2>
<table class="steelBlueCols">
    <tr>
        <th>Number</th>
        <th>Date</th>
        <th>Upload</th>
        <th>Carrots</th>
<c:forEach items="${buffers}" var="buffer" varStatus="countStat">
        <tr>
            <td>${countStat.count}</td>
            <td>${buffer.bufferDate}</td>
            <td>${buffer.bufferUpload}</td>
            <td>${buffer.bufferCarrots}</td>
        </tr>
</c:forEach>
</table>




<%@ include file="footer.jspf" %>

</body>

</html>