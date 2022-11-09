<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />" />
        <link rel="stylesheet" href="<c:url value='/static/css/accountList.css' />" />
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
        <script src="<c:url value='/ckeditor/ckeditor.js' />"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý Cẩm nang</title>
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
    <body class="no-skin">
        <!-- header -->
        <%@ include file="/common/header.jsp" %>
        <!-- header -->

        <div class="main-container" id="main-container">
            <script type="text/javascript">
                try {
                    ace.settings.check('main-container', 'fixed')
                } catch (e) {
                }
            </script>
            <!-- header -->
            <%@ include file="/Admin/menu.jsp" %>
            <!-- header -->

            <div class="main-content">
                <form action="<c:url value='/admin-handbook-search'/>" method="get">
                    <div class="main-content-inner">
                        <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                            <ul class="breadcrumb">
                                <li>
                                    <i class="ace-icon fa fa-home home-icon"></i>
                                    <a href="<c:url value='/admin-home'/>">Trang chủ</a>
                                </li>
                                <li class="active">Danh sách cẩm nang</li>
                            </ul>
                            <!-- /.breadcrumb -->

                        </div>
                        <div class="search-container">
                            <form id="form-search" action="<c:url value='/admin-handbook-search'/>" method="POST">
                                <div class="input-group">
                                    <c:if test="${codeSearch != null}">
                                        <input type="text" class="form-control" name="codeSearch" value="${codeSearch}" placeholder="Tìm kiếm cẩm nang" required maxlength="50" aria-describedby="basic-addon2"/>
                                    </c:if>
                                    <c:if test="${codeSearch == null || codeSearch == ''}">
                                        <input type="text" class="form-control" name="codeSearch" placeholder="Tìm kiếm cẩm nang" required/>
                                    </c:if>
                                    <span class="input-group-btn">
                                        <button class="btn btn-primary" type="submit"><span class="glyphicon glyphicon-search" aria-hidden="true">
                                            </span> Search!</button>
                                    </span>
                                </div>
                            </form>
                        </div>        
                        <div class="page-content">
                            <div class="row">
                                <div class="col-xs-12">
                                    <c:if test="${not empty messageResponse}">
                                        <div class="alert alert-${alert}">
                                            ${messageResponse}
                                        </div>
                                    </c:if>
                                    <div class="widget-box table-filter">
                                        <div class="table-btn-controls">
                                            <div class="pull-right tableTools-container">
                                                <div class="dt-buttons btn-overlap btn-group">
                                                    <a flag="info"
                                                       class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
                                                       title='Thêm chuyên khoa' href='<c:url value="/admin-add-handbook"/>'>
                                                        <span>
                                                            <i class="fa fa-plus-circle bigger-110 purple"></i>
                                                        </span>
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <div class="table-responsive">
                                                <div class="row" >

                                                    <c:forEach var="item" items="${handbooks}" varStatus="loop">

                                                        <div class="col-md-4 mt-2" id="${item.id}">
                                                            <div class="card">
                                                                <div class="card-body">
                                                                    <div class="card-img-actions">
                                                                        <img alt="Avatar" src="<c:url value='data:image/jpeg;charset=utf-8;base64,${item.image}' />" class="card-img img-fluid" width="300" height="200" alt=""/>
                                                                    </div>
                                                                </div>

                                                                <div class="card-body bg-light text-center">
                                                                    <div class="mb-2">
                                                                        <h6 class="font-weight-semibold mb-2">
                                                                            <a href="<c:url value='/handbook-detail-admin?handBookId=${item.id}'/>" class="text-default mb-2" data-abc="true">${item.handbookName}</a>
                                                                        </h6>
                                                                    </div>
                                                                </div> 
                                                                <a href="<c:url value='/handbook-detail-admin?handBookId=${item.id}'/>" class="btn btn-info" role="button">Chỉnh sửa</a>
                                                                <button type="button" onclick="myFunction(${item.id})">Ẩn</button>

                                                            </div>

                                                        </div>
                                                    </c:forEach>
                                                </div>

                                                <c:if test="${noOfPages > 1}">
                                                    <div class="pagination">
                                                        <c:if test="${currentPage != 1}">
                                                            <c:choose>
                                                                <c:when test="${isSearching}">
                                                                    <a href="/healthcare/admin-handbook-search?codeSearch=${nameSearch}&page=${currentPage-1}">Trang trước</a>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <a href="/healthcare/handbook-list-admin?page=${currentPage-1}">Trang trước</a>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:if>
                                                        <c:forEach begin="1" end="${noOfPages}" var="i">
                                                            <c:choose>
                                                                <c:when test="${currentPage eq i}">
                                                                    <a href="" class="active">${i}</a>
                                                                </c:when>
                                                                <c:when test="${isSearching}">
                                                                    <a href="/healthcare/admin-handbook-search?codeSearch=${nameSearch}&page=${i}">${i}</a>

                                                                </c:when>
                                                                <c:otherwise>                                                           
                                                                    <a href="/healthcare/handbook-list-admin?page=${i}">${i}</a>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:forEach>
                                                        <c:if test="${currentPage lt noOfPages}">
                                                            <c:choose>
                                                                <c:when test="${isSearching}">
                                                                    <a href="/healthcare/admin-handbook-search?codeSearch=${nameSearch}&page=${currentPage+1}">Trang sau</a>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <a href="/healthcare/handbook-list-admin?page=${currentPage+1}">Trang sau</a>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:if>
                                                    </div>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>

            <!-- footer -->
            <%@ include file="/common/footer.jsp" %>
            <!-- footer -->

            <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse display">
                <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
            </a>
        </div>

        <script src="<c:url value='/template/admin/assets/js/bootstrap.min.js' />"></script>
        <script src="<c:url value='/template/admin/assets/js/jquery-ui.custom.min.js' />"></script>
        <script src="<c:url value='/template/admin/assets/js/jquery.ui.touch-punch.min.js' />"></script>
        <script src="<c:url value='/template/admin/assets/js/jquery.easypiechart.min.js' />"></script>
        <script src="<c:url value='/template/admin/assets/js/jquery.sparkline.min.js' />"></script>
        <script src="<c:url value='/template/admin/assets/js/jquery.flot.min.js' />"></script>
        <script src="<c:url value='/template/admin/assets/js/jquery.flot.pie.min.js' />"></script>
        <script src="<c:url value='/template/admin/assets/js/jquery.flot.resize.min.js' />"></script>
        <script src="<c:url value='/template/admin/assets/js/ace-elements.min.js' />"></script>
        <script src="<c:url value='/template/admin/assets/js/ace.min.js' />"></script>
        <script src="<c:url value='/template/admin/assets/js/bootstrap.min.js'/>"></script>
        <script>

                                                                    function myFunction(id) {
                                                                        var x = document.getElementById(id);
                                                                        if (x.style.display === "none") {
                                                                            x.style.display = "block";
                                                                        } else {
                                                                            x.style.display = "none";
                                                                        }
                                                                    }

        </script>
        <!-- page specific plugin scripts -->
        <script src="<c:url value='/template/admin/assets/js/jquery-ui.min.js'/>"></script>
    </body>
</html>