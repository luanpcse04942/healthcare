<%-- 
    Document   : MedicalFacilityListPublic
    Created on : Oct 9, 2022, 8:56:34 PM
    Author     : ADMIN
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Trang chủ Cơ sở Y tế </title>
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
                <a href="trang-chu">
                    <h1>
                        <i class="ace-icon fa fa-leaf green"></i>
                        HealthCare
                    </h1>
                </a>
            </div>
            <div class="navbar-pc">
                <ul class="nav-list">
                    <li class="nav-link ">
                        <a href="public-specialty-list" class="mo-cuaso" dl-cuaso="chuyenkhoa"> Chuyên khoa
                            <span>Tìm bác sĩ theo chuyên khoa</span>
                        </a>
                    </li>
                    <li class="nav-link ">
                        <a href="public-facility-list" class="mo-cuaso" dl-cuaso="cosoyte"> Cơ sở y tế
                            <span>Chọn bệnh viện phòng khám</span>
                        </a>
                    </li>
                    <li class="nav-link ">
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
            <h1>Bệnh viện, phòng khám nổi bật</h1>
            <div class="row">
                <c:forEach var="item" items="${facilities}">
                    <div class="col-md-4 mt-2">

                        <div class="card">

                            <div class="card-body">
                                <div class="card-img-actions">
                                 
                                   <img width="300px" height="200px" alt="Avatar" src="<c:url value='data:image/jpeg;charset=utf-8;base64,${item.images}' />" />

                                </div>
                            </div>

                            <div class="card-body bg-light text-center ">
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
                                <a href="facility-list-public?search=${nameSearch}&page=${currentPage-1}">Trang trước</a>
                            </c:when>
                            <c:otherwise>
                                <a href="facility-list-public?page=${currentPage-1}">Trang trước</a>
                            </c:otherwise>
                        </c:choose>
                    </c:if>
                    <c:forEach begin="1" end="${noOfPages}" var="i">
                        <c:choose>
                            <c:when test="${currentPage eq i}">
                                <a href="" class="active">${i}</a>
                            </c:when>
                            <c:when test="${isSearching}">
                                <a href="facility-list-public?search=${nameSearch}&page=${i}">${i}</a>
                            </c:when>
                            <c:otherwise>
                                <a href="facility-list-public?page=${i}">${i}</a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:if test="${currentPage lt noOfPages}">
                        <c:choose>
                            <c:when test="${isSearching}">
                                <a href="facility-list-public?search=${nameSearch}&page=${currentPage+1}">Trang sau</a>
                            </c:when>
                            <c:otherwise>
                                <a href="facility-list-public?page=${currentPage+1}">Trang sau</a>
                            </c:otherwise>
                        </c:choose>
                    </c:if>
                </div>
            </c:if>





    </body>
</html>
