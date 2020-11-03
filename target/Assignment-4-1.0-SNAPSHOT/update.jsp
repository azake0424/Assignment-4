<%--
  Created by IntelliJ IDEA.
  User: Zangar
  Date: 02.11.2020
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="css/main.css"/>
    <link rel="stylesheet" href="css/index.css">
</head>
<body>
<c:if test="${book!=null}">
    <c:set value="${book}" var="books" />
</c:if>
<div class="container">
    <form method="post" action="<%=request.getContextPath()%>/update">
        <div class="form-group">
            <input type="text" class="form-control"  name="title" placeholder="Title" value="${books.getTitle()}">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="author" placeholder="Author" value="${books.getAuthor()}">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="isbn" placeholder="Isbn" value="${books.getIsbn()}">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="count" placeholder="Count" value="${books.getCount()}">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="image" placeholder="image" value="${books.getImg()}">
        </div>
        <button type="submit" class="btn btn-outline-dark">Submit</button>
    </form>
</div>
</body>
</html>
