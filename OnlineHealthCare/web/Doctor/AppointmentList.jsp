<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Doctor Feedback" />
        
        <!-- Google Font -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,400;1,300&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />" />
        <link rel="stylesheet" href="<c:url value='/static/css/accountList.css' />" />
        <link rel="stylesheet" href="<c:url value='/template/admin/font-awesome/4.5.0/css/font-awesome.min.css' />" />
        <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/ace.min.css' />" 
              class="ace-main-stylesheet" id="main-ace-style" />
        <script src="<c:url value='/template/admin/assets/js/ace-extra.min.js' />"></script>
        
        <!-- Jquery -->
        <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script type='text/javascript' src='<c:url value="/template/admin/js/jquery-2.2.3.min.js" />'></script>
        <script src="<c:url value='/template/admin/assets/js/jquery.2.1.1.min.js' />"></script>
        <link rel="stylesheet" href="/code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script src="<c:url value='/ckeditor/ckeditor.js' />"></script>

        <title>Danh sách lịch hẹn</title>
    </head>
    <body class="no-skin">
        <!-- header -->
        <%@ include file="/common/header.jsp" %>
        <!-- header -->

        <div class="main-container" id="main-container">
            <script type="text/javascript">
                try {
                    ace.settings.check('main-container', 'fixed');
                } catch (e) {
                }
            </script>
            <!-- header -->
            <%@ include file="/Doctor/menu.jsp" %>
            <!-- header -->

            <div class="main-content">
                <form action="<c:url value='/doctor-patient-search'/>" method="get">
                    <div class="main-content-inner">
                        <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                            <ul class="breadcrumb">
                                <li>
                                    <i class="ace-icon fa fa-home home-icon"></i>
                                    <a href="<c:url value='/trang-chu'/>">Trang chủ</a>
                                </li>
                                <li class="active">Danh sách lịch hẹn</li>
                            </ul>
                            <!-- /.breadcrumb -->
                            <div class="nav-search" id="nav-search">
                                <form class="form-search">
                                    <span class="input-icon">
                                        <input name="NameSearch" value="${nameSearch}" type="text" 
                                               placeholder="Tìm tên, email ..." class="nav-search-input" 
                                               style="width:300px !important" id="nav-search-input" autocomplete="off" />
                                        <button type="submit" class="ace-icon fa fa-search nav-search-icon"></button>
                                    </span>
                                </form>
                            </div>
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
                                                            <th>No.</th>
                                                            <th>Họ và tên</th>
                                                            <th>Lý do khám</th>
                                                            <th>Ngày đặt lịch</th>
                                                            <th>Trạng thái</th>
                                                            <th></th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:choose>
                                                            <c:when test="${empty appoints}">
                                                            <p>Không có thông tin!</p>
                                                            </c:when>
                                                        <c:otherwise>
                                                            <c:forEach var="item" items="${appoints}" varStatus="loop">
                                                                <c:set var="count" value="${(currentPage - 1) * 4}"/>
                                                                <tr>
                                                                    <td>${loop.index + count + 1}</td>
                                                                    <td>${item.userFname} ${item.userLname}</td>
                                                                    <td>${item.reasonExamination}</td>
                                                                    <td>${item.bookingDate}</td>
                                                                    <td>${item.status}</td>
                                                                    <td>
                                                                        <c:url var="viewDetail" value="/doctor-appointment-detail">
                                                                            <c:param name="userId" value="${item.userID}"/>
                                                                            <c:param name="appointId" value="${item.appointmentId}"/>
                                                                        </c:url>
                                                                        <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                                                           title="Xem chi tiết" href="${viewDetail}">
                                                                            <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                                        </a>
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
                                                                    <a href="admin-account-search?search=${nameSearch}&page=${currentPage-1}">Trang trước</a>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <a href="admin-account?page=${currentPage-1}">Trang trước</a>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:if>
                                                        <c:forEach begin="1" end="${noOfPages}" var="i">
                                                            <c:choose>
                                                                <c:when test="${currentPage eq i}">
                                                                    <a href="" class="active">${i}</a>
                                                                </c:when>
                                                                <c:when test="${isSearching}">
                                                                    <a href="admin-account-search?search=${nameSearch}&page=${i}">${i}</a>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <a href="admin-account?page=${i}">${i}</a>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:forEach>
                                                        <c:if test="${currentPage lt noOfPages}">
                                                            <c:choose>
                                                                <c:when test="${isSearching}">
                                                                    <a href="admin-account-search?search=${nameSearch}&page=${currentPage+1}">Trang sau</a>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <a href="admin-account?page=${currentPage+1}">Trang sau</a>
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

        <!-- page specific plugin scripts -->
        <script src="<c:url value='/template/admin/assets/js/jquery-ui.min.js'/>"></script>
    </body>
</html>