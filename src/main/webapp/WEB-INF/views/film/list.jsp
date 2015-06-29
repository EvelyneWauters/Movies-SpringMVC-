<%--
  Created by IntelliJ IDEA.
  User: jeansmits
  Date: 25/06/15
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Movie list</title>

  <!-- Add Bootstrap! -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>


<body>
<div class="container">
  <h1>Film table</h1>
  <c:choose>
    <c:when test="${film == null or empty film}">
    <p>No films found :-(</p>
      </c:when>
      <c:otherwise>

    <table class="table table-hover">
    <tr>
    <th>id</th>
    <th>title</th>
    </tr>

    <c:forEach var="film" items="${film}">
      <tr>
        <td>${film.id}</td>
        <td>${film.title}</td>
      </tr>
    </c:forEach>
    </table>
      </c:otherwise>
  </c:choose>

  <a href="/hello" class="btn btn-primary">Take me all the way home</a>
  <a href="/form" class="btn btn-default">Add a film</a>
</div>
</body>
</html>
