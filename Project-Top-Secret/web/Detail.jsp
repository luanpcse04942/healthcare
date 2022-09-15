<%-- 
    Document   : Detail
    Created on : Jul 1, 2022, 9:34:33 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Info</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <style>
            .gallery-wrap .img-big-wrap img {
                height: 450px;
                width: auto;
                display: inline-block;
                cursor: zoom-in;
            }


            .gallery-wrap .img-small-wrap .item-gallery {
                width: 60px;
                height: 60px;
                border: 1px solid #ddd;
                margin: 7px 2px;
                display: inline-block;
                overflow: hidden;
            }

            .gallery-wrap .img-small-wrap {
                text-align: center;
            }
            .gallery-wrap .img-small-wrap img {
                max-width: 100%;
                max-height: 100%;
                object-fit: cover;
                border-radius: 4px;
                cursor: zoom-in;
            }
            .img-big-wrap img{
                width: 100% !important;
                height: auto !important;
            }
        </style>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
            <div class="container">
            <jsp:include page="Left.jsp"></jsp:include>
                <main class="mt-5 pt-4">
                    <div class="container dark-grey-text mt-5">

                        <!--Grid row-->
                        <div class="row wow fadeIn">

                            <!--Grid column-->
                            <div class="col-md-6 mb-4">

                                <img src="${detail.image}" class="img-fluid" alt="">

                        </div>
                        <!--Grid column-->

                        <!--Grid column-->
                        <div class="col-md-6 mb-4">

                            <!--Content-->
                            <div class="p-4">


                                <p class="lead">
                                    <span>${detail.name}</span>
                                </p>

                                <p class="lead font-weight-bold">Description</p>

                                <p>${detail.description}</p>

                                <form class="d-flex justify-content-left">
                                    <!-- Default input -->
                                    <input type="number" value="1" aria-label="Search" class="form-control" style="width: 100px">
                                    <button class="btn btn-primary btn-md my-0 p" type="submit">Add to cart
                                        <i class="fas fa-shopping-cart ml-1"></i>
                                    </button>

                                </form>

                            </div>
                            <!--Content-->

                        </div>
                        <!--Grid column-->

                    </div>
                    <!--Grid row-->


                </div>
                <!--Grid row-->


            </main>
        </div>
    </div>
    <jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>
