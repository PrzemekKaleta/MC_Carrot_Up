<%--
  Created by IntelliJ IDEA.
  User: przemo
  Date: 13.07.21
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Main page</title>
</head>

<body>

<%@ include file="header.jspf" %>

<h1>Welcome to Carrot</h1>

${milk}


<c:forEach items="${buffers}" var="buffer" varStatus="countStat">
    ${countStat.count}<br>
    ID: ${buffer.bufferId}
    Date: ${buffer.bufferDate}
    Upload: ${buffer.bufferUpload}
    Carrots: ${buffer.bufferCarrots} <br><br>
</c:forEach>

<%@ include file="footer.jspf" %>

</body>
</html>
