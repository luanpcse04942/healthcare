<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${handbook.handbookName}</title>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css" type="text/css" /> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="template/login/assets/font-awesome/4.2.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="template/login/assets/fonts/fonts.googleapis.com.css">
        <link rel="stylesheet" href="<c:url value='/static/css/home.css' />"">
        <link rel="stylesheet" href="<c:url value='/static/css/footer.css' />"">
        <link rel="stylesheet" href="<c:url value='/static/css/handbookDetail.css' />">
    </head>
    <body>
        <jsp:include page="/Public/Header.jsp"></jsp:include>
            <!-- xong Header-->      
            <!--Dưới là Left-->  
            <div class="container">
                    <div class="navbar-expand-lg navbar-light  lighten-4 mt-4 ">
                        <div class="breadcrumbs ace-save-state " id="breadcrumbs">
                            <ul class="breadcrumb " style="font-size:15px;">
                                <li>
                                    <i class="ace-icon fa fa-home home-icon"></i>
                                    <a href="<c:url value='/trang-chu'/>">Trang chủ</a>
                            </li>
                            <li>
                                <i class=" ace-icon  "></i>
                                <a  href="<c:url value='/public-handbook-list'/>">Cẩm nang</a>
                            </li>
                            <li class="active">Chi tiết</li>
                        </ul>
                    </div>
                </div>
                <!--ghi content cac thu-->   


                <div class="navbar-expand-lg navbar-light  lighten-3 mt-3 ">
                    <div class="breadcrumbs ace-save-state bg-info " id="breadcrumbs">
                        <ul class="breadcrumb ">
                            <div class="line_right publish" style="font-size:15px;""margin-left: 0px;"> Người đăng: ${handbook.fullName} </div>
                            <div  class="line_right publish" style="font-size:15px;""margin-left: 0px;"> Xuất bản: ${handbook.publishedAt}, Cập nhật lần cuối: 03/11/2022 </div>
                        </ul>
                    </div>
                </div>
                <div class="breadcrumbs ace-save-state ">
                    <h1 class="baiviet-ten st" style="font-size:33px;">${handbook.handbookName}</h1>
                    <div class="container center">
                        <img width="650px" height="450px" src="<c:url value='data:image/jpeg;charset=utf-8;base64,${handbook.image}' />" />
                    </div>
                    
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
