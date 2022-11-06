<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${facility.firstName} ${facility.lastName}</title>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css" type="text/css" /> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="template/login/assets/font-awesome/4.2.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="template/login/assets/fonts/fonts.googleapis.com.css">
        <link rel="stylesheet" href="<c:url value='/static/css/home.css' />"">
        <link rel="stylesheet" href="<c:url value='/static/css/footer.css' />"">
        <link rel="stylesheet" href="<c:url value='/static/css/FacilityDetail.css' />"">
    </head>
    <body> 
        <header id="dieuhuong" style="width: 100%; height: 50px;">
            <div class="vung-bao">
                <a href="<c:url value='/trang-chu'/>">
                    <i class="ace-icon fa fa-arrow-left"></i>
                </a>
                <h2 style="color: #ffffff;">${facility.firstName} ${facility.lastName}</h2>
            </div>
        </header>
        <!-- xong Header-->      
        <!--ghi content cac thu-->   
        <div class="container bg-light">
            <div class="navbar-expand-lg navbar-light  lighten-3 mt-3  ">
                <div class="breadcrumbs ace-save-state  " id="breadcrumbs">
                    <ul class="breadcrumb ">
                        <div class="line_right publish" style="font-size:20px;""margin-left: 0px;">Tên cơ sở: ${facility.firstName} ${facility.lastName}. </div>
                        <div  class="line_right publish" style="font-size:20px;""margin-left: 0px;">Địa chỉ : ${facility.address}. </div>
                        <div  class="line_right publish" style="font-size:20px;""margin-left: 0px;">Số điện thoại liên hệ : ${facility.phoneNumber}.</div>
                        <div  class="line_right publish" style="font-size:20px;""margin-left: 0px;">Email liên hệ : ${facility.email}.</div>
                    </ul>
                </div>
            </div>
            <div class=" right">
                <img width="350px" height="230px" src="<c:url value='data:image/jpeg;charset=utf-8;base64,${facility.images}' />" />
            </div>

            <div class="breadcrumbs ace-save-state ">
                <h1 class="baiviet-ten st" style="font-size:33px;color: #0092ef">Giới thiệu</h1>
                <h1 class="baiviet-ten st" style="font-size:20px;color: #414b51">${facility.description}</h1> 
                <span style="font-size:25px;"> ${handbook.content}</span>
            </div>
        </div>
        <!--footer-->
        <div class="footer">
            <div class="top-footer"></div>
            <div class="down-footer">
                <div class="img-footer">
                    <h1>
                        <i class="ace-icon fa fa-leaf green"></i>
                        HealthCare
                    </h1>
                </div>
            </div>
        </div>
    </body>
</html>
