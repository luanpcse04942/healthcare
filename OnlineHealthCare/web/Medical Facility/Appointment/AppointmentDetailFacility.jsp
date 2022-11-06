<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Trang chủ cơ sở</title>
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
            #borderDivLeft{
                border-right: 2px solid;
                border-bottom:  2px solid;
            }
            #borderDivRight{
                border-left:  2px solid;
                border-bottom:  2px solid;
            }
            #borderDiv{
                border: 2px solid;
            }
        </style>
    </head>
    <body >
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
                                <a href="<c:url value='/appointment-Facility-home'/>">Trang chủ</a>
                            </li>
                            <li>
                                <a href="<c:url value='/Facility-Appointment-List'/>">Danh sách lịch hẹn</a>
                            </li>
                            <li class="active">Chi tiết lịch hẹn</li>
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
                                <h2 class="modal-title" style="text-align: center">Lịch hẹn</h2>
                                <div class="row" id="borderDiv">
                                    <div class="col-xs-12">


                                        

                                        <div class="row">
                                            <div class="column" id="borderDivLeft">
                                                <div class="column">
                                                    <div class="form-group col-sm-8">
                                                        <h3>Thông tin bệnh nhân</h3>
                                                        <div class="form-group col-sm-8">
                                                            <label>Họ tên: ${appointment.namePatient}</label>                                          
                                                        </div>
                                                        <div class="form-group col-sm-8">
                                                            <label>Giới tính: ${appointment.gender}</label>                                          
                                                        </div>
                                                        <div class="form-group col-sm-8">
                                                            <label>Số điện thoại: ${appointment.phonePatient}</label>                                          
                                                        </div>
                                                    </div>
                                                    <div class="form-group col-sm-4">
                                                        <span class="profile-picture">
                                                            <img alt="Avatar" width="130" height="130" src="<c:url value='data:image/jpeg;charset=utf-8;base64,${appointment.imagePatient}' />" />
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="column">

                                            </div>            
                                            <div class="column" id="borderDivRight">
                                                <div class="column">                                                    
                                                    <div class="form-group col-sm-8">
                                                        <h3>Thông tin bác sỹ</h3>
                                                        <div class="form-group col-sm-8">
                                                            <label>Họ tên: ${appointment.nameDoctor}</label>                                          
                                                        </div>
                                                        <div class="form-group col-sm-8">
                                                            <label>Số điện thoại: ${appointment.phoneDoctor}</label>                                          
                                                        </div>
                                                        <div class="form-group col-sm-8">
                                                            <label>Chuyên khoa: ${appointment.specName}</label>                                          
                                                        </div>
                                                        <div class="form-group col-sm-8">
                                                            <label>Cơ sở y tế: ${appointment.nameFac}</label>                                          
                                                        </div>
                                                    </div>
                                                    <div class="form-group col-sm-4">
                                                        <span class="profile-picture">
                                                            <img alt="Avatar" width="130" height="130" src="<c:url value='data:image/jpeg;charset=utf-8;base64,${appointment.imageDoctor}' />" />
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="column">
                                                <h3>Thông tin lịch hẹn</h3>
                                                <div class="form-group col-sm-12">
                                                    <label>Ngày hẹn: ${appointment.bookingDate}</label>                                          
                                                </div>
                                                <div class="form-group col-sm-12">
                                                    <label>Trạng thái: ${appointment.status}</label>                                          
                                                </div>
                                                <div class="form-group col-sm-12">
                                                    <label>Phí khám: ${appointment.price}</label>                                          
                                                </div>
                                            </div>
                                            <div class="column">

                                            </div>            
                                            <div class="column">
                                                <div class="form-group col-sm-12">

                                                </div>
                                                <div class="form-group col-sm-12">
                                                    <label>Thời gian: ${appointment.timeValue}</label>                                          
                                                </div>
                                                <div class="form-group col-sm-12">
                                                    <label>Hỗ trợ: ${appointment.phoneFac}</label>                                          
                                                </div>                                       
                                            </div>                                                
                                        </div>
                                        <hr class="line-full">
                                        <div class="row">
                                            <div class="column">
                                                <h3>Cập nhật thông tin:</h3>
                                                <p>Trạng thái</p>
                                                <div class="search-container">
                                                    <form id="form-search" action="<c:url value='/edit-appointment?appointmentId=${appointment.id}'/>" method="POST">
                                                        <div class="form-group">
                                                            <label>Chọn vai trò</label>
                                                            <input type="text" id ="appointmentId" name="appointmentId" value="${appointment.id}" hidden/>
                                                            <select class="form-control" id="statusId" name="statusId">
                                                                <c:forEach items="${status}" var="item">
                                                                    <option value="${item.statusId}">
                                                                        ${item.statusName}
                                                                    </option>
                                                                </c:forEach>
                                                            </select>
                                                            
                                                        </div>
                                                        <div class="col text-center">
                                                            <button type="submit" id ="test1" class="btn btn-primary btn-add-account" onclick="myFunction()">Cập nhật</button>                            
                                                        </div>
                                                    </form>
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