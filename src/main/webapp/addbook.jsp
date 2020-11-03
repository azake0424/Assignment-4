<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <title>Main</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="css/main.css"/>
    <link rel="stylesheet" href="css/index.css">
</head>
<body>
<div class="top-header">
    <div class="container">
        <div class="top-header-main">
            <div class="col-md-6 top-header-left">
                <div class="drop">
                    <div class="box">
                        <a href="<%=request.getContextPath()%>/main" class="logoin" ><p class="logoWeb">OLibrary</p></a>
                    </div>
                    <div class="box2">
                        <a href="">Logout</a>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<div class="header-bottom">
    <div class="container">
        <div class="header">
            <div class="col-md-9 header-left">
                <div class="top-nav">
                    <ul class="memenu skyblue">
                        <li class="menuu"><a href="<%=request.getContextPath()%>/admin">Main</a></li>
                        <li class="menuu"><a href="addbook.jsp">Add Book</a></li>
                        <li class="menuu"><a href="adduser.jsp">Add User</a></li>
                    </ul>
                </div>
                <div class="clearfix"> </div>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>
<div class="breadcrumbs">
    <div class="container">
        <div class="breadcrumbs-main">
            <ol class="breadcrumb">
                <li><a href="">Administration</a></li>
            </ol>
        </div>
    </div>
</div>
<div class="container">
    <form method="post" action="<%=request.getContextPath()%>/addbook">
        <div class="form-group">
            <input type="text" class="form-control"  name="title" placeholder="Title">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="author" placeholder="Author">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="isbn" placeholder="Isbn">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="count" placeholder="Count">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="img" placeholder="Image">
        </div>
        <button type="submit" class="btn btn-outline-dark">Submit</button>
    </form>
</div>

            <hr>

            <div class="footer">
                <div class="container">
                    <div class="footer-top">
                        <div class="col-md-6 footer-centre">
                            <p>© 2020 Online Library on Kazakhstan. Design by Ali Zangar  </p>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
</body>
</html>
