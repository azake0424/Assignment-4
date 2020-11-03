<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                        <%
                        HttpSession session1 = request.getSession();
                        if (session1.getAttribute("username") != null){%>
                        <a href="<%=request.getContextPath()%>/logout" class="logoin">Logout</a>
                        <%}else{%>
                        <a href="<%=request.getContextPath()%>/login" class="logoin">Login</a>
                        <%}%>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>

<div class="logo">
    <a href="<%=request.getContextPath()%>/main"><h1>Online Library</h1></a>
</div>

<div class="header-bottom">
    <div class="container">
        <div class="header">
            <div class="col-md-9 header-left">
                <div class="top-nav">
                    <ul class="memenu skyblue">
                        <li class="menuu"><a href="<%=request.getContextPath()%>/main">Main</a></li>
                        <li class="menuu"><a href="<%=request.getContextPath()%>/profile?username=${username}">Profile</a></li>
                        <li class="menuu"><a href="<%=request.getContextPath()%>/basket?username=${username}">Basket</a></li>
                    </ul>
                </div>
                <div class="clearfix"> </div>
            </div>
            <div class="col-md-3 header-right">
                <div class="search-bar">
                    <form action="<%=request.getContextPath()%>/search" method="post">
                        <input type="text" name="search" value="" placeholder="Search">
                        <input type="submit" name="submitsrch" value="" class="search-icon">
                    </form>
                </div>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>

<div class="breadcrumbs">
    <div class="container">
        <div class="breadcrumbs-main">
            <ol class="breadcrumb">
                <li><a href="index.php">Main </a></li>
                <li class="active"> / Choose which book you need</li>
            </ol>
        </div>
    </div>
</div>

<h1>${error}</h1>

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
                                     <a href="<%=request.getContextPath()%>/add?bookid=${book.getBookId()}&username=${username}&count=${book.getCount()}">
                                         <button class="btn btn-outline-dark" type="submit" >Add to cart</button>
                                     </a>
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
                            <p>© 2020 Online Library on Kazakhstan. Design by Ali Zangar  </p>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>