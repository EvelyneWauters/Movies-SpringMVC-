<%--
  Created by IntelliJ IDEA.
  User: jeansmits
  Date: 25/06/15
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Film by ID</title>
  <style>h1{font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
              color: darkgray;
              padding-left: 2rem;
              background: url(${film.urlImage});}
            a{border-radius: 25px;
                background: #8AC007;
                padding: 20px;
                width: 200px;
                height: 150px; }</style>
</head>
<body>


 <h1>${film.title}</h1>
  <p>id = ${film.id}</p>

<a href="/filmlist">Take me home</a>
</body>
</html>
