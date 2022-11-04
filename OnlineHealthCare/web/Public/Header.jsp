
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
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
        .gallery-wrap .img-big-wrap img {
            height: 450px;
            width: auto;
            display: inline-block;
            cursor: zoom-in;
        }


        .gallery-wrap .img-small-wrap .item-gallery {
            width: 60px;
            height: 60px;
            border: 1px solid #ddd;
            margin: 7px 2px;
            display: inline-block;
            overflow: hidden;
        }

        .gallery-wrap .img-small-wrap {
            text-align: center;
        }
        .gallery-wrap .img-small-wrap img {
            max-width: 100%;
            max-height: 100%;
            object-fit: cover;
            border-radius: 4px;
            cursor: zoom-in;
        }
        .img-big-wrap img{
            width: 100% !important;
            height: auto !important;
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
                    <a href="public-handbook-list" class="mo-cuaso" dl-cuaso="chuyenkhoa"> Cẩm nang
                        <span>Thông tin hữu tích</span>
                    </a>
                </li>
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
</body>
</html>