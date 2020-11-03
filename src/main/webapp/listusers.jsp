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
                        <a href="<%=request.getContextPath()%>/main">Logout</a>
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
                        <li class="menuu"><a href="listusers.jsp">List of Users</a></li>
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
                <li><a href="">List of Users</a></li>
            </ol>
        </div>
    </div>
</div>


<div class="container" style="margin-top: 40px">
    <div class="row">
        <c:forEach items="${users}" var="user">
        <form method="post" action="<%=request.getContextPath()%>/updateuser">
            <div class="col-sm">
                <div class="form-group">
                    <input type="text" class="form-control"  name="id" value="${user.getId()}">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control"  name="name" value="${user.getName()}">
                </div>
                <div class="form-group">
                    <input type="email" class="form-control" name="email" value="${user.getEmail()}">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="username" value="${user.getUsername()}">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="password" value="${user.getPassword()}">
                </div>
                <button type="submit" class="btn btn-outline-dark">Update</button>
            </div>
        </form>
        </c:forEach>
    </div>
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
