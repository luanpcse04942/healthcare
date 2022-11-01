<%-- 
    Document   : BookingSchedule
    Created on : Oct 12, 2022, 8:32:35 AM
    Author     : LuanPC
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />" />
        <link rel="stylesheet" href="<c:url value='/static/css/bookingschedule.css' />" />
        <link rel="stylesheet" href="<c:url value='/template/admin/font-awesome/4.5.0/css/font-awesome.min.css' />" />
        <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/ace.min.css' />" class="ace-main-stylesheet" id="main-ace-style" />
        <script src="<c:url value='/template/admin/assets/js/ace-extra.min.js' />"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script type='text/javascript' src='<c:url value="/template/admin/js/jquery-2.2.3.min.js" />'></script>
        <script src="<c:url value='/template/admin/assets/js/jquery.2.1.1.min.js' />"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý  tài khoản</title>
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
            <%@ include file="/Medical Facility/menu.jsp" %>
            <!-- header -->

            <div class="main-content">
                <div class="main-content-inner">
                    <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                        <ul class="breadcrumb">
                            <li>
                                <i class="ace-icon fa fa-home home-icon"></i>
                                <a href="#">Trang chủ</a>
                            </li>
                            <li class="active">Danh sách bác sỹ</li>
                        </ul>
                        <!-- /.breadcrumb -->
                    </div>
                    <div class="search-container">
                        <form id="form-search" action="<c:url value='/facility-doctor-search'/>" method="POST">
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
                    <div class="page-content">
                        <div class="row">
                            <div class="col-xs-12">
                                <c:if test="${not empty messageResponse}">
                                    <div class="alert alert-${alert}">
                                        ${messageResponse}
                                    </div>
                                </c:if>
                                <div class="row">
                                    <div class="col-xs-12">
                                        <div class="table-responsive">
                                            <table class="table table-bordered">
                                                <thead>
                                                    <tr>
                                                        <th>Họ và tên</th>
                                                        <th>Email</th>
                                                        <th>Giới tính</th>
                                                        <th>Số điện thoại</th>
                                                        <th>Trạng thái</th>
                                                    </tr>
                                                </thead>
                                                <tbody>

                                                    <c:choose>
                                                        <c:when test="${empty doctor}">
                                                        <p>Không có thông tin!</p>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <c:forEach var="item" items="${doctor}" >
                                                            <tr>
                                                                <td>${item.fullname}</td>
                                                                <td>${item.email}</td>
                                                                <td>${item.gender}</td>
                                                                <td>${item.phoneNumber}</td>
                                                                <td>${item.statusName}</td>
                                                                <td>
                                                                    <a href="<c:url value='/facility-doctor-detail?id=${item.id}'/>" class="btn btn-info" role="button">Chi tiết</a>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </c:otherwise>
                                                </c:choose>
                                                </tbody>
                                            </table>
                                            <c:if test="${noOfPages > 1}">
                                                <div class="pagination">
                                                    <c:if test="${currentPage != 1}">
                                                        <c:choose>
                                                            <c:when test="${isSearching}">
                                                                <a href="facility-doctor-search?codeSearch=${nameSearch}&page=${currentPage-1}">Trang trước</a>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <a href="doctor-list-facility?page=${currentPage-1}">Trang trước</a>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </c:if>
                                                    <c:forEach begin="1" end="${noOfPages}" var="i">
                                                        <c:choose>
                                                            <c:when test="${currentPage eq i}">
                                                                <a href="" class="active">${i}</a>
                                                            </c:when>
                                                            <c:when test="${isSearching}">
                                                                <a href="facility-doctor-search?codeSearch=${nameSearch}&page=${i}">${i}</a>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <a href="doctor-list-facility?page=${i}">${i}</a>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </c:forEach>
                                                    <c:if test="${currentPage lt noOfPages}">
                                                        <c:choose>
                                                            <c:when test="${isSearching}">
                                                                <a href="facility-doctor-search?codeSearch=${nameSearch}&page=${currentPage+1}">Trang sau</a>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <a href="doctor-list-facility?page=${currentPage+1}">Trang sau</a>
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

        <!-- page specific plugin scripts -->
        <script src="<c:url value='/template/admin/assets/js/jquery-ui.min.js'/>"></script>
    </body>
</html>