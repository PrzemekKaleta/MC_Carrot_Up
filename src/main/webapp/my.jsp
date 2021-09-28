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

<h2>Current Status:</h2>

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

<h2>Progress:</h2>

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
                <a href="/?tablePage=${tablePage - 1}">&laquo;</a>
            </c:if>

            <c:forEach begin="1" end="${totalPages}" var="pageStep">
                <a href="/?tablePage=${pageStep}" <c:if test="${pageStep == tablePage}">class="active chosen"</c:if> >${pageStep}</a>
            </c:forEach>

            <c:if test="${tablePage != totalPages}">
                <a href="/?tablePage=${tablePage + 1}">&raquo;</a>
            </c:if>
        </div>
    </td>
    </tfoot>
</table>

<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In eu sagittis metus, sed faucibus metus. Aenean a fringilla quam, non efficitur massa. Proin interdum maximus nulla, et aliquam nibh maximus et. Phasellus id elementum lacus. Nam nec dolor vel mauris faucibus commodo eget non risus. Vestibulum malesuada vitae ex consequat aliquam. Nullam ut posuere felis. Cras malesuada faucibus lectus, ac accumsan metus viverra at. Ut congue ex vehicula sapien condimentum dictum vitae id erat. Proin ut ante tempor, posuere nunc in, efficitur metus. Morbi non neque orci. Suspendisse ullamcorper dui nec vulputate luctus. Curabitur ornare tempor consequat. Vestibulum sit amet tortor felis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae;</p>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In eu sagittis metus, sed faucibus metus. Aenean a fringilla quam, non efficitur massa. Proin interdum maximus nulla, et aliquam nibh maximus et. Phasellus id elementum lacus. Nam nec dolor vel mauris faucibus commodo eget non risus. Vestibulum malesuada vitae ex consequat aliquam. Nullam ut posuere felis. Cras malesuada faucibus lectus, ac accumsan metus viverra at. Ut congue ex vehicula sapien condimentum dictum vitae id erat. Proin ut ante tempor, posuere nunc in, efficitur metus. Morbi non neque orci. Suspendisse ullamcorper dui nec vulputate luctus. Curabitur ornare tempor consequat. Vestibulum sit amet tortor felis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae;</p>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In eu sagittis metus, sed faucibus metus. Aenean a fringilla quam, non efficitur massa. Proin interdum maximus nulla, et aliquam nibh maximus et. Phasellus id elementum lacus. Nam nec dolor vel mauris faucibus commodo eget non risus. Vestibulum malesuada vitae ex consequat aliquam. Nullam ut posuere felis. Cras malesuada faucibus lectus, ac accumsan metus viverra at. Ut congue ex vehicula sapien condimentum dictum vitae id erat. Proin ut ante tempor, posuere nunc in, efficitur metus. Morbi non neque orci. Suspendisse ullamcorper dui nec vulputate luctus. Curabitur ornare tempor consequat. Vestibulum sit amet tortor felis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae;</p>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In eu sagittis metus, sed faucibus metus. Aenean a fringilla quam, non efficitur massa. Proin interdum maximus nulla, et aliquam nibh maximus et. Phasellus id elementum lacus. Nam nec dolor vel mauris faucibus commodo eget non risus. Vestibulum malesuada vitae ex consequat aliquam. Nullam ut posuere felis. Cras malesuada faucibus lectus, ac accumsan metus viverra at. Ut congue ex vehicula sapien condimentum dictum vitae id erat. Proin ut ante tempor, posuere nunc in, efficitur metus. Morbi non neque orci. Suspendisse ullamcorper dui nec vulputate luctus. Curabitur ornare tempor consequat. Vestibulum sit amet tortor felis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae;</p>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In eu sagittis metus, sed faucibus metus. Aenean a fringilla quam, non efficitur massa. Proin interdum maximus nulla, et aliquam nibh maximus et. Phasellus id elementum lacus. Nam nec dolor vel mauris faucibus commodo eget non risus. Vestibulum malesuada vitae ex consequat aliquam. Nullam ut posuere felis. Cras malesuada faucibus lectus, ac accumsan metus viverra at. Ut congue ex vehicula sapien condimentum dictum vitae id erat. Proin ut ante tempor, posuere nunc in, efficitur metus. Morbi non neque orci. Suspendisse ullamcorper dui nec vulputate luctus. Curabitur ornare tempor consequat. Vestibulum sit amet tortor felis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae;</p>


<%@ include file="footer.jspf" %>

</body>

</html>