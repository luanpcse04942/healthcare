package com.laptrinhweb.healthcare.controller;

import com.laptrinhweb.healthcare.dao.DoctorDAO;
import com.laptrinhweb.healthcare.dao.FacilityDAO;
import com.laptrinhweb.healthcare.dao.UserDAO;
import com.laptrinhweb.healthcare.dao.SpecialtyDAO;
import com.laptrinhweb.healthcare.model.MedicalFacility;
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

@WebServlet(name = "HomeController", urlPatterns = {"/trang-chu", "/dang-nhap"})
public class HomeController extends HttpServlet {

    private static final long serialVersionUID = 1L;

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
        if (request.getServletPath().equals("/dang-nhap")) {
             String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO accDao = new UserDAO();
        User acc = accDao.checkUserExist(username, password);
        if (acc == null) {
            doGet(request, response);
        }
        
        else switch (acc.getRoleId()) {
            case 1:
                {
                    RequestDispatcher rd = request.getRequestDispatcher("Admin/HomeAdmin.jsp");
                    rd.forward(request, response);
                    break;
                }
            case 2:
                {
                    RequestDispatcher rd = request.getRequestDispatcher("Doctor/HomeDoctor.jsp");
                    rd.forward(request, response);
                    break;
                }
            case 3:
                {
                    RequestDispatcher rd = request.getRequestDispatcher("Patient/HomePatient.jsp");
                    rd.forward(request, response);
                    break;
                }
            case 4:
                {
                    request.setAttribute("facilityId", acc.getId());
                    RequestDispatcher rd = request.getRequestDispatcher("Medical Facility/HomeFacility.jsp");
                    rd.forward(request, response);
                    break;
                }
            default:
                doGet(request, response);
                break;
        }
        }
    }

}
