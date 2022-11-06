<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Danh sách lịch hẹn</title>
        <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />" />
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

        <script src="<c:url value='/ckeditor/ckeditor.js' />"></script>
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
            <%@ include file="/Patient/menu.jsp" %>
            <!-- header -->

            <div class="main-content">
                <form action="<c:url value='/Patient-Appointment-search'/>" method="get">
                    <div class="main-content-inner">
                        <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                            <ul class="breadcrumb">
                                <li>
                                    <i class="ace-icon fa fa-home home-icon"></i>
                                    <a href="<c:url value='/appointment-patient-home'/>">Trang chủ</a>
                                </li>
                                <li class="active">Danh sách lịch hẹn</li>
                            </ul>
                            <!-- /.breadcrumb -->
                        </div>
                        <div class="search-container">
                        <form id="form-search" action="<c:url value='/Patient-Appointment-search'/>" method="POST">
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
                                                            <th>No.</th>
                                                            <th>Bác Sĩ</th>
                                                            <th>Lý do khám</th>
                                                            <th>Địa chỉ</th>
                                                            <th>Ngày đặt lịch</th>
                                                            <th>Trạng thái</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>

                                                        <c:choose>
                                                            <c:when test="${empty appointment}">
                                                            <p>Không có thông tin!</p>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <c:forEach var="item" items="${appointment}" varStatus="loop">
                                                                <c:set var="count" value="${(currentPage - 1) * 2}"/>
                                                                <tr>
                                                                    <td>${loop.index + count + 1}</td>
                                                                    <td>${item.fullName}</td>
                                                                    <td>${item.reason}</td>
                                                                    <td>${item.address}</td>
                                                                    <td>${item.bookingDate}</td>
                                                                    <td>${item.status}</td>
                                                                    <td>
                                                                        <button type = "button" class = "btn btn-secondary" >Chi tiết </button>
                                                                    </td>
                                                                    <c:choose>
                                                                        <c:when test="${item.status eq 'Đã xác nhận'}">
                                                                            <td>
                                                                                <button type = "button" class = "btn btn-secondary" >Hủy hẹn </button>
                                                                            </td> 
                                                                        </c:when>
                                                                        <c:when test="${item.status eq 'Đã khám xong'}">
                                                                            <td>
                                                                                <button type = "button" class = "btn btn-secondary" >Phản hồi </button>
                                                                            </td> 
                                                                        </c:when>
                                                                        <c:when test="${item.status eq 'Lịch hẹn mới'}">
                                                                            <td>
                                                                                <button type = "button" class = "btn btn-secondary" >Hủy hẹn </button>
                                                                            </td> 
                                                                        </c:when>
                                                                    </c:choose>
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
                                                                    <a href="Patient-Appointment-search?codeSearch=${nameSearch}&page=${currentPage-1}">Trang trước</a>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <a href="Patient-Appointment-List?page=${currentPage-1}">Trang trước</a>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:if>
                                                        <c:forEach begin="1" end="${noOfPages}" var="i">
                                                            <c:choose>
                                                                <c:when test="${currentPage eq i}">
                                                                    <a href="" class="active">${i}</a>
                                                                </c:when>
                                                                <c:when test="${isSearching}">
                                                                    <a href="Patient-Appointment-search?codeSearch=${nameSearch}&page=${i}">${i}</a>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <a href="Patient-Appointment-List?page=${i}">${i}</a>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:forEach>
                                                        <c:if test="${currentPage lt noOfPages}">
                                                            <c:choose>
                                                                <c:when test="${isSearching}">
                                                                    <a href="Patient-Appointment-search?codeSearch=${nameSearch}&page=${currentPage+1}">Trang sau</a>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <a href="Patient-Appointment-List?page=${currentPage+1}">Trang sau</a>
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