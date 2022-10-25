<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="sidebar" class="sidebar responsive ace-save-state">
    <script type="text/javascript">
        try{ace.settings.loadState('sidebar')}catch(e){}
    </script>
    <div class="sidebar-shortcuts">
        <div class="sidebar-shortcuts-large">
            <button class="btn btn-success">
                <i class="ace-icon fa fa-signal"></i>
            </button>

            <button class="btn btn-info">
                <i class="ace-icon fa fa-pencil"></i>
            </button>

            <button class="btn btn-warning">
                <i class="ace-icon fa fa-users"></i>
            </button>

            <button class="btn btn-danger">
                <i class="ace-icon fa fa-cogs"></i>
            </button>
        </div>
        <div class="sidebar-shortcuts-mini">
            <span class="btn btn-success"></span>

            <span class="btn btn-info"></span>

            <span class="btn btn-warning"></span>

            <span class="btn btn-danger"></span>
        </div>
    </div>
    <ul class="nav nav-list">
        <li >
            <a href="<c:url value="/admin-home"/>" class="dropdown-toggle">
                <i class="menu-icon fa fa-list"></i>
                <span class="menu-text"></span>
                Trang quản lý
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li>
                    <a href='<c:url value="/admin-dashboard"/>'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        Bảng điều khiển
                    </a>
                    <b class="arrow"></b>
                </li>
                
                <li>
                    <a href='<c:url value="/admin-account"/>'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách tài khoản
                    </a>
                    <b class="arrow"></b>
                </li>
                <li>
                    <a href='#'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        Quản lý cẩm nang
                    </a>
                    <b class="arrow"></b>
                </li>
                
                <li>
                    <a href='<c:url value="/admin-facility-list"/>'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        Quản lý cơ sở y tế
                    </a>
                    <b class="arrow"></b>
                </li>
                <li>
                    <a href='<c:url value="/admin-specialty"/>'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        Quản lý chuyên khoa
                    </a>
                    <b class="arrow"></b>
                </li>
                
                <li>
                    <a href='#'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        Quản lý lịch hẹn
                    </a>
                    <b class="arrow"></b>
                </li>
                
                <li>
                    <a href='#'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        Quản lý phản hồi
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
    </ul>
    <div class="sidebar-toggle sidebar-collapse">
        <i class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
    </div>
</div>