
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!--Navbar-->
<nav class="navbar navbar-expand-lg navbar-light bg-warning  lighten-3 mt-3 mb-5">

    <!-- Navbar brand -->
    <span class="navbar-brand">Categories:</span>

    <!-- Collapse button -->
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#basicExampleNav" aria-controls="basicExampleNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <!-- Collapsible content -->
    <div class="collapse navbar-collapse" id="basicExampleNav">

        <!-- Links -->
        <ul class="navbar-nav mr-auto ">
            <li class="nav-item ${tag == o.cid ?"active":""}">
                <a class="nav-link" href="home">All
                    <span class="sr-only">(current)</span>
                </a>
            </li>
            <c:forEach items="${listC}" var="o">
                <li class="nav-item">
                    <a class="nav-link list-item  ${tag == o.cid ?"active":""}" href="category?cid=${o.cid}">${o.cname}</a>
                </li>
            </c:forEach>

        </ul>
        <!-- Links -->

        <form action="search" method="post" class="form-inline">
            <div class="md-form my-0">
                <input class="form-control mr-sm-2" value="${txtS}" name="txt" type="text" placeholder="Search" aria-label="Search">
                <button type="submit" class="btn btn-secondary btn-number">
                    <i class="fa fa-search"></i>
                </button>
            </div>
        </form>
    </div>
    <!-- Collapsible content -->

</nav>
<!--/.Navbar-->
