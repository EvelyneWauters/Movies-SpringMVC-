<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: jeansmits
  Date: 25/06/15
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
  <!-- Add Bootstrap! -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">

  <h2>add a movie <small>or edit an existing one</small></h2>


  <sf:form commandName="film" action="/create">

    <div class="form-group">
      <label for="title">title</label>
      <sf:input path="title" class="form-control"/>
    </div>

    <div class="form-group">
      <label for="urlImage">URL poster</label>
      <sf:input path="urlImage" class="form-control"/>
    </div>

    <sf:hidden path="id"/>

    <button type="submit" class="btn btn-success">submit</button>
  </sf:form>

</div>

</body>
</html>
