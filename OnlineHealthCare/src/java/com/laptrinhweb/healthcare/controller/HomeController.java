package com.laptrinhweb.healthcare.controller;

import com.laptrinhweb.healthcare.dao.DoctorDAO;
import com.laptrinhweb.healthcare.dao.FacilityDAO;
import com.laptrinhweb.healthcare.dao.UserDAO;
import com.laptrinhweb.healthcare.dao.SpecialtyDAO;
import com.laptrinhweb.healthcare.model.MedicalFacility;
import com.laptrinhweb.healthcare.model.User;
import com.laptrinhweb.healthcare.model.Specialty;
import com.laptrinhweb.healthcare.services.LoginService;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LuanPC
 */
@WebServlet(name = "HomeController", urlPatterns = {"/trang-chu", "/dang-nhap"})
public class HomeController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        if (request.getServletPath().equals("/trang-chu")) {
            SpecialtyDAO specDAO = new SpecialtyDAO();
            ArrayList<Specialty> listSpecialty = specDAO.getAllSpecialty();

            FacilityDAO facDAO = new FacilityDAO();
            ArrayList<MedicalFacility> listFac = facDAO.getAllFacility();

            DoctorDAO doctorDAO = new DoctorDAO();
            ArrayList<User> listDoctor = doctorDAO.getAllDoctorPublic();

            request.setAttribute("listSpecialty", listSpecialty);
            request.setAttribute("listFacility", listFac);
            request.setAttribute("listDoctor", listDoctor);
            RequestDispatcher rd = request.getRequestDispatcher("Public/HomePage.jsp");
            rd.forward(request, response);
        }
        
        if (request.getServletPath().equals("/dang-nhap")) {
            String email = request.getParameter("email-login");
            String password = request.getParameter("password-login");
            
            LoginService lservice = new LoginService();
            User u = lservice.LoginWithEmail(email, password);
            
            if (u == null) {
                request.setAttribute("MessageLogin", "Email or Password is incorrect");
                RequestDispatcher rd = request.getRequestDispatcher("Public/Login.jsp");
                rd.forward(request, response);
            } else {
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
