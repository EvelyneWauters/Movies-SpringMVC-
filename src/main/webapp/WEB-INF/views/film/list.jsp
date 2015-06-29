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
    <title>Films</title>
    <style>a{border-radius: 25px;
        background: #8AC007;
        padding: 20px;
        width: 200px;
        height: 150px; }</style>
</head>


<body>
  <h1>Film table</h1>
  <c:choose>
    <c:when test="${film == null or empty film}">
    <p>No films found :-(</p>
      </c:when>
      <c:otherwise>

    <table>
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

  <a href="/hello">Take me all the way home</a>
  <a href="/form">Add a film</a>

</body>
</html>
