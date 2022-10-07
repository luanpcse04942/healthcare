<%-- 
    Document   : DoctorListPublic
    Created on : Sep 25, 2022, 9:34:05 PM
    Author     : mikuo
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Trang chủ Bác sĩ </title>
        <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />" />
        <link rel="stylesheet" href="<c:url value='/css/admin/accountList.css' />" />
        <link rel="stylesheet" href="<c:url value='/template/admin/font-awesome/4.5.0/css/font-awesome.min.css' />" />
        <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/ace.min.css' />" class="ace-main-stylesheet" id="main-ace-style" />
        <script src="<c:url value='/template/admin/assets/js/ace-extra.min.js' />"></script>
        <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script type='text/javascript' src='<c:url value="/template/admin/js/jquery-2.2.3.min.js" />'></script>
        <script src="<c:url value='/template/admin/assets/js/jquery.2.1.1.min.js' />"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script src="<c:url value='/template/paging/jquery.twbsPagination.js' />"></script>
        <script type='text/javascript' src='<c:url value="/template/paging/jquery.twbsPagination.min" />'></script>
        <script type='text/javascript' src='<c:url value="/template/paging/jquery.twbsPagination.min.js" />'></script>
        <script src="<c:url value='/ckeditor/ckeditor.js' />"></script>
        <link rel="stylesheet" href="static/css/home.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            body {
                margin: 0;
                font-family: Roboto,-apple-system,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif,"Apple Color Emoji","Segoe UI Emoji","Segoe UI Symbol","Noto Color Emoji";
                font-size: .8125rem;
                font-weight: 400;
                line-height: 1.5385;
                color: #333;
                text-align: left;
            }

            .mt-50{

                margin-top: 50px;
            }

            .mb-50{

                margin-bottom: 50px;
            }



            .card {
                position: relative;
                display: -ms-flexbox;
                display: flex;
                -ms-flex-direction: column;
                flex-direction: column;
                min-width: 0;
                word-wrap: break-word;
                background-color: #fff;
                background-clip: border-box;
                border: 1px solid rgba(0,0,0,.125);
                border-radius: .1875rem;
            }

            .card-img-actions {
                position: relative;
            }
            .card-body {
                -ms-flex: 1 1 auto;
                flex: 1 1 auto;
                padding: 1.25rem;
                text-align: center;
            }

            .card-img{

                width: 350px;
            }

            .star{
                color: red;
            }

            .bg-cart {
                background-color:orange;
                color:#fff;
            }

            .bg-cart:hover {

                color:#fff;
            }

            .bg-buy {
                background-color:green;
                color:#fff;
                padding-right: 29px;
            }
            .bg-buy:hover {

                color:#fff;
            }

            a{

                text-decoration: none !important;
            }

        </style>
    </head>
    <body>
        <div class="top-area">
            <div class="img-area">
                <a href="#">
                    <img src="static/images/bookingcare-2020.svg" width="160" height="35"
                         alt="">
                </a>
            </div>
            <div class="navbar-pc">
                <ul class="nav-list">
                    <li class="nav-link">
                        <a href="specialty-list" class="mo-cuaso" dl-cuaso="chuyenkhoa"> Chuyên khoa
                            <span>Tìm bác sĩ theo chuyên khoa</span>
                        </a>
                    </li>
                    <li class="nav-link">
                        <a href="/#cosoyte" class="mo-cuaso" dl-cuaso="cosoyte"> Cơ sở y tế
                            <span>Chọn bệnh viện phòng khám</span>
                        </a>
                    </li>
                    <li class="nav-link">
                        <a href="doctor-list-public" class="mo-cuaso" dl-cuaso="bacsi"> Bác sĩ
                            <span>Chọn bác sĩ giỏi</span>
                        </a>
                    </li>
                </ul>

            </div>
            <div class="top-right-area">
                <div class="layout">
                    <button class="btn-login" onclick="location.href = '<c:url value="/dang-nhap"/>'">Đăng Nhập</button>
                </div>
            </div>
        </div>

        <div class="container d-flex justify-content-center mt-50 mb-50">
            <div class="search-container">
                <form id="form-search" action="<c:url value='/public-doctor-search'/>" method="POST">
                    <div class="input-group">
                        <c:if test="${codeSearch != null}">
                            <input type="text" class="form-control" name="codeSearch" value="${codeSearch}" placeholder="Tìm kiếm bác sĩ" required maxlength="50" aria-describedby="basic-addon2"/>
                        </c:if>
                        <c:if test="${codeSearch == null || codeSearch == ''}">
                            <input type="text" class="form-control" name="codeSearch" placeholder="Tìm kiếm bác sĩ" required/>
                        </c:if>
                        <span class="input-group-btn">
                            <button class="btn btn-primary" type="submit"><span class="glyphicon glyphicon-search" aria-hidden="true">
                                </span> Search!</button>
                        </span>
                    </div>
                </form>
            </div>
            <div class="row">
                <c:forEach var="item" items="${accounts}">
                    <div class="col-md-4 mt-2">


                        <div class="card">

                            <div class="card-body">
                                <div class="card-img-actions">
                                    <img src="static/images/Doctor/${item.images}" class="card-img img-fluid" width="85" height="350" alt="">
                                </div>
                            </div>

                            <div class="card-body bg-light text-center">
                                <div class="mb-2">
                                    <h6 class="font-weight-semibold mb-2">
                                        <a href="#" class="text-default mb-2" data-abc="true">${item.firstName} ${item.lastName}</a>
                                    </h6>
                                </div>
                            </div> 

                        </div> 
                    </div>
                </c:forEach>
            </div>
            <c:if test="${noOfPages > 1}">
                <div class="pagination">
                    <c:if test="${currentPage != 1}">
                        <c:choose>
                            <c:when test="${isSearching}">
                                <a href="doctor-list-public?search=${nameSearch}&page=${currentPage-1}">Trang trước</a>
                            </c:when>
                            <c:otherwise>
                                <a href="doctor-list-public?page=${currentPage-1}">Trang trước</a>
                            </c:otherwise>
                        </c:choose>
                    </c:if>
                    <c:forEach begin="1" end="${noOfPages}" var="i">
                        <c:choose>
                            <c:when test="${currentPage eq i}">
                                <a href="" class="active">${i}</a>
                            </c:when>
                            <c:when test="${isSearching}">
                                <a href="doctor-list-public?search=${nameSearch}&page=${i}">${i}</a>
                            </c:when>
                            <c:otherwise>
                                <a href="doctor-list-public?page=${i}">${i}</a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:if test="${currentPage lt noOfPages}">
                        <c:choose>
                            <c:when test="${isSearching}">
                                <a href="doctor-list-public?search=${nameSearch}&page=${currentPage+1}">Trang sau</a>
                            </c:when>
                            <c:otherwise>
                                <a href="doctor-list-public?page=${currentPage+1}">Trang sau</a>
                            </c:otherwise>
                        </c:choose>
                    </c:if>
                </div>
            </c:if>
    </body>
</html>
