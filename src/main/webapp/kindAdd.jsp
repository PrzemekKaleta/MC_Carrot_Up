<%--
  Created by IntelliJ IDEA.
  User: przemo
  Date: 26.07.21
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Kind Success ADD</title>
</head>
<body>

  <%@ include file="header.jspf" %>

  <h1>Here you can add new KIND of success</h1>
  <form action="/kind-add" method="post">
      <legend>Please add new success type(kind):</legend>
      <label>Kind name:<br>
          <input type="text" name="name">
      </label><br>
      <label>Kind description:<br>
          <textarea name="description" cols="30" rows="3"></textarea>
      </label><br>
      <label>Kind ratio:<br>
        <input type="number" step="0.01" min="0.01" max="100" value="1.0" name="ratio">
      </label>
      <input type="submit" value="Create">
  </form>

  <c:forEach var="kind" items="${kinds}">
    <a href="/kind?name=${kind.kindName}">${kind.kindRatio} : ${kind.kindName}</a><br>
  </c:forEach>


  <%@ include file="footer.jspf" %>

</body>
</html>
