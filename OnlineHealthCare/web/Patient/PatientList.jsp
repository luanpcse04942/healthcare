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

                        <tbody class="align-middle">
                            <tr>
                                <th scope="row">1</th>
                                <td>Nguyễn Văn A</td>
                                <td>0963562002</td>
                                <td>20/09/2022</td>
                                <td>Đã khám xong</td>
                                <td>
                                    <!-- Button trigger modal -->
                                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#detailPatient">
                                        Xem chi tiết
                                    </button>

                                    <!-- Modal -->
                                    <div class="modal fade" id="detailPatient" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" 
                                         aria-labelledby="staticBackdropLabel" aria-hidden="true">
                                        <div class="modal-dialog modal-dialog-centered modal-lg">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="staticBackdropLabel">Thông tin bệnh nhân</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    <h2>Thông tin bệnh nhân</h2>

                                                    <!-- Personal Information -->
                                                    <h6 class="text-start text-decoration-underline mb-3">
                                                        Thông tin cá nhân
                                                    </h6>
                                                    <div class="container w-100 text-start">
                                                        <div class="row">
                                                            <div class="col-4">
                                                                <p>Họ và tên: Nguyễn Văn A</p>
                                                            </div>
                                                            <div class="col-4">
                                                                <p>Giới tính: Nam</p>
                                                            </div>
                                                            <div class="col-4">
                                                                <p>Email: nguyenvana@gmail.com</p>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-4">
                                                                <p>Ngày sinh: 02/12/1978</p>
                                                            </div>
                                                            <div class="col-4">
                                                                <p>Số điện thoại: 0963562002</p>
                                                            </div>
                                                            <div class="col-4">
                                                                <p>Địa chỉ: Hà Nội</p>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <!-- Appointment schedule -->
                                                    <h6 class="text-start text-decoration-underline mb-3">
                                                        Danh sách lịch hẹn
                                                    </h6>
                                                    <table class="table table-striped text-center">
                                                        <thead>
                                                            <tr>
                                                                <th scope="col">ID</th>
                                                                <th scope="col">Ngày</th>
                                                                <th scope="col">Thời gian chi tiết</th>
                                                            </tr>
                                                        </thead> 
                                                        <tbody>
                                                            <tr>
                                                                <th scope="row">1</th>
                                                                <td>22/09/2022</td>
                                                                <td>8:00 - 9:00</td>  
                                                            </tr> 
                                                        </tbody>

                                                    </table>

                                                </div>
                                            </div>
                                        </div>
                                    </div>

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
