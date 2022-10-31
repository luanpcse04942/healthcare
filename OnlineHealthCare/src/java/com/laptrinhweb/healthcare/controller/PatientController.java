package com.laptrinhweb.healthcare.controller;

import com.laptrinhweb.healthcare.model.User;
import com.laptrinhweb.healthcare.model.dto.PatientSmall;
import com.laptrinhweb.healthcare.services.DoctorService;
import com.laptrinhweb.healthcare.services.PatientService;
import com.laptrinhweb.healthcare.services.UserService;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author LuanPC
 */
@WebServlet(name = "PatientController", urlPatterns = {"/patient-home"})
public class PatientController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getServletPath().equals("/patient-home")) {
            RequestDispatcher rd = request.getRequestDispatcher("Patient/HomePatient.jsp");
            rd.forward(request, response);
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

}
