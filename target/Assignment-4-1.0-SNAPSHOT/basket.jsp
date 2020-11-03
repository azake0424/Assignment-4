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
                        <a href="main.jsp" class="logoin" ><p class="logoWeb">OLibrary</p></a>
                    </div>
                    <div class="box2">
                        <a href="<%=request.getContextPath()%>/logout" class="logoin">Logout</a>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>

<div class="logo">
    <a href="main.jsp"><h1>Online Library</h1></a>
</div>

<div class="header-bottom">
    <div class="container">
        <div class="header">
            <div class="col-md-9 header-left">
                <div class="top-nav">
                    <ul class="memenu skyblue">
                        <li class="menuu"><a href="<%=request.getContextPath()%>/main">Main</a></li>
                        <li class="menuu"><a href="profile.jsp">Profile</a></li>
                        <li class="menuu"><a href="profile.jsp">Profile</a></li>
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
                <li><a href="<%=request.getContextPath()%>/basket">Basket </a></li>
            </ol>
        </div>
    </div>
</div>
<div class="prdt">
    <div class="container">
        <div class="prdt-top">
            <div class="prdt-left">
                <div class="col-md-12 product-one">
                    <c:forEach items="${my}" var="book">
                        <div class="product-left p-left">
                            <div class="product-main simpleCart_shelfItem">
                                <div class="city"><img class="zoom-img" src="${book.getImg()}" width="150px" height="200px"/></div>
                                <div class="product-bottom">
                                    <h3>Title:${book.getTitle()}</h3>
                                    <h3>Author:${book.getAuthor()}</h3>
                                    <a href="<%=request.getContextPath()%>/deletefrombasket?username=${username}&bookid=${book.getBookId()}"><button type="submit" class="btn btn-outline-dark">delete</button></a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <!-- Modal -->
                    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                                </div>
                                <div class="modal-body">
                                    ...
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    <button type="button" class="btn btn-primary">Save changes</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <c:if test="${my == null}">
                        <h1 class="text-center border border-warning">Your Library is Empty</h1>
                    </c:if>
                    <label>
                        <input type="text" id="user" value="${username}" class="d-none">
                    </label>
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
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script>
    $('#myModal').modal(options)
    function removeBook(idd) {
        let username = $('#user').val();
        $.ajax({
            type: "DELETE",
            url: "localhost:8080/assignment_4_war/rest/orders/" + idd + "/" + username,
            success: function () {
                setDetail("Success", "The book with id=" + idd + " is back")
            },
            error: function () {
                setDetail("Error", "The book with id=" + idd + " is not back")
            }
        });
    }

</script>
</body>
</html>