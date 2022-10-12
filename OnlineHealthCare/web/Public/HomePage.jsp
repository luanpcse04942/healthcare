<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HealthCare - NỀN TẢNG Y TẾ CHĂM SÓC SỨC KHỎE TOÀN DIỆN</title>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css" type="text/css" /> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="template/login/assets/font-awesome/4.2.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="template/login/assets/fonts/fonts.googleapis.com.css">
        <link rel="stylesheet" href="<c:url value='/static/css/home.css' />"">
        <link rel="stylesheet" href="<c:url value='/static/css/footer.css' />"">
    </head>
    <body>
        <div class="top-area">
            <div class="img-area">
                <a href="#">
                    <h1>
                        <i class="ace-icon fa fa-leaf green"></i>
                        HealthCare
                    </h1>
                </a>
            </div>
            <div class="navbar-pc">
                <ul class="nav-list">
                    <li class="nav-link">
                        <a href="<c:url value='/public-specialty-list'/>" class="mo-cuaso" dl-cuaso="chuyenkhoa"> Chuyên khoa
                            <span>Tìm bác sĩ theo chuyên khoa</span>
                        </a>
                    </li>
                    <li class="nav-link">
                        <a href="#" class="mo-cuaso" dl-cuaso="cosoyte"> Cơ sở y tế
                            <span>Chọn bệnh viện phòng khám</span>
                        </a>
                    </li>
                    <li class="nav-link">
                        <a href="<c:url value='/doctor-list-public'/>" class="mo-cuaso" dl-cuaso="bacsi"> Bác sĩ
                            <span>Chọn bác sĩ giỏi</span>
                        </a>
                    </li>
                </ul>

            </div>
            <div class="top-right-area">
                <div class="layout">
                    <button class="btn-login" onclick="location.href = '<c:url value="/dang-nhap"/>'">Đăng Nhập</button>
                </div>
            </div>
        </div>

        <div id="navbar-area">
            <div class="navbar-container">

                <label for="nav-mobile-input" class="nav_bars-btn">
                    <i class="fas fa-bars"></i>
                </label>

                <input type="checkbox" hidden name="" class="nav_input" id="nav-mobile-input" />

                <label for="nav-mobile-input" class="nav__overlay"></label>

                <div class="nav__mobile">
                    <div class="img-area">
                        <label for="nav-mobile-input" class="nav-close">
                            <i class="fas fa-times"></i>
                        </label>
                        <a href="#">
                            HealthCare
                        </a>
                    </div>

                    <div class="nav-down">
                        <div class="search-area">
                            <form>
                                <i class="fas fa-search"></i>
                                <input class="input-search" type="text" placeholder="Nhập tên bác sĩ cần tìm..." />
                                <a class="btn-search">
                                    <img src="static/images/icon-search.png" width="21" height="23"
                                         alt=" Nhập tên bác sĩ cần tìm...">
                                </a>
                            </form>
                        </div>

                        <ul class="nav__mobile-list">
                            <li class="nav__mobile-link">Chuyên khoa</li>
                            <li class="nav__mobile-link">Cơ sở y tế</li>
                            <li class="nav__mobile-link">Bác sĩ</li>
                            <li class="nav__mobile-link">Gói khám</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="home-header-banner">
            <img src="static/images/header-background.jpg" width="100%" height="691"
                 alt="">
            <div class="content-up">
                <div class="search">
                    <div class="text-name">
                        <h1>Nền tảng y tế <br>
                            <b>chăm sóc sức khỏe toàn diện</b>
                        </h1>
                    </div>

                    <div class="search-area">
                        <input class="input-search" type="text" placeholder="Nhập tên bác sĩ cần tìm..." />
                        <a class="btn-search">
                            <img class="img-search" src="static/images/icon-search.png" width="21" height="23"
                                 alt=" Nhập tên bác sĩ cần tìm...">
                        </a>
                    </div>
                    <!-- 
                    <div class="searching">
                        <i class="fas fa-search"></i>
                        <input type="text" placeholder="Tìm chuyên khoa">
                    </div>
                   
                </div>
                    -->
                </div>
            </div>
            <div class="content-down">
                <div class="options">
                    <div class="option-child">
                        <div class="bg-icon"><img src="static/images/khamchuyenkhoa.png" width="40" height="40"alt=""></div>
                        <div class="text-child">Khám chuyên khoa</div>  
                    </div>
                    <div class="option-child">
                        <div class="bg-icon"><img src="static/images/khamtuxa.png" width="40" height="40"alt=""></div>
                        <div class="text-child">Khám từ xa online</div>
                    </div>
                    <div class="option-child">
                        <div class="bg-icon"><img src="static/images/khamtongquat.png" width="40" height="40"alt=""></div>
                        <div class="text-child">Khám tổng quát</div>
                    </div>
                    <div class="option-child">
                        <div class="bg-icon"><img src="static/images/khamchuyenkhoa.png" width="40" height="40"alt=""></div>
                        <div class="text-child">Xét nghiệm y học</div>
                    </div>
                    <div class="option-child">
                        <div class="bg-icon"><img src="static/images/suckhoetinhthan.png" width="40" height="40"alt=""></div>
                        <div class="text-child">Sức khỏe tinh thần</div>
                    </div>
                    <div class="option-child">
                        <div class="bg-icon"><img src="static/images/dichvuxetnghiem.png" width="40" height="40"alt=""></div>
                        <div class="text-child">Khám nha khoa</div>
                    </div>
                </div>
            </div>

        </div>





        <div class="top-title">
            <div class="heading">
                <div class="title">Cẩm nang</div>
            </div>
        </div>

        <div class="top-title">
            <div class="heading">
                <div class="title">Chuyên khoa nổi bật</div>
            </div>
        </div>

        <div class="spec-list">
            <c:forEach var="specialty" items="${listSpecialty}">
                <div class="specialty">
                    <div class="grid-img"> 
                        <img width="300px" height="200px" src="<c:url value='/static/images/Specialty/${specialty.image}' />" />
                    </div>
                    <div class="grid-name">${specialty.name}</div>
                </div>
            </c:forEach>
        </div>


        <div class="top-title">
            <div class="heading">
                <div class="title">Cơ sở nổi bật</div>
            </div>
        </div>

        <div class="spec-list">
            <c:forEach var="facility" items="${listFacility}">
                <div class="specialty">
                    <div class="grid-img"> 
                        <img width="300px" height="200px" src="<c:url value='/static/images/Facility/${facility.images}' />" />
                    </div>
                    <div class="grid-name">
                        <span>${facility.firstName} ${facility.lastName}</span>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="top-title">
            <div class="heading">
                <div class="title">Bác sĩ nổi bật</div>
            </div>
        </div>

        <div class="spec-list">
            <c:forEach var="doctor" items="${listDoctor}">
                <div class="doctors">
                    <div class="doctors-image grid-img"> 
                        <img width="120" height="120" src="<c:url value='/static/images/Doctor/${doctor.images}' />" />
                    </div>
                    <div class="doctor-name">${doctor.firstName} ${doctor.lastName}</div>
                </div>
            </c:forEach>
        </div>

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
