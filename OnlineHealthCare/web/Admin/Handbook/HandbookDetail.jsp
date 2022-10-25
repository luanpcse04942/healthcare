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
                                <a href="<c:url value='/handbook-list-admin'/>">Danh sách cẩm nang</a>
                            </li>
                            <li class="active">Chi tiết cẩm nang</li>
                        </ul>
                        <!-- /.breadcrumb -->

                    </div>
                    <div class="container">
                        <h2>Chi tiết Cẩm nang</h2>
                        <div id="alert"></div>
                        <c:if test="${not empty messageResponse}">
                            <div class="alert alert-${alert}">
                                ${messageResponse}
                            </div>
                        </c:if>
                        <form action="<c:url value='/edit-handbook?handBookId=${handbooks.id}'/>" id="formSubmit" method="post" enctype="multipart/form-data">
                            <div class="form-group col-sm-12">
                                <label>Người viết: </label>
                                <input id="name" name="name" type="text" value="${handbooks.fullName}" class="form-control" disabled>
                            </div>
                            <div class="form-group col-sm-12">
                                <label>Xuất bản: </label>
                                <input id="name" name="name" type="text" value="${handbooks.publishedAt}" class="form-control" disabled>
                            </div>
                            <div class="form-group col-sm-12">
                                <label>Tiêu đề: </label>
                                <input id="name" name="name" type="text" value="${handbooks.handbookName}" class="form-control" >
                            </div>
                            <div class="form-group col-sm-12">
                                <label>Nội dung: </label>
                                <textarea id="description" name="description" type="text" class="form-control" placeholder="Nhập vào mô tả ">${handbooks.content}</textarea>
                            </div>
                            <div class="form-group col-sm-12">
                                <span class="profile-picture">
                                    <img alt="Avatar" src="<c:url value='data:image/jpeg;charset=utf-8;base64,${handbooks.image}' />" />
                                </span>
                            </div>
                            <div class="form-group col-sm-12">
                                <div class="input-group">
                                    <div class="custom-file">
                                        <label class="custom-file-label" >Chọn ảnh</label>
                                        <input id="file" type="file" name="file" class="custom-file-input">
                                    </div>
                                </div>
                            </div>
                            <div class="form-group col-sm-9">
                                <button type="submit" class="btn btn-primary btn-edit-specialty">Sửa</button>
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

        <!-- page specific plugin scripts -->
        <script src="<c:url value='/template/admin/assets/js/jquery-ui.min.js'/>"></script>
    </body>
</html>