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
                <form>
                    <div class="main-content-inner">
                        <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                            <ul class="breadcrumb">
                                <li>
                                    <i class="ace-icon fa fa-home home-icon"></i>
                                    <a href="<c:url value='/facility-home?facilityId=${facilityId}'/>">Trang chủ cơ sở</a>
                                </li>
                                <li class="active">Đặt lịch cho bác sĩ</li>
                            </ul>
                        </div>
                        <div class="page-content">
                            <div id="alert"></div>
                            <div class="form-group col-sm-6">
                                <h3 class="header blue lighter smaller">
                                    <i class="ace-icon glyphicon glyphicon-user smaller-90"></i>
                                    Chọn bác sĩ
                                </h3>
                                <select class="form-control" id="select-doctor" name="doctor">
                                    <c:forEach items="${doctors}" var="doctor">
                                        <option value="${doctor.id}">
                                            ${doctor.firstName} ${doctor.lastName}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="form-group col-sm-6">
                                <h3 class="header blue lighter smaller">
                                    <i class="ace-icon fa fa-calendar-o smaller-90"></i>
                                    Chọn ngày
                                </h3>

                                <div class="row">
                                    <div class="col-xs-6">
                                        <div class="input-group input-group-sm">
                                            <input type="text" id="datepicker" data-date-format='yyyy-mm-dd' class="form-control" />
                                            <span class="input-group-addon">
                                                <i class="ace-icon fa fa-calendar"></i>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group col-sm-12">
                                <h3 class="header blue lighter smaller">
                                    <i class="ace-icon fa fa-calendar-o smaller-90"></i>
                                    Chọn thời gian
                                </h3>
                                <div class="container">
                                    <div class="row">
                                        <div class="col-xs-6">
                                            <div class="input-group input-group-sm pick-hour-container">
                                                <div class="row">
                                                    <div class="col-12 pick-hour-container">
                                                        <c:forEach var="time" items="${times}" varStatus="loop">
                                                            <span class="${time.id}">${time.value}</span>
                                                        </c:forEach>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group col-sm-12">
                                <button class="btn btn-primary btn-save-schedule">Lưu thông tin</button>
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
        <script type="text/javascript">
            var listTimeId = [];
            $('.pick-hour-container span').on("click", function () {
                var className = $(this).attr('class');
                listTimeId.push(className);
                if ($(this).hasClass("active")) {
                    $(this).removeClass('active');
                    $(this).removeAttr('style');
                } else {
                    $("." + className).css("background-color", "Orange");
                    $("." + className).css("color", "#fff");
                    $("." + className).addClass("active");
                }
            });

            $('.btn-save-schedule').on("click", function (e) {
                var doctorId = $('#select-doctor').find(":selected").val();
                var selectedDate = $("#datepicker").val().toString();
                var listTimeActived = [];
                $('.pick-hour-container').find('span.active').each(function () {
                    listTimeActived.push($(this).attr('class'));
                });
                if (selectedDate === "" && listTimeActived.length === 0) {
                    $("#datepicker").css('border-color', 'red');
                    $('.pick-hour-container span').css('border-color', 'red');
                    $("#alert").addClass("alert alert-danger");
                    $('#alert').text('Vui lòng chọn ngày & thời gian !');
                    setTimeout(function () {
                        $("#datepicker").css('border-color', '#d5d5d5');
                        $('.pick-hour-container span').css('border-color', '#8ab5f5');
                        $('#alert').hide();
                    }, 3000);
                    e.preventDefault();
                } else if (selectedDate === "" || listTimeActived.length === 0) {
                    if (selectedDate === "") {
                        $("#datepicker").css('border-color', 'red');
                        $("#alert").addClass("alert alert-danger");
                        $('#alert').text('Vui lòng chọn ngày !');
                        $('#alert').show();
                        setTimeout(function () {
                            $("#datepicker").css('border-color', '#d5d5d5');
                            $('#alert').hide();
                        }, 3000);
                    }

                    if (listTimeActived.length === 0) {
                        $('.pick-hour-container span').css('border-color', 'red');
                        $("#alert").addClass("alert alert-danger");
                        $('#alert').text('Vui lòng chọn thời gian !');
                        $('#alert').show();
                        setTimeout(function () {
                            $('.pick-hour-container span').css('border-color', '#8ab5f5');
                            $('#alert').hide();
                        }, 3000);
                    }
                    e.preventDefault();
                } else {
                    $.ajax({
                        method: "POST",
                        url: 'facility-add-schedule',
                        dataType: 'json',
                        data: {
                            doctorId: doctorId,
                            selectedDate: selectedDate,
                            listTimeId: JSON.stringify(listTimeId)
                        }
                    });
                    $("#alert").addClass("alert alert-success");
                    $('#alert').text('Thêm lịch thành công !');
                    $('#alert').show();
                    setTimeout(function () {
                        $('#alert').hide();
                    }, 3000);
                    e.preventDefault();
                }
            });
            jQuery(function ($) {

                $("#datepicker").datepicker({
                    showOtherMonths: true,
                    selectOtherMonths: false,
                    minDate: new Date(),
                    changeMonth: true,
                    changeYear: true,
                    //isRTL:true,


                    /*
                     changeMonth: true,
                     changeYear: true,
                     
                     showButtonPanel: true,
                     beforeShow: function() {
                     //change button colors
                     var datepicker = $(this).datepicker( "widget" );
                     setTimeout(function(){
                     var buttons = datepicker.find('.ui-datepicker-buttonpane')
                     .find('button');
                     buttons.eq(0).addClass('btn btn-xs');
                     buttons.eq(1).addClass('btn btn-xs btn-success');
                     buttons.wrapInner('<span class="bigger-110" />');
                     }, 0);
                     }
                     */
                });
            });
        </script>
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