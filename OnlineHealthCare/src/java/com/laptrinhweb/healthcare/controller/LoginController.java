package com.laptrinhweb.healthcare.controller;

import com.laptrinhweb.healthcare.model.User;
import com.laptrinhweb.healthcare.services.LoginService;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "LoginController", urlPatterns = {"/login", "/register"})
public class LoginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getServletPath().equals("/login")) {

            String email = request.getParameter("email-login");
            String password = request.getParameter("password-login");

            LoginService lservice = new LoginService();
            User u = lservice.LoginWithEmail(email, password);

            if (u == null) {
                request.setAttribute("MessageLogin", "Tài khoản hoặc mật khẩu không đúng");
                RequestDispatcher rd = request.getRequestDispatcher("Public/Login.jsp");
                rd.include(request, response);
            } else {
                request.setAttribute("MessageLogin", null);
                HttpSession session = request.getSession();
                session.setAttribute("User", u);

                RequestDispatcher rd = request.getRequestDispatcher("Public/HomePage.jsp");
                rd.forward(request, response);
            }

        }

        if (request.getServletPath().equals("/register")) {

            String email = request.getParameter("email-reg");
            String password = request.getParameter("password-reg");

            String fname = request.getParameter("first-name");
            String lname = request.getParameter("last-name");

            LoginService lservice = new LoginService();

            if (!lservice.SimpleRegister(email, password, fname, lname)) {
                request.setAttribute("MessageLogin", "Đăng ký thất bại");
                RequestDispatcher rd = request.getRequestDispatcher("Public/Login.jsp");
                rd.include(request, response);
            } else {
                User u = lservice.LoginWithEmail(email, password);
                request.setAttribute("MessageLogin", null);
                HttpSession session = request.getSession();
                session.setAttribute("User", u);
                
                RequestDispatcher rd = request.getRequestDispatcher("Public/HomePage.jsp");
                rd.forward(request, response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
