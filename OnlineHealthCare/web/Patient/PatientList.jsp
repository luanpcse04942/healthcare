<%-- 
    Document   : PatientList
    Created on : Oct 1, 2022, 7:25:37 PM
    Author     : Y545
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!-- Boostrap Css -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">

        <!-- Google Font -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Oswald&display=swap" rel="stylesheet">

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" rel="stylesheet">

        <!-- Css -->
        <link rel="stylesheet" href="../css/patient/patientList.css">

        <title>Danh sách tài khoản bệnh nhân</title>
    </head>
    <body>
        <header>
            <div class="container-fluid">
                <div class="row">

                    <!-- Logo -->
                    <div class="col-md-6">
                        <a href="#" class="text-decoration-none" id="logo">
                            <h1>Heath Care</h1>
                        </a>
                    </div>

                    <!-- Avatar -->
                    <div class="col-md-6 wrapper-avatar">
                        <a href="#" class="text-decoration-none ">
                            Bác sĩ, Phí Công Luân
                        </a>
                        <div>
                            <a href="#">
                                <img class="avatar img-responsive rounded-circle" src="https://source.unsplash.com/random/avatar"/> 
                            </a>
                        </div>
                    </div>

                </div>
            </div>
        </header>

        <main class="container-fluid">
            <div class="row">

                <!-- Sidebar -->
                <article class="col-md-3 p-4">
                    <div class="list-group">
                        <a href="#" class="list-group-item list-group-item-action">
                            Lịch hẹn của tôi 
                        </a> 
                        <a href="#" class="list-group-item list-group-item-action active">
                            Bệnh nhân của tôi 
                        </a>  
                        <a href="#" class="list-group-item list-group-item-action">
                            Phản hồi của bệnh nhân
                        </a> 
                    </div>
                </article> 

                <!-- Search Bar -->
                <div class="col-md-6 d-flex align-items-center justify-content-center">
                    <div class="input-group">
                        <input class="w-90 rounded form-control" type="text" 
                               placeholder="Tìm tên bệnh nhân..."
                               aria-label="search" aria-describedby="search">
                        <a class="input-group-text rounded text-decoration-none" href="#">
                            <i class="fa-solid fa-magnifying-glass"></i>
                        </a>
                    </div>
                </div>

                <!-- Filter -->
                <div class="col-md-1 d-flex align-items-center justify-content-center">
                    <button type="button" class="w-100 btn btn-primary">Lọc</button>
                </div>

            </div>

            <!-- Patient List -->
            <div class="row d-flex justify-content-center mt-3">
                <div class="col-8">
                    <table class="table table-striped text-center">
                        <thead>
                            <tr>
                                <th scope="col">No.</th>
                                <th scope="col">Tên bệnh nhân</th>
                                <th scope="col">Số điện thoại</th>
                                <th scope="col">Ngày đặt lịch</th>
                                <th scope="col">Trạng thái</th>
                                <th scope="col"></th>
                            </tr>
                        </thead>

                        </thead>
                        <tbody class="align-middle">
                            <tr>
                                <th scope="row">1</th>
                                <td>Nguyễn Văn A</td>
                                <td>0963562002</td>
                                <td>20/09/2022</td>
                                <td>Đã khám xong</td>
                                <td>
                                    <button type="button" class="btn btn-primary">
                                        Xem chi tiết
                                    </button>
                                </td>
                            </tr>
                        </tbody>

                    </table> 
                </div>
            </div>
        </main>

        <!-- Boostrap Jquery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

        <!-- Boostrap js -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
