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
    <link rel="stylesheet" type="text/css" href="style/style5.css">
    <script src="js/jquery-3.6.0.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display&display=swap" rel="stylesheet">
    <script src="js/app4.js" type="text/javascript"></script>
</head>
<body>

  <h1>Here you can add new KIND of success. Choose how valuable it will be.</h1>
  <%@ include file="header.jspf" %>

  <section>
      <div class="information">
          <h2>Please add new success type (kind):</h2>
      </div>
  </section>

  <form id="addKind" action="/kind-add" method="post" class="form-box">

      <div class="form-title">Write kind name:</div>
      <label>
          <input type="text" name="name">
          <div class="watchOut"><c:if test="${kindExist}">This name already exist, use other name for this success.</c:if></div>
      </label>
      <div class="form-title">Write kind description:</div>
      <label>
          <textarea name="description" cols="30" rows="3"></textarea>
      </label>
      <div class="form-title">Write kind ratio (carrots for one success of this kind):</div>
      <label>
        <input type="number" step="0.01" min="0.01" max="100" value="1.0" name="ratio">
      </label>
      <input type="submit" value="Create">
  </form>

  <section>
      <div class="information">
          <h2>Here are all kinds of success:</h2>
      </div>
  </section>
  <section id="tagKind">
    <div class="tag-box">
        <c:forEach var="kind" items="${kinds}">
            <div>
            <a class="tag-box" href="/kind?name=${kind.kindName}">${kind.kindRatio} : ${kind.kindName}</a>
            </div>
        </c:forEach>
    </div>
  </section>

  <%@ include file="footer.jspf" %>

</body>
</html>
