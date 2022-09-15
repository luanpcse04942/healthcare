<link href="css/style.css" rel="stylesheet" type="text/css"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--begin of menu-->
<nav class="navbar navbar-expand-md navbar-light bg-warning">
    <div class="container">
        <a class="navbar-brand" href="home"> 
            <img src="img\_f2u__shiba_icon_by_luo_chan_dcx0jop.gif" />
        </a>
        <Strong class="navbar-brand" href="home" >PETTO</Strong>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
<!--            <ul class="navbar-nav m-auto">
                <c:if test ="${sessionScope.acc.isAdmin == 1}">
                </c:if>
                <c:if test ="${sessionScope.acc.isSell == 1}">
                    <li class="nav-item">
                        <a class="nav-link" href="manager">Manage Product</a>
                    </li>
                </c:if>
                <c:if test ="${sessionScope.acc != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Hello ${sessionScope.acc.user}!</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="logout">Logout</a>
                    </li>
                </c:if>
                <c:if test ="${sessionScope.acc == null}">
                    <li class="card auto-center">
                        <a class="nav-link" href="Login.jsp">Login</a>
                    </li>
                </c:if>
            </ul>-->
            <ul class="navbar-nav nav-flex-icons active">

                <c:if test ="${sessionScope.acc.isAdmin == 1}">
                </c:if>
                <c:if test ="${sessionScope.acc.isSell == 1}">
                    <li class="nav-item">
                        <a class="nav-link border border-light rounded waves-effect active" href="manager">Manage Product</a>
                    </li>
                </c:if>
                <c:if test ="${sessionScope.acc != null}">
                    <li class="nav-item">
                        <a href="logout" class="nav-link border border-light rounded waves-effect active  ">
                            <i class="fab fa-logout mr-0"></i>Logout of ${sessionScope.acc.user}
                        </a>
                    </li>
                </c:if>
                <c:if test ="${sessionScope.acc == null}">
                    <li class="nav-item">
                        <a href="Login.jsp" class="nav-link border border-light rounded waves-effect active" >
                            <i class="fab mr-0 "></i>Login
                        </a>
                    </li>
                </c:if>
                <li class="nav-item">
                    <a class="nav-link waves-effect " href="Cart.jsp">
                        <span class="badge red z-depth-1 mr-1">${order.size()}</span>
                        <i class="fa fa-shopping-cart"></i>
                        <span class="clearfix d-none d-sm-inline-block"> Cart </span>
                    </a>
                </li>
            </ul>
            <!--            <a class="btn btn-success btn-sm ml-3" href="Cart.jsp">
                            <i class="fa fa-shopping-cart"></i> Cart
                            <span class="badge badge-light">${order.size()}</span>
                        </a>-->
        </div>
    </div>
</nav>

<div class="navbar-img">
    <h1 class="navbar-img"><img src="img\paw paw.png" width=100%/></h1>
</div>
<!--end of menu-->
