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
        <link rel="stylesheet" href="static/css/home.css">
        <link rel="stylesheet" href="static/css/footer.css">
        <script type="text/javascript" src="static/js/scrollTop.js"></script>
    </head>
    <body>
        <div class="top-area">
            <div class="img-area">
                <a href="#">
                    <img src="static/images/bookingcare-2020.svg" width="160" height="35"
                         alt="">
                </a>
            </div>
            <div class="navbar-pc">
                <ul class="nav-list">
                    <li class="nav-link">
                        <a href="#" class="mo-cuaso" dl-cuaso="chuyenkhoa"> Chuyên khoa
                            <span>Tìm bác sĩ theo chuyên khoa</span>
                        </a>
                    </li>
                    <li class="nav-link">
                        <a href="/#cosoyte" class="mo-cuaso" dl-cuaso="cosoyte"> Cơ sở y tế
                            <span>Chọn bệnh viện phòng khám</span>
                        </a>
                    </li>
                    <li class="nav-link">
                        <a href="/#bacsi" class="mo-cuaso" dl-cuaso="bacsi"> Bác sĩ
                            <span>Chọn bác sĩ giỏi</span>
                        </a>
                    </li>
                    <li class="nav-link">
                        <a href="/#khamtongquat" class="mo-cuaso" dl-cuaso="khamtongquat"> Gói khám
                            <span>Khám sức khỏe tổng quát</span>
                        </a>
                    </li>

                </ul>

            </div>
            <div class="top-right-area">
                <div class="layout">
                    <button class="btn-login" onclick="location.href='<c:url value="/dang-nhap"/>'">Đăng Nhập</button>
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
                            <img src="static/images/bookingcare-2020.svg" width="164" height="30"
                                 alt="">
                        </a>
                    </div>

                    <div class="nav-down">
                        <div class="search-area">
                            <form>
                                <i class="fas fa-search"></i>
                                <input class="input-search" type="text" placeholder="Nhập tên bác sĩ cần tìm..." />
                                <a class="btn-search">
                                    <img class="img-search" src="static/images/icon-search.png" width="21" height="23"
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
            <img src="static/images/header-background.jpg" width="1349" height="691"
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
       
        <div>
            <c:forEach var="specialty" items="${listSpecialty}">
            <div class="comic">
                <div class="grid-img"> 
                    <img src='data:image/jpeg;charset=utf-8;base64,${specialty.image}' />
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

        <div class="top-title">
            <div class="heading">
                <div class="title">Bác sĩ nổi bật</div>
            </div>
        </div>

        <div class="footer">
            <img src="static/images/back-to-top-icon.png" class="scrollToTopBtn hide" id="scrollToTopBtn" width="36" height="36"></img>
            <div class="top-footer"></div>
            <div class="down-footer">
                <div class="img-footer">
                    <img src="static/images/bookingcare-2020.svg" width="300" height="50"
                         alt=" Nhập tên bác sĩ cần tìm...">
                </div>
            </div>
        </div>
    </body>
</html>
