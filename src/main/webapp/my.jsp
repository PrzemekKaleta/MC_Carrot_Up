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
<%--    <%@ page contentType="application/javascript; charset=UTF-8"%>--%>




<html>
<head>
    <title>My page</title>
    <%--<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">--%>


    <%--<script type="text/javascript" src="app.js"></script>--%>
    <script src="js/app.js" type="text/javascript"></script>
<%--        <jsp:include page="js/app.js">--%>

</head>

<body>


<h1>Welcome to Carrot</h1>

<h2>Current Carrots:</h2>
<table>
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






</body>

</html>