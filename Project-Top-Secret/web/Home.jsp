<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Petto</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
            <!--            <div class="container">
                            <div class="row">
                                <div class="col">
                                    <nav aria-label="breadcrumb">
                                        <ol class="breadcrumb">
                                            <li class="breadcrumb-item"><a href="home">Home</a></li>
                                            <li class="breadcrumb-item"><a href="#">Category</a></li>
                                            <li class="breadcrumb-item active" aria-current="#">Sub-category</li>
                                        </ol>
                                    </nav>
                                </div>
                            </div>
                        </div>-->


            <div class="container">
                <div class="container">
                <jsp:include page="Left.jsp"></jsp:include>
                    <div class="text-center mb-4">
                        <div class="row wow fadeIn">
                        <c:forEach items="${listP}" var="o">
                            <div class="col-lg-4 col-md-6 mb-3">
                                <div class="card">
                                    <img class="card-img-top" src="${o.image} " alt="Card image cap"> <!--
                                              <div class="card-body">
                                                        <h4 class="card-title show_txt"><a href="detail?pid=${o.id}" title="View">${o.name}</a></h4>
                                    <p class="card-text show_txt">${o.title}</p>
<!--                                    <div class="row">
                                        <div class="col">
                                            <p class="btn btn-danger btn-block">${o.price} $</p>
                                        </div>
                                        <div class="col">
                                            <a href="#" class="btn btn-success btn-block">Add to cart</a>
                                        </div>
                                    </div>
                                </div>-->
                                    <div class="card-body text-center auto-margin ">
                                    <!--Category & Title-->
                                    <a href="detail?pid=${o.id}" class="text-grey" title="View">
                                        <h5>${o.name}</h5>
                                    </a>
                                    <h5>
                                        <strong>
                                            <p href="detail?pid=${o.id}" class="card-text show_txt">${o.title}</p>
                                        </strong>
                                    </h5>

                                    <h4 class="font-weight-bold blue-text text-warning">
                                        <bold>${o.price} $</bold>
                                    </h4>

                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="col-12 copyright mt-3">
                <p class="float-right">
                    <a href="home"> 
                        <img src="https://tinyurl.com/2p86zsw5" width="40" height="40"/></a>
            </div>
        </div>
    </div>



    <!--Pagination-->
    <nav class="d-flex justify-content-center wow fadeIn">
        <ul class="pagination pg-blue">

            <!--Arrow left-->
            <li class="page-item disabled">
                <a class="page-link" href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                    <span class="sr-only">Previous</span>
                </a>
            </li>

            <li class="page-item active">
                <a class="page-link" href="#">1
                    <span class="sr-only">(current)</span>
                </a>
            </li>
            <li class="page-item">
                <a class="page-link" href="#">2</a>
            </li>
            <li class="page-item">
                <a class="page-link" href="#">3</a>
            </li>
            <li class="page-item">
                <a class="page-link" href="#">4</a>
            </li>
            <li class="page-item">
                <a class="page-link" href="#">5</a>
            </li>

            <li class="page-item">
                <a class="page-link" href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                    <span class="sr-only">Next</span>
                </a>
            </li>
        </ul>
    </nav>
    <!--Pagination-->



    <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>


