<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />" />
        <link rel="stylesheet" href="<c:url value='/template/admin/font-awesome/4.5.0/css/font-awesome.min.css' />" />
        <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/ace.min.css' />" class="ace-main-stylesheet" id="main-ace-style" />
        <script src="<c:url value='/template/admin/assets/js/ace-extra.min.js' />"></script>
        <script type='text/javascript' src='<c:url value="/template/admin/js/jquery-2.2.3.min.js" />'></script>
        <script src="<c:url value='/template/admin/assets/js/jquery.2.1.1.min.js' />"></script>
        <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/bootstrap-editable.min.css' />" />
        <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/select2.min.css' />" />
        <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/jquery-ui.custom.min.css' />" />
        <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/jquery.gritter.min.css' />" />
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
            <%@ include file="/Admin/menu.jsp" %>
            <!-- header -->

            <div class="main-content">

                <div class="main-content-inner">
                    <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                        <ul class="breadcrumb">
                            <li>
                                <i class="ace-icon fa fa-home home-icon"></i>
                                <a href="<c:url value='/admin-home'/>">Trang chủ</a>
                            </li>
                            <li>
                                <a href="<c:url value='/admin-facility-list'/>">Danh sách cơ sở</a>
                            </li>
                            <li class="active">Thêm cơ sở</li>
                        </ul>
                        <!-- /.breadcrumb -->
                    </div>
                    <div class="container">
                        <h2>Chi tiết cơ sở</h2>
                        <c:if test="${not empty messageResponse}">
                            <div class="alert alert-${alert}">
                                ${messageResponse}
                            </div>
                        </c:if>
                        <form action="<c:url value='/add-facility'/>" id="formSubmit" method="post" enctype="multipart/form-data">
                            <div class="form-group col-sm-12">
                                <label>Tên cơ sở</label>
                                <input name="name" type="text" class="form-control"  placeholder="Nhập vào tên cơ sở">
                            </div>
                            <div class="form-group col-sm-12">
                                <label>Mô tả </label>
                                <textarea name="description" type="text" class="form-control" placeholder="Nhập vào mô tả " style="height: 100px;"></textarea>
                            </div>
                            <h2>Thông tin khác</h2>
                            <div class="form-group col-sm-6">
                                <label >Email</label>
                                <input type="text" class="form-control" placeholder="Nhập vào email">
                            </div> 
                            <div class="form-group col-sm-6">
                                <label>Mật khẩu</label>
                                <input name="password" type="password" class="form-control" placeholder="Nhập vào mật khẩu">
                            </div>
                            <div class="form-group col-sm-6">
                                <label>Số điện thoại</label>
                                <input type="text" class="form-control"  placeholder="Nhập vào số  điện thoại" >
                            </div>
                            <div class="form-group col-sm-6" >
                                <label >Địa chỉ</label>
                                <input type="text" class="form-control" placeholder="Nhập vào địa chỉ">
                            </div>


                            <div class="form-group col-sm-12">
                                <div class="input-group">
                                    <div class="custom-file">
                                        <label class="custom-file-label" >Chọn ảnh</label>
                                        <input type="file" name="file" class="custom-file-input">
                                    </div>
                                </div>
                            </div>
                            <div class="form-group col-sm-9">
                                <button type="submit" class="btn btn-primary">Thêm mới</button>
                            </div>
                        </form>
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
        <script src="<c:url value='/template/admin/assets/js/bootstrap-editable.min.js' />"></script>
        <script src="<c:url value='/template/admin/assets/js/ace-editable.min.js ' />"></script>
        <!-- page specific plugin scripts -->
        <script src="<c:url value='/template/admin/assets/js/jquery-ui.min.js'/>"></script>
        <!-- inline scripts related to this page -->
        <script type="text/javascript">
                
        </script>
    </body>
</html>