package com.laptrinhweb.healthcare.controller;

import com.laptrinhweb.healthcare.dao.UserDAO;
import com.laptrinhweb.healthcare.dao.SpecialtyDAO;
import com.laptrinhweb.healthcare.model.User;
import com.laptrinhweb.healthcare.model.Specialty;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LuanPC
 */

@WebServlet(name = "HomeController", urlPatterns = {"/trang-chu","/dang-nhap","/dang-ki"})
public class HomeController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        if (request.getServletPath().equals("/trang-chu")) {
            SpecialtyDAO specDAO = new SpecialtyDAO();
            ArrayList<Specialty> listSpecialty = specDAO.getAllSpecialty();
            request.setAttribute("listSpecialty", listSpecialty);
            RequestDispatcher rd = request.getRequestDispatcher("Public/HomePage.jsp");
            rd.forward(request, response);
        }
        if (request.getServletPath().equals("/dang-nhap")) {
            
            RequestDispatcher rd = request.getRequestDispatcher("Public/Login.jsp");
            rd.forward(request, response);
        }
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // TODO Auto-generated method stub
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //đăng nhập
        if (request.getServletPath().equals("/dang-nhap")) {
        //get username va password 
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //Gọi tới dao của user
        UserDAO userDao = new UserDAO();
        //gọi tới hàm login
        User a = userDao.Login(username, password);
        //kiểm tra
        if(a==null)
        //tức là login fail
        {
            request.setAttribute("mess", "Wrong Username or Password!!!");
            //đẩy về trang login, bắt login lại
            request.getRequestDispatcher("Public/Login.jsp").forward(request, response);
        }
        else //đăng nhập thành công
        {
            //đảy về trang home
             request.getRequestDispatcher("Public/HomePage.jsp").forward(request, response);
        }
        
        //--------------------------------------------------------------------------------------------------------------------------------
        //đăng kí
        if (request.getServletPath().equals("/dang-ki")) {
            String registerName = request.getParameter("username");
            String registerPass= request.getParameter("password");
            String registerRepass = request.getParameter("repassword");
            if(!registerPass.equals(registerRepass))
            {
                request.setAttribute("messS", "Check Info Again");
                //nếu pass != repass
                request.getRequestDispatcher("Public/Login.jsp").forward(request, response);
            }
            else
            {
                //pass = repass
                UserDAO dao = new UserDAO();
                User b = dao.checkAccountExist(registerName);
                if(b==null)
                {
                    //username đăng kí chưa có trong database
                    //được phép signup
                    dao.SignUp(registerName, registerPass);
                    request.getRequestDispatcher("Admin/HomeAdmin.jsp").forward(request, response);
                    
                }
                else
                {
                    
                    //đẩy về trang login, bắt ng dùng nhập lại form
                     request.getRequestDispatcher("Public/Login.jsp").forward(request, response);
                     
                }
            }
            
                    
            
        }
    

        
             
        
        
        
        
        
//        UserDAO accDao = new UserDAO();
//        User acc = accDao.checkUserExist(username, password);
//        if (acc == null) {
//            doGet(request, response);
//        }
//        
//        else switch (acc.getRoleId()) {
//            case 1:
//                {
//                    RequestDispatcher rd = request.getRequestDispatcher("Admin/HomeAdmin.jsp");
//                    rd.forward(request, response);
//                    break;
//                }
//            case 2:
//                {
//                    RequestDispatcher rd = request.getRequestDispatcher("Doctor/HomeDoctor.jsp");
//                    rd.forward(request, response);
//                    break;
//                }
//            case 3:
//                {
//                    RequestDispatcher rd = request.getRequestDispatcher("Patient/HomePatient.jsp");
//                    rd.forward(request, response);
//                    break;
//                }
//            case 4:
//                {
//                    RequestDispatcher rd = request.getRequestDispatcher("Medical Facility/HomeFacility.jsp");
//                    rd.forward(request, response);
//                    break;
//                }
//            default:
//                doGet(request, response);
//                break;
//        }
        }
    }

}
