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
    <body class="no-skin" style="overflow-x: hidden">
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
                            <li class="active">Chi tiết cơ sở</li>
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
                        <form action="<c:url value='/edit-facility?facilityId=${facility.id}'/>" id="formSubmit" method="post" enctype="multipart/form-data">
                            <div class="form-group col-sm-12">
                                <span class="profile-picture">
                                    <img alt="Avatar" src="<c:url value='data:image/jpeg;charset=utf-8;base64,${facility.images}' />" />
                                </span>
                            </div>
                            <div class="form-group col-sm-12">
                                <label>Tên cơ sở</label>
                                <input name="name" type="text" value="${facility.firstName} ${facility.lastName}" class="form-control"  placeholder="Nhập vào tên cơ sở">
                            </div>
                            <div class="form-group col-sm-12">
                                <label>Mô tả </label>
                                <textarea name="description" type="text" class="form-control" placeholder="Nhập vào mô tả " style="height: 100px;">${facility.description}</textarea>
                            </div>
                            <h2>Thông tin khác</h2>
                            <div class="form-group col-sm-6">
                                <label >Email</label>
                                <input type="text" class="form-control" value="${facility.email}" disabled="true">
                            </div> 
                            <div class="form-group col-sm-6">
                                <label>Số điện thoại</label>
                                <input type="text" class="form-control" value="${facility.phoneNumber}">
                            </div>
                            <div class="form-group col-sm-6">
                                <label >Địa chỉ</label>
                                <input type="text" class="form-control" value="${facility.address}">
                            </div>
                            <div class="form-group col-sm-6">

                                <div class="form-group">
                                    <label>Trạng thái tài khoản</label>
                                    <select class="form-control" id="sel1">
                                        <option>
                                            <c:if test="${facility.activedStatus == 5}">Đã xác thực</c:if>
                                            <c:if test="${facility.activedStatus == 6}">Chưa xác thực</c:if>
                                            <c:if test="${facility.activedStatus == 7}">Đã khóa</c:if>
                                            </option>
                                            <option>Vô hiệu hóa</option>
                                        </select>
                                    </div>
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
                                    <button type="submit" class="btn btn-primary">Cập nhật</button>
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
                jQuery(function ($) {
                    //another option is using modals
                    $('#avatar2').on('click', function () {
                        var modal =
                                '<div class="modal fade">\
                                  <div class="modal-dialog">\
                                   <div class="modal-content">\
                                        <div class="modal-header">\
                                                <button type="button" class="close" data-dismiss="modal">&times;</button>\
                                                <h4 class="blue">Change Avatar</h4>\
                                        </div>\
                                        \
                                        <form class="no-margin">\
                                         <div class="modal-body">\
                                                <div class="space-4"></div>\
                                                <div style="width:75%;margin-left:12%;"><input type="file" name="file-input" /></div>\
                                         </div>\
                                        \
                                         <div class="modal-footer center">\
                                                <button type="submit" class="btn btn-sm btn-success"><i class="ace-icon fa fa-check"></i> Submit</button>\
                                                <button type="button" class="btn btn-sm" data-dismiss="modal"><i class="ace-icon fa fa-times"></i> Cancel</button>\
                                         </div>\
                                        </form>\
                                  </div>\
                                 </div>\
                                </div>';


                        var modal = $(modal);
                        modal.modal("show").on("hidden", function () {
                            modal.remove();
                        });

                        var working = false;

                        var form = modal.find('form:eq(0)');
                        var file = form.find('input[type=file]').eq(0);
                        file.ace_file_input({
                            style: 'well',
                            btn_choose: 'Click to choose new avatar',
                            btn_change: null,
                            no_icon: 'ace-icon fa fa-picture-o',
                            thumbnail: 'small',
                            before_remove: function () {
                                //don't remove/reset files while being uploaded
                                return !working;
                            },
                            allowExt: ['jpg', 'jpeg', 'png', 'gif'],
                            allowMime: ['image/jpg', 'image/jpeg', 'image/png', 'image/gif']
                        });

                        form.on('submit', function () {
                            if (!file.data('ace_input_files'))
                                return false;

                            file.ace_file_input('disable');
                            form.find('button').attr('disabled', 'disabled');
                            form.find('.modal-body').append("<div class='center'><i class='ace-icon fa fa-spinner fa-spin bigger-150 orange'></i></div>");

                            var deferred = new $.Deferred;
                            working = true;
                            deferred.done(function () {
                                form.find('button').removeAttr('disabled');
                                form.find('input[type=file]').ace_file_input('enable');
                                form.find('.modal-body > :last-child').remove();

                                modal.modal("hide");

                                var thumb = file.next().find('img').data('thumb');
                                if (thumb)
                                    $('#avatar2').get(0).src = thumb;

                                working = false;
                            });


                            setTimeout(function () {
                                deferred.resolve();
                            }, parseInt(Math.random() * 800 + 800));

                            return false;
                        });

                    });

                    /////////////////////////////////////
                    $(document).one('ajaxloadstart.page', function (e) {
                        //in ajax mode, remove remaining elements before leaving page
                        try {
                            $('.editable').editable('destroy');
                        } catch (e) {
                        }
                        $('[class*=select2]').remove();
                    });
                });
        </script>
    </body>
</html>