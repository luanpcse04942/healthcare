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
                <style>
            .row {
                display: flex;
            }

            /* Create two equal columns that sits next to each other */
            .column {

                flex: 50%;
                padding: 10px;
                /* Should be removed. Only for demonstration */
            }
            #borderDiv{
                border: 2px solid;
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
                            <li>
                                <a href="<c:url value='/doctor-list-facility'/>">Danh sách bác sỹ</a>
                            </li>
                            <li class="active">Chi tiết bác sỹ</li>
                        </ul>
                        <!-- /.breadcrumb -->
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


                                        <h2 class="modal-title">Thông tin tài khoản</h2>

                                        <hr class="line-full">
                                        <div class="row">
                                            <div class="column">
                                                <div class="form-group col-sm-12">
                                                    <span class="profile-picture">
                                                        <img alt="Avatar" src="<c:url value='data:image/jpeg;charset=utf-8;base64,${doctors.image}' />" />
                                                    </span>
                                                </div>
                                            </div>
                                            <div class="column">
                                                <div class="form-group col-sm-12">
                                                    <label>Họ và tên: </label>
                                                    <input id="name" name="name" type="text" value="${doctors.fullname}" class="form-control" disabled>
                                                </div>
                                                <div class="form-group col-sm-12">
                                                    <label>Chuyên khoa: </label>
                                                    <input id="name" name="name" type="text" value="${doctors.specName}" class="form-control" disabled>
                                                </div>

                                            </div>
                                        </div>
                                        <div class="top-modal" style="background-color: gainsboro;">
                                            <h2 class="modal-title">Thông tin khác</h2>
                                        </div>
                                        <div class="row">
                                            <div class="column">
                                                <div class="form-group col-sm-12">
                                                    <label>Giới tính: </label>
                                                    <input id="name" name="name" type="text" value="${doctors.gender}" class="form-control" disabled>
                                                </div>
                                                <div class="form-group col-sm-12">
                                                    <label>Email: </label>
                                                    <input id="name" name="name" type="text" value="${doctors.email}" class="form-control" disabled>
                                                </div>
                                                <div class="form-group col-sm-12">
                                                    <label>Số điện thoại: </label>
                                                    <input id="name" name="name" type="text" value="${doctors.phoneNumber}" class="form-control" disabled>
                                                </div>
                                            </div>
                                            <div class="column">
                                                <div class="form-group col-sm-12">
                                                    <label>Trạng thái: </label>
                                                    <input id="name" name="name" type="text" value="${doctors.statusName}" class="form-control" disabled>
                                                </div>
                                                <div class="form-group col-sm-12">
                                                    <label>Địa chỉ: </label>
                                                    <input id="name" name="name" type="text" value="${doctors.address}" class="form-control" disabled>
                                                </div>
                                            </div>
                                        </div>
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