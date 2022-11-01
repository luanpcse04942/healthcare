<%-- 
    Document   : userprofile
    Created on : Nov 1, 2022, 9:41:24 PM
    Author     : Y545
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="template/login/assets/css/bootstrap.min.css" />
        <link rel="stylesheet" href="template/login/assets/font-awesome/4.2.0/css/font-awesome.min.css" />
        <link rel="stylesheet" href="css/patient/profile.css" />
        <title>Trang cá nhân</title>
    </head>
    <body>
        <div class="container-flex rounded bg-white mt-5 mb-5">
            <div class="row" style="width: 100%">
                <div class="justify-content-between align-items-center text-center">
                    <h1 class="h1">Trang cá nhân</h1>
                </div>
                <div class="col-md-3 border-right">
                    <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                        <img class="rounded-circle mt-5" width="150px" 
                             alt="Alex's Avatar" id="avatar2" src="template/admin/assets/avatars/profile-pic.jpg" />                       
                        <p class="text-black-50">Bác sĩ</p>
                    </div>
                </div>
                <div class="col-md-9 border-right">
                    <div class="row mt-2 justify-content-between">
                        <div class="col-md-3"><label class="labels">Họ: </label>
                            Mai
                        </div>
                        <div class="col-md-3"><label class="labels">Tên: </label>
                            Việt Hùng
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-md-12"><label class="labels">Số điện thoại: </label>
                            0963562002
                        </div>
                        <div class="col-md-12"><label class="labels">Địa chỉ: </label>

                        </div>
                        <div class="col-md-12"><label class="labels">Email: </label>

                        </div>
                        <div class="col-md-12"><label class="labels">Giới tính: </label>
                            Nam
                        </div>
                    </div>            
                </div>

            </div>
        </div>
    </body>
</html>
