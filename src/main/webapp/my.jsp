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
    <link rel="stylesheet" type="text/css" href="style/style5.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display&display=swap" rel="stylesheet">
    <script src="js/jquery-3.6.0.js"></script>
    <script src="js/app4.js" type="text/javascript"></script>

</head>

<body>

  <h1>Welcome to Carrot, in a place where you can save your progress in learning programming. </h1>
  <%@ include file="header.jspf" %>


    <section id="current" class="sectionglobal">

        <h2>Current Status</h2>
        <section class="counters">
            <div class="container">
                <div>
                    <i class="fas fa-carrot fa-4x"></i>
                    <div class="counterFraction" data-target="${currentCarrots}">0</div>
                    <h3>Current carrots</h3>
                </div>
                <div>
                    <i class="fas fa-gamepad fa-4x"></i>
                    <div class="counterFraction" data-target="${sumOfGamesHours}">0</div>
                    <h3>Play hours</h3>
                </div>
                <div>
                    <i class="fas fa-school fa-4x"></i>
                    <div class="counterFraction" data-target="${sumOfTrainingHours}">0</div>
                    <h3>Lerning hours</h3>
                </div>
                <div>
                    <i class="fas fa-tasks fa-4x"></i>
                    <div class="counterInteger" data-target="${allSuccess}">0</div>
                    <h3>All successes</h3>
                </div>
                <div>
                    <i class="fas fa-hourglass-half fa-4x"></i>
                    <div class="counterFraction" data-target="${maxLearningHours}">0</div>
                    <h3>Max learning hours of one day</h3>
                </div>
            </div>
        </section>
    </section>
  <section id="rules" class="sectionglobal">
      <h2>Rures</h2>
      <div class="information" id="rules">
          <p>One carrot is an posibility to one hour of playing video games. You play - you eat it. In order to get some carrots, you have to work hard by learning or achieving success. You can combine each saved learning time into tags to later verify what you have learned the most and the least.</p>
          <p>Each hour of learning is only a fraction of a carrot, but you decide for yourself what can be a success and how valid it is. Completed project? CV sent? How about getting a job? After all, that's what this is about, right ;) ?</p>
      </div>
  </section>

    <section id="progress" class="sectionglobal">
        <h2>Progress</h2>
        <div class="information">
            <p>Here you can find your progress, how many carrots you have grown and how many you have eaten. Here, too, you can check the details of each of the stages you have gone through. Go ahead.</p>
        </div>

        <table class="redTable">
            <thead>
            <tr>
                <th>Number</th>
                <th>Date</th>
                <th>Upload</th>
                <th>Carrots</th>
                </tr>

            </thead>
            <tbody>
        <c:forEach items="${buffers}" var="buffer" varStatus="countStat">
                <tr class="zoominf">
                    <td>${countStat.count + (tablePage - 1) * 10}</td>
                    <td>${buffer.bufferDate}</td>
                    <td>${buffer.bufferUpload}</td>
                    <td>${buffer.bufferCarrots}</td>
                </tr>
                <tr class="hidemy hide">
                    <td colspan="4">
                        <div>${buffer.moreInformation}</div>
                    </td>
                </tr>
        </c:forEach>
            </tbody>
            <tfoot>
            <td colspan="4" class="links">
                <div>
                    <c:if test="${tablePage != 1}">
                        <a href="/?tablePage=${tablePage - 1}#progress">&laquo;</a>
                    </c:if>

                    <c:forEach begin="1" end="${totalPages}" var="pageStep">
                        <a href="/?tablePage=${pageStep}#progress" <c:if test="${pageStep == tablePage}">class="active chosen"</c:if> >${pageStep}</a>
                    </c:forEach>

                    <c:if test="${tablePage != totalPages}">
                        <a href="/?tablePage=${tablePage + 1}#progress">&raquo;</a>
                    </c:if>
                </div>
            </td>
            </tfoot>
        </table>
    </section>
    <section id="more" class="sectionglobal">
        <h2>More information</h2>
        <div class="information">
            <p>The website was created as an experimental field for learning, and by the way, it is to give the creator the opportunity to record their learning progress. Therefore, items on the page may not work perfectly with the browser and some features maybe just don't work. Please, guest, be understanding to the novice programmer.</p>
        </div>
    </section>

    <%@ include file="footer.jspf" %>

</body>

</html>