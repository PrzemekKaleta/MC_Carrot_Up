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
    <script src="js/jquery-3.6.0.js"></script>
    <script src="js/app3.js" type="text/javascript"></script>

</head>

<body>

<h1>Welcome to Carrot, in a place where you can save your progress in learning programming. </h1>

<%@ include file="header.jspf" %>


<h2>Current Carrots:</h2>


<h2>Lastest progress:</h2>

<p>${buffersQuantity} buffers you have</p>

<form>
    <input type="number" min="1" max="50">
    <input type="submit" value="">
</form>
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
        <tr>

            <td>${countStat.count}</td>
            <td>${buffer.bufferDate}</td>
            <td>${buffer.bufferUpload}</td>
            <td>${buffer.bufferCarrots}</td>
        </tr>
</c:forEach>
    </tbody>
    <tfoot>
    <td colspan="4" class="links">
        <div>

            <a href="#">&laquo;</a> <a class="active" href="#">1</a>
            <a href="#">2</a> <a href="#">3</a> <a href="#">4</a>
            <a href="#">&raquo;</a>
        </div>
    </td>
    </tfoot>
</table>

<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In eu sagittis metus, sed faucibus metus. Aenean a fringilla quam, non efficitur massa. Proin interdum maximus nulla, et aliquam nibh maximus et. Phasellus id elementum lacus. Nam nec dolor vel mauris faucibus commodo eget non risus. Vestibulum malesuada vitae ex consequat aliquam. Nullam ut posuere felis. Cras malesuada faucibus lectus, ac accumsan metus viverra at. Ut congue ex vehicula sapien condimentum dictum vitae id erat. Proin ut ante tempor, posuere nunc in, efficitur metus. Morbi non neque orci. Suspendisse ullamcorper dui nec vulputate luctus. Curabitur ornare tempor consequat. Vestibulum sit amet tortor felis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae;</p>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In eu sagittis metus, sed faucibus metus. Aenean a fringilla quam, non efficitur massa. Proin interdum maximus nulla, et aliquam nibh maximus et. Phasellus id elementum lacus. Nam nec dolor vel mauris faucibus commodo eget non risus. Vestibulum malesuada vitae ex consequat aliquam. Nullam ut posuere felis. Cras malesuada faucibus lectus, ac accumsan metus viverra at. Ut congue ex vehicula sapien condimentum dictum vitae id erat. Proin ut ante tempor, posuere nunc in, efficitur metus. Morbi non neque orci. Suspendisse ullamcorper dui nec vulputate luctus. Curabitur ornare tempor consequat. Vestibulum sit amet tortor felis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae;</p>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In eu sagittis metus, sed faucibus metus. Aenean a fringilla quam, non efficitur massa. Proin interdum maximus nulla, et aliquam nibh maximus et. Phasellus id elementum lacus. Nam nec dolor vel mauris faucibus commodo eget non risus. Vestibulum malesuada vitae ex consequat aliquam. Nullam ut posuere felis. Cras malesuada faucibus lectus, ac accumsan metus viverra at. Ut congue ex vehicula sapien condimentum dictum vitae id erat. Proin ut ante tempor, posuere nunc in, efficitur metus. Morbi non neque orci. Suspendisse ullamcorper dui nec vulputate luctus. Curabitur ornare tempor consequat. Vestibulum sit amet tortor felis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae;</p>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In eu sagittis metus, sed faucibus metus. Aenean a fringilla quam, non efficitur massa. Proin interdum maximus nulla, et aliquam nibh maximus et. Phasellus id elementum lacus. Nam nec dolor vel mauris faucibus commodo eget non risus. Vestibulum malesuada vitae ex consequat aliquam. Nullam ut posuere felis. Cras malesuada faucibus lectus, ac accumsan metus viverra at. Ut congue ex vehicula sapien condimentum dictum vitae id erat. Proin ut ante tempor, posuere nunc in, efficitur metus. Morbi non neque orci. Suspendisse ullamcorper dui nec vulputate luctus. Curabitur ornare tempor consequat. Vestibulum sit amet tortor felis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae;</p>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In eu sagittis metus, sed faucibus metus. Aenean a fringilla quam, non efficitur massa. Proin interdum maximus nulla, et aliquam nibh maximus et. Phasellus id elementum lacus. Nam nec dolor vel mauris faucibus commodo eget non risus. Vestibulum malesuada vitae ex consequat aliquam. Nullam ut posuere felis. Cras malesuada faucibus lectus, ac accumsan metus viverra at. Ut congue ex vehicula sapien condimentum dictum vitae id erat. Proin ut ante tempor, posuere nunc in, efficitur metus. Morbi non neque orci. Suspendisse ullamcorper dui nec vulputate luctus. Curabitur ornare tempor consequat. Vestibulum sit amet tortor felis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae;</p>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In eu sagittis metus, sed faucibus metus. Aenean a fringilla quam, non efficitur massa. Proin interdum maximus nulla, et aliquam nibh maximus et. Phasellus id elementum lacus. Nam nec dolor vel mauris faucibus commodo eget non risus. Vestibulum malesuada vitae ex consequat aliquam. Nullam ut posuere felis. Cras malesuada faucibus lectus, ac accumsan metus viverra at. Ut congue ex vehicula sapien condimentum dictum vitae id erat. Proin ut ante tempor, posuere nunc in, efficitur metus. Morbi non neque orci. Suspendisse ullamcorper dui nec vulputate luctus. Curabitur ornare tempor consequat. Vestibulum sit amet tortor felis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae;</p>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In eu sagittis metus, sed faucibus metus. Aenean a fringilla quam, non efficitur massa. Proin interdum maximus nulla, et aliquam nibh maximus et. Phasellus id elementum lacus. Nam nec dolor vel mauris faucibus commodo eget non risus. Vestibulum malesuada vitae ex consequat aliquam. Nullam ut posuere felis. Cras malesuada faucibus lectus, ac accumsan metus viverra at. Ut congue ex vehicula sapien condimentum dictum vitae id erat. Proin ut ante tempor, posuere nunc in, efficitur metus. Morbi non neque orci. Suspendisse ullamcorper dui nec vulputate luctus. Curabitur ornare tempor consequat. Vestibulum sit amet tortor felis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae;</p>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In eu sagittis metus, sed faucibus metus. Aenean a fringilla quam, non efficitur massa. Proin interdum maximus nulla, et aliquam nibh maximus et. Phasellus id elementum lacus. Nam nec dolor vel mauris faucibus commodo eget non risus. Vestibulum malesuada vitae ex consequat aliquam. Nullam ut posuere felis. Cras malesuada faucibus lectus, ac accumsan metus viverra at. Ut congue ex vehicula sapien condimentum dictum vitae id erat. Proin ut ante tempor, posuere nunc in, efficitur metus. Morbi non neque orci. Suspendisse ullamcorper dui nec vulputate luctus. Curabitur ornare tempor consequat. Vestibulum sit amet tortor felis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae;</p>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In eu sagittis metus, sed faucibus metus. Aenean a fringilla quam, non efficitur massa. Proin interdum maximus nulla, et aliquam nibh maximus et. Phasellus id elementum lacus. Nam nec dolor vel mauris faucibus commodo eget non risus. Vestibulum malesuada vitae ex consequat aliquam. Nullam ut posuere felis. Cras malesuada faucibus lectus, ac accumsan metus viverra at. Ut congue ex vehicula sapien condimentum dictum vitae id erat. Proin ut ante tempor, posuere nunc in, efficitur metus. Morbi non neque orci. Suspendisse ullamcorper dui nec vulputate luctus. Curabitur ornare tempor consequat. Vestibulum sit amet tortor felis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae;</p>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In eu sagittis metus, sed faucibus metus. Aenean a fringilla quam, non efficitur massa. Proin interdum maximus nulla, et aliquam nibh maximus et. Phasellus id elementum lacus. Nam nec dolor vel mauris faucibus commodo eget non risus. Vestibulum malesuada vitae ex consequat aliquam. Nullam ut posuere felis. Cras malesuada faucibus lectus, ac accumsan metus viverra at. Ut congue ex vehicula sapien condimentum dictum vitae id erat. Proin ut ante tempor, posuere nunc in, efficitur metus. Morbi non neque orci. Suspendisse ullamcorper dui nec vulputate luctus. Curabitur ornare tempor consequat. Vestibulum sit amet tortor felis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae;</p>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In eu sagittis metus, sed faucibus metus. Aenean a fringilla quam, non efficitur massa. Proin interdum maximus nulla, et aliquam nibh maximus et. Phasellus id elementum lacus. Nam nec dolor vel mauris faucibus commodo eget non risus. Vestibulum malesuada vitae ex consequat aliquam. Nullam ut posuere felis. Cras malesuada faucibus lectus, ac accumsan metus viverra at. Ut congue ex vehicula sapien condimentum dictum vitae id erat. Proin ut ante tempor, posuere nunc in, efficitur metus. Morbi non neque orci. Suspendisse ullamcorper dui nec vulputate luctus. Curabitur ornare tempor consequat. Vestibulum sit amet tortor felis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae;</p>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In eu sagittis metus, sed faucibus metus. Aenean a fringilla quam, non efficitur massa. Proin interdum maximus nulla, et aliquam nibh maximus et. Phasellus id elementum lacus. Nam nec dolor vel mauris faucibus commodo eget non risus. Vestibulum malesuada vitae ex consequat aliquam. Nullam ut posuere felis. Cras malesuada faucibus lectus, ac accumsan metus viverra at. Ut congue ex vehicula sapien condimentum dictum vitae id erat. Proin ut ante tempor, posuere nunc in, efficitur metus. Morbi non neque orci. Suspendisse ullamcorper dui nec vulputate luctus. Curabitur ornare tempor consequat. Vestibulum sit amet tortor felis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae;</p>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In eu sagittis metus, sed faucibus metus. Aenean a fringilla quam, non efficitur massa. Proin interdum maximus nulla, et aliquam nibh maximus et. Phasellus id elementum lacus. Nam nec dolor vel mauris faucibus commodo eget non risus. Vestibulum malesuada vitae ex consequat aliquam. Nullam ut posuere felis. Cras malesuada faucibus lectus, ac accumsan metus viverra at. Ut congue ex vehicula sapien condimentum dictum vitae id erat. Proin ut ante tempor, posuere nunc in, efficitur metus. Morbi non neque orci. Suspendisse ullamcorper dui nec vulputate luctus. Curabitur ornare tempor consequat. Vestibulum sit amet tortor felis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae;</p>

<%@ include file="footer.jspf" %>

</body>

</html>