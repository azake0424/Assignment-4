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
                        <li class="menuu"><a href="<%=request.getContextPath()%>/list">List of Users</a></li>
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

<div class="prdt">
    <div class="container">
        <div class="prdt-top">
            <div class="prdt-left">
                <div class="col-md-12 product-one">
                    <c:forEach items="${books}" var="book">
                        <div class="product-left p-left">
                            <div class="product-main simpleCart_shelfItem">
                                <div class="city"><img class="zoom-img" src="${book.getImg()}" width="150px" height="200px"/></div>
                                <div class="product-bottom">
                                    <h3>Title:${book.getTitle()}</h3>
                                    <h3>Author:${book.getAuthor()}</h3>
                                    <h3>Count:${book.getCount()}</h3>
                                    <a href='<%=request.getContextPath()+"/update?id="%>${book.getBookId()}'>
                                        <button class="btn btn-outline-dark" type="submit" >Update</button></a>
                                    <a href="<%=request.getContextPath()%>/delete?title=${book.getTitle()}">
                                        <button class="btn btn-outline-dark" type="submit" >Delete</button></a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <div class="clearfix"></div>
                </div>
            </div>
            <hr>

            <div class="footer">
                <div class="container">
                    <div class="footer-top">
                        <div class="col-md-6 footer-centre">
                            <p>© 2020 University in Kazakhstan. Design by Ali Zangar  </p>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $('#myModal').modal(options)
    function deleteProduct(idd) {
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/assignment3_war/orderremove",
            data: {
                reqValue: idd
            },
            cache: false,
            timeout: 600000,
            success: function (data) {
                setDetail("Success", "The book with id=" + idd + " is removed")
                removeView(idd);
            },
            error: function (response, error, errorThrown) {
                setDetail("Success", "The book with id=" + idd + " is not removed")
            }
        });
    }
    function setDetail(status, message) {
        $('#exampleModalLabel').text(status);
        $('.modal-body ').text(message);
    }
    function removeView(idd){
        $('div#'+idd).addClass("d-none");
    }
</script>
</body>
</html>
