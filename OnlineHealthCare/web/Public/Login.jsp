<%-- 
    Document   : Login
    Created on : Sep 21, 2022, 1:07:15 PM
    Author     : LuanPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="User login page" />

        <title>Trang Đăng Nhập</title>

        <link rel="stylesheet" href="template/login/assets/css/bootstrap.min.css" />
        <link rel="stylesheet" href="template/login/assets/font-awesome/4.2.0/css/font-awesome.min.css" />
        <link rel="stylesheet" href="template/login/assets/fonts/fonts.googleapis.com.css" />
        <link rel="stylesheet" href="template/login/assets/css/ace.min.css" />
        <link rel="stylesheet" href="template/login/assets/css/ace-rtl.min.css" />

    </head>

    <body class="login-layout">
        <div class="main-container">
            <div class="main-content">
                <div class="row">
                    <div class="col-sm-10 col-sm-offset-1">
                        <div class="login-container">
                            <div class="center">
                                <h1>
                                    <i class="ace-icon fa fa-leaf green"></i>
                                    <span class="red">Health Care</span>
                                    <span class="white" id="id-text2">System</span>
                                </h1>
                            </div>

                            <div class="space-6"></div>

                            <div class="position-relative">
                                
                                <!-- /.login-box -->
                                <div id="login-box" class="login-box visible widget-box no-border">
                                    <div class="widget-body">
                                        <div class="widget-main">
                                            <h4 class="header blue lighter bigger">
                                                <i class="ace-icon fa fa-coffee green"></i>
                                                Vui lòng điền thông tin
                                            </h4>
                                            <c:if test="${not empty MessageLogin}">
                                                <p class="alert">
                                                    ${MessageLogin}
                                                </p>
                                            </c:if>

                                            <div class="space-6"></div>

                                            <form action="<c:url value='/login'/>" method="post">
                                                <fieldset>
                                                    <label class="block clearfix">
                                                        <span class="block input-icon input-icon-right">
                                                            <input type="email" class="form-control" 
                                                                   name="email-login" placeholder="Email" required/>
                                                            <i class="ace-icon fa fa-user"></i>
                                                        </span>
                                                    </label>

                                                    <label class="block clearfix">
                                                        <span class="block input-icon input-icon-right">
                                                            <input type="password" class="form-control" 
                                                                   name="password-login" placeholder="Mật khẩu" required/>
                                                            <i class="ace-icon fa fa-lock"></i>
                                                        </span>
                                                    </label>

                                                    <div class="space"></div>

                                                    <div class="clearfix">
                                                        <button type="submit" class="width-40 pull-right btn btn-sm btn-primary">
                                                            <i class="ace-icon fa fa-key"></i>
                                                            <span class="bigger-110">Đăng Nhập</span>
                                                        </button>
                                                    </div>

                                                    <div class="space-4"></div>
                                                </fieldset>
                                            </form>

                                            <div class="social-or-login center">
                                                <span class="bigger-110">Or Login Using</span>
                                            </div>

                                            <div class="space-6"></div>

                                            <div class="social-login center">
                                                <a class="btn btn-danger">
                                                    <i class="ace-icon fa fa-google-plus"></i>
                                                </a>
                                            </div>
                                        </div><!-- /.widget-main -->

                                        <div class="toolbar clearfix">
                                            <div>
                                                <a href="#" data-target="#forgot-box" class="forgot-password-link">
                                                    <i class="ace-icon fa fa-arrow-left"></i>
                                                    Quên mật khẩu
                                                </a>
                                            </div>

                                            <div>
                                                <a href="#" data-target="#signup-box" class="user-signup-link">
                                                    Đăng ký tài khoản
                                                    <i class="ace-icon fa fa-arrow-right"></i>
                                                </a>
                                            </div>
                                        </div>
                                    </div><!-- /.widget-body -->
                                </div>

                                <!-- /.forgot-box -->                
                                <div id="forgot-box" class="forgot-box widget-box no-border">
                                    <div class="widget-body">
                                        <div class="widget-main">
                                            <h4 class="header red lighter bigger">
                                                <i class="ace-icon fa fa-key"></i>
                                                Lấy lại mật khẩu
                                            </h4>

                                            <div class="space-6"></div>
                                            <p>
                                                Điền email của bạn và làm theo hướng dẫn
                                            </p>

                                            <form>
                                                <fieldset>
                                                    <label class="block clearfix">
                                                        <span class="block input-icon input-icon-right">
                                                            <input type="email" class="form-control" placeholder="Email" />
                                                            <i class="ace-icon fa fa-envelope"></i>
                                                        </span>
                                                    </label>

                                                    <div class="clearfix">
                                                        <button type="button" class="width-35 pull-right btn btn-sm btn-danger">
                                                            <i class="ace-icon fa fa-lightbulb-o"></i>
                                                            <span class="bigger-110">Gửi thư!</span>
                                                        </button>
                                                    </div>
                                                </fieldset>
                                            </form>
                                        </div><!-- /.widget-main -->

                                        <div class="toolbar center">
                                            <a href="#" data-target="#login-box" class="back-to-login-link">
                                                Quay lại đăng nhập
                                                <i class="ace-icon fa fa-arrow-right"></i>
                                            </a>
                                        </div>
                                    </div><!-- /.widget-body -->
                                </div>
                                
                                <!-- /.signup-box -->
                                <div id="signup-box" class="signup-box widget-box no-border">
                                    <div class="widget-body">
                                        <div class="widget-main">
                                            <h4 class="header green lighter bigger">
                                                <i class="ace-icon fa fa-users blue"></i>
                                                Đăng ký tài khoản
                                            </h4>

                                            <div class="space-6"></div>
                                            <p> Vui lòng điền thông tin: </p>

                                            <form action="<c:url value='/register'/>" method="post">
                                                <fieldset>
                                                    <label class="block clearfix">
                                                        <span class="block input-icon input-icon-right">
                                                            <input name="email-reg" type="email" 
                                                                   class="form-control" 
                                                                   placeholder="Email" required/>
                                                            <i class="ace-icon fa fa-envelope"></i>
                                                        </span>
                                                    </label>

                                                    <label class="block clearfix">
                                                        <span class="block input-icon input-icon-right">
                                                            <input name="first-name" type="text" 
                                                                   class="form-control" 
                                                                   placeholder="Họ" required/>
                                                            <i class="ace-icon fa fa-user"></i>
                                                        </span>
                                                    </label>

                                                    <label class="block clearfix">
                                                        <span class="block input-icon input-icon-right">
                                                            <input name="last-name" type="text" 
                                                                   class="form-control" 
                                                                   placeholder="Tên" required/>
                                                            <i class="ace-icon fa fa-user"></i>
                                                        </span>
                                                    </label>

                                                    <label class="block clearfix">
                                                        <span class="block input-icon input-icon-right">
                                                            <input type="password" class="form-control"
                                                                   name="password-reg" id="password"
                                                                   placeholder="Mật khẩu" required/>
                                                            <i class="ace-icon fa fa-lock"></i>
                                                        </span>
                                                    </label>

                                                    <label class="block clearfix">
                                                        <span class="block input-icon input-icon-right">
                                                            <input type="password" class="form-control" 
                                                                   id="confirm_password"
                                                                   placeholder="Nhập lại mật khẩu" required/>
                                                            <i class="ace-icon fa fa-retweet"></i>
                                                        </span>
                                                    </label>

                                                    <div class="space-24"></div>

                                                    <div class="clearfix">
                                                        <button type="reset" class="width-30 pull-left btn btn-sm">
                                                            <i class="ace-icon fa fa-refresh"></i>
                                                            <span class="bigger-110">Reset</span>
                                                        </button>

                                                        <button type="submit" class="width-65 pull-right btn btn-sm btn-success">
                                                            <span class="bigger-110">Đăng ký</span>

                                                            <i class="ace-icon fa fa-arrow-right icon-on-right"></i>
                                                        </button>
                                                    </div>
                                                </fieldset>
                                            </form>
                                        </div>

                                        <div class="toolbar center">
                                            <a href="#" data-target="#login-box" class="back-to-login-link">
                                                <i class="ace-icon fa fa-arrow-left"></i>
                                                Quay lại đăng nhập
                                            </a>
                                        </div>
                                    </div><!-- /.widget-body -->
                                </div>

                                <div>
                                    <a href='<c:url value="/trang-chu" />' 
                                       data-target="#forgot-box" class="forgot-password-link">
                                        <i class="ace-icon fa fa-arrow-left"></i>
                                        Quay lại trang chủ
                                    </a>
                                </div>
                            </div><!-- /.position-relative -->

                            <div class="navbar-fixed-top align-right">
                                <br />
                                &nbsp;
                                <button id="btn-login-dark">Dark</button>
                                &nbsp;
                                <span class="blue">/</span>
                                &nbsp;
                                <button id="btn-login-blur">Blur</button>
                                &nbsp;
                                <span class="blue">/</span>
                                &nbsp;
                                <button id="btn-login-light">Light</button>
                                &nbsp; &nbsp; &nbsp;
                            </div>
                        </div>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.main-content -->
        </div><!-- /.main-container -->

        <!-- basic scripts -->

        <!--[if !IE]> -->
        <script src="template/login/assets/js/jquery.2.1.1.min.js"></script>

        <!-- <![endif]-->

        <!--[if IE]>
<script src="assets/js/jquery.1.11.1.min.js"></script>
<![endif]-->

        <!--[if !IE]> -->
        <script type="text/javascript">
            window.jQuery || document.write("<script src='template/login/assets/js/jquery.min.js'>" + "<" + "/script>");
        </script>

        <!-- <![endif]-->

        <!--[if IE]>
<script type="text/javascript">
window.jQuery || document.write("<script src='assets/js/jquery1x.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
        <script type="text/javascript">
            if ('ontouchstart' in document.documentElement)
                document.write("<script src='template/login/assets/js/jquery.mobile.custom.min.js'>"
                        + "<" + "/script>");

            var password = document.getElementById("password")
                    , confirm_password = document.getElementById("confirm_password");

            function validatePassword() {
                if (password.value !== confirm_password.value) {
                    confirm_password.setCustomValidity("Passwords Don't Match");
                } else {
                    confirm_password.setCustomValidity('');
                }
            }

            password.onchange = validatePassword;
            confirm_password.onkeyup = validatePassword;
        </script>

        <!-- inline scripts related to this page -->
        <script type="text/javascript">
            jQuery(function ($) {
                $(document).on('click', '.toolbar a[data-target]', function (e) {
                    e.preventDefault();
                    var target = $(this).data('target');
                    $('.widget-box.visible').removeClass('visible');//hide others
                    $(target).addClass('visible');//show target
                });
            });



            //you don't need this, just used for changing background
            jQuery(function ($) {
                $('#btn-login-dark').on('click', function (e) {
                    $('body').attr('class', 'login-layout');
                    $('#id-text2').attr('class', 'white');
                    $('#id-company-text').attr('class', 'blue');

                    e.preventDefault();
                });
                $('#btn-login-light').on('click', function (e) {
                    $('body').attr('class', 'login-layout light-login');
                    $('#id-text2').attr('class', 'grey');
                    $('#id-company-text').attr('class', 'blue');

                    e.preventDefault();
                });
                $('#btn-login-blur').on('click', function (e) {
                    $('body').attr('class', 'login-layout blur-login');
                    $('#id-text2').attr('class', 'white');
                    $('#id-company-text').attr('class', 'light-blue');

                    e.preventDefault();
                });

            });
        </script>
    </body>
</html>

