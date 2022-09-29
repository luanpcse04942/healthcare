<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/bootstrap.min.css'/> " />
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/font-awesome/4.2.0/css/font-awesome.min.css' />" />

    <!-- page specific plugin styles -->
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/prettify.min.css' />" />

    <!-- text fonts -->
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/fonts/fonts.googleapis.com.css' />" />

    <!-- ace styles -->
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/ace.min.css' />" class="ace-main-stylesheet" id="main-ace-style" />

    <!--[if lte IE 9]>
            <link rel="stylesheet" href="assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
    <![endif]-->

    <!--[if lte IE 9]>
      <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
    <![endif]-->

    <!-- inline styles related to this page -->

    <!-- ace settings handler -->
    <script src="/template/admin/assets/js/ace-extra.min.js"></script>
</head>
<body class="no-skin">
    <div id="navbar" class="navbar navbar-default">
        <script type="text/javascript">
            try {
                ace.settings.check('navbar', 'fixed')
            } catch (e) {
            }
        </script>

        <div class="navbar-container" id="navbar-container">
            <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
                <span class="sr-only">Toggle sidebar</span>

                <span class="icon-bar"></span>

                <span class="icon-bar"></span>

                <span class="icon-bar"></span>
            </button>

            <div class="navbar-header pull-left">
                <a href="index.html" class="navbar-brand">
                    <small>
                        <i class="fa fa-leaf"></i>
                        Trang chủ
                    </small>
                </a>
            </div>

            <div class="navbar-buttons navbar-header pull-right" role="navigation">
                <ul class="nav ace-nav">
                    <li class="light-blue">
                        <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                            <img class="nav-user-photo" src="<c:url value='/template/admin/assets/avatars/avatar5.png' />" alt="" />
                            <span class="user-info">
                                <small>Xin chào,</small>
                                Luân
                            </span>

                            <i class="ace-icon fa fa-caret-down"></i>
                        </a>

                        <ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                            <li>
                                <a href="#">
                                    <i class="ace-icon fa fa-user"></i>
                                    Thông tin cá nhân
                                </a>
                            </li>

                            <li class="divider"></li>

                            <li>
                                <a href="<c:url value='/dang-nhap'/>">
                                    <i class="ace-icon fa fa-power-off"></i>
                                    Thoát ra
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div><!-- /.navbar-container -->
    </div>


    <script src="<c:url value='/template/admin/assets/js/jquery.2.1.1.min.js' />"></script>

    <script type="text/javascript">
            window.jQuery || document.write("<script src='<c:url value='/template/admin/assets/js/jquery.min.js' />" + "<" + "/script>");
    </script>

    <script type="text/javascript">
        if ('ontouchstart' in document.documentElement)
            document.write("<script src='/template/admin/assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
    </script>
    <script src="<c:url value='/template/admin/assets/js/bootstrap.min.js' />"></script>

    <!-- page specific plugin scripts -->
    <script src="<c:url value='/template/admin/assets/js/prettify.min.js' />"></script>

    <!-- ace scripts -->
    <script src="<c:url value='/template/admin/assets/js/ace-elements.min.js' />"></script>
    <script src="<c:url value='/template/admin/assets/js/ace.min.js' />"></script>

    <!-- inline scripts related to this page -->
    <script type="text/javascript">
        jQuery(function ($) {

            window.prettyPrint && prettyPrint();
            $('#id-check-horizontal').removeAttr('checked').on('click', function () {
                $('#dt-list-1').toggleClass('dl-horizontal').prev().html(this.checked ? '&lt;dl class="dl-horizontal"&gt;' : '&lt;dl&gt;');
            });

        })
    </script>
</body>

