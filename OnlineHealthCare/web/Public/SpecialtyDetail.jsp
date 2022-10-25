<%-- 
    Document   : SpecialtyDetail
    Created on : Oct 25, 2022, 7:33:37 AM
    Author     : LuanPC
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<c:url value='/static/css/specialtyDetailPublic.css' />">
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
        <title>${specName}</title>
    </head>

    <header id="dieuhuong" style="width: 100%; height: 60px;">
        <div class="vung-bao">
            <a href="<c:url value='/trang-chu'/>">
                <i class="ace-icon fa fa-arrow-left"></i>
            </a>
            <h2 style="color: #ffffff;">${specName}</h2>
        </div>
    </header>
    <body>
        <div class="container">
            <c:choose>
                <c:when test="${empty doctors}">
                    <p>Không có thông tin!</p>
                </c:when>
                <c:otherwise>
                    <c:forEach var="doctor" items="${doctors}" varStatus="loop">
                        <div class="doctor-board">
                            <div class="doctor-board-left">
                                <div class="doctor-image">
                                    <img alt="Doctor Image" style="border-radius: 50%; min-width: 80px;" width="80" height="80" src="<c:url value='data:image/jpeg;charset=utf-8;base64,${doctor.image}' />" />
                                    <span>Xem thêm</span>
                                </div>
                                <div class="doctor-info">
                                    <div class="doctor-name">${doctor.positionName} ${doctor.doctorName}</div>
                                    <div class="doctor-province">
                                        <i class="fa fa-map-marker light-orange bigger-110"></i>
                                        ${doctor.provinceName}
                                    </div>
                                </div>
                            </div>
                            <div class="doctor-board-right">
                                <span><i class="fa fa-calendar bigger-110"></i>Lịch khám</span>
                                <div class="doctor-address">
                                    
                                </div>
                                <div class="board-right-text">Chọn <i class="fa fa-hand-o-up" aria-hidden="true"></i> và đặt (Phí đặt lịch 0đ)</div>
                                <span>Địa chỉ khám</span>
                                <div class="doctor-address">
                                    ${doctor.address}
                                </div>
                                <span>Giá khám:</span>
                                ${doctor.price}
                            </div>
                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
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
