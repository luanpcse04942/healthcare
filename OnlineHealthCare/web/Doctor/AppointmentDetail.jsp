<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
    <head>
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
        <script src="<c:url value='/ckeditor/ckeditor.js' />"></script>
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
            <%@ include file="/Doctor/menu.jsp" %>
            <!-- header -->

            <div class="main-content">
                <form action="<c:url value='/admin-account'/>" id="formSubmit" method="get">
                    <div class="main-content-inner">
                        <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                            <ul class="breadcrumb">
                                <li>
                                    <i class="ace-icon fa fa-home home-icon"></i>
                                    <a href="<c:url value='/trang-chu'/>">Trang chủ</a>
                                </li>
                                <li>
                                    <a href="<c:url value='/doctor-patient-list'/>">Danh sách lịch hẹn</a>
                                </li>
                                <li class="active">Chi tiết lịch hẹn</li>
                            </ul>
                            <!-- /.breadcrumb -->
                        </div>

                        <div class="tab-content no-border padding-24">
                            <div id="home" class="tab-pane in active">
                                <div class="row">
                                    <h1 class="h1 blue" style="margin: 0 0 1rem 0">Thông tin bệnh nhân</h1>
                                </div>
                                <div class="row">
                                    <div class="col-xs-12 col-sm-3 center">
                                        <span class="profile-picture">
                                            <img class="editable img-responsive" alt="Alex's Avatar" id="avatar2" src="template/admin/assets/avatars/profile-pic.jpg" />
                                        </span>
                                    </div><!-- /.col -->
                                    
                                    <div class="col-xs-12 col-sm-9">

                                        <h4 class="blue">
                                            <span class="middle">${account.firstName} ${account.lastName}</span>

                                            <span class="label label-purple arrowed-in-right">
                                                <i class="ace-icon fa fa-circle smaller-80 align-middle"></i>
                                                online
                                            </span>
                                        </h4>

                                        <div class="profile-user-info">
                                            <div class="profile-info-row">
                                                <div class="profile-info-name"> Địa chỉ </div>

                                                <div class="profile-info-value">
                                                    <i class="fa fa-map-marker light-orange bigger-110"></i>
                                                    <span>${account.address}</span>
                                                </div>
                                            </div>

                                            <div class="profile-info-row">
                                                <div class="profile-info-name"> Số điện thoại </div>

                                                <div class="profile-info-value">
                                                    <span>${account.phoneNumber}</span>
                                                </div>
                                            </div>

                                            <div class="profile-info-row">
                                                <div class="profile-info-name"> Email </div>

                                                <div class="profile-info-value">
                                                    <span>${account.email}</span>
                                                </div>
                                            </div>

                                            <div class="profile-info-row">
                                                <div class="profile-info-name"> Giới tính </div>

                                                <div class="profile-info-value">
                                                    <span>${account.gender}</span>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="hr hr-8 dotted"></div>

                                    </div><!-- /.col -->
                                </div><!-- /.row -->

                                <div class="space-20"></div>
                                
                                <div class="row">
                                    <h1 class="h1 blue" style="margin: 0 0 1rem 0">Thông tin lịch hẹn</h1>
                                </div>
                                <div class="row">
                                    <div class="col-xs-12 col-sm-9">
                                        <div class="profile-user-info">
                                            <div class="profile-info-row">
                                                <div class="profile-info-name"> Ngày đặt lịch </div>

                                                <div class="profile-info-value">
                                                    <i class="fa fa-map-marker light-orange bigger-110"></i>
                                                    <span>${account.address}</span>
                                                </div>
                                            </div>

                                            <div class="profile-info-row">
                                                <div class="profile-info-name"> Lý do khám </div>

                                                <div class="profile-info-value">
                                                    <span>${account.phoneNumber}</span>
                                                </div>
                                            </div>

                                            <div class="profile-info-row">
                                                <div class="profile-info-name"> Giá khám </div>

                                                <div class="profile-info-value">
                                                    <span>${account.email}</span>
                                                </div>
                                            </div>

                                            <div class="profile-info-row">
                                                <div class="profile-info-name"> Trạng thái </div>

                                                <div class="profile-info-value">
                                                    <span>${account.gender}</span>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="hr hr-8 dotted"></div>

                                    </div><!-- /.col -->
                                </div><!-- /.row -->
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