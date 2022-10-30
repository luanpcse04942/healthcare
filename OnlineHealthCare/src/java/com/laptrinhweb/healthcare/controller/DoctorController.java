package com.laptrinhweb.healthcare.controller;

import com.laptrinhweb.healthcare.model.User;
import com.laptrinhweb.healthcare.services.AppointmentService;
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
 * @author NhatDV
 */
@WebServlet(name = "DoctorController", urlPatterns = {"/doctor-list-public", "/public-doctor-search",
    "/doctor-patient-list", "/doctor-patient-search", "/doctor-patient-detail", "/doctor-appointment-detail",
    "/doctor-appointment-list"})
public class DoctorController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int page = 1;
        String search = "";

        if (request.getServletPath().equals("/doctor-list-public")) {
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }
            DoctorService doctorService = new DoctorService();

            request.setAttribute("accounts", doctorService.getListAccounts(page));
            request.setAttribute("noOfPages", doctorService.getNoOfPage(search));
            request.setAttribute("currentPage", page);
            RequestDispatcher rd = request.getRequestDispatcher("Public/DoctorListPublic.jsp");
            rd.forward(request, response);
        }

        if (request.getServletPath().equals("/public-doctor-search")) {
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }
            search = request.getParameter("codeSearch").trim();
            search = search.replaceAll("\\s+", " ");
            DoctorService doctorService = new DoctorService();
            List<User> u = doctorService.getDoctorsSearchByName(page, search);
            request.setAttribute("accounts", doctorService.getDoctorsSearchByName(page, search));
            request.setAttribute("noOfPages", doctorService.getNoOfPage(search));
            request.setAttribute("currentPage", page);
            request.setAttribute("nameSearch", search);
            request.setAttribute("isSearching", true);
            RequestDispatcher rd = request.getRequestDispatcher("Public/DoctorListPublic.jsp");
            rd.forward(request, response);
        }
        
        if (request.getServletPath().equals("/doctor-patient-list")) {
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }
            PatientService patientService = new PatientService();

            request.setAttribute("accounts", patientService.getListAccounts(page, 1));
            request.setAttribute("noOfPages", patientService.getNoOfPage(search));
            request.setAttribute("currentPage", page);
            RequestDispatcher rd = request.getRequestDispatcher("Doctor/PatientList.jsp");
            rd.forward(request, response);
        }

        if (request.getServletPath().equals("/doctor-patient-search")) {
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }
            
            search = request.getParameter("NameSearch").trim();
            search = search.replaceAll("\\s+", " ");

            PatientService patientService = new PatientService();

            request.setAttribute("accounts", patientService.getPatientsSearchByName(1, page, search));
            request.setAttribute("noOfPages", patientService.getNoOfPage(search));
            request.setAttribute("currentPage", page);
            request.setAttribute("nameSearch", search);
            request.setAttribute("isSearching", true);
            RequestDispatcher rd = request.getRequestDispatcher("Doctor/PatientList.jsp");
            rd.forward(request, response);
        }
        
        if (request.getServletPath().equals("/doctor-patient-detail")) {
            int userId = Integer.parseInt(request.getParameter("userId"));
            UserService userService = new UserService();
            request.setAttribute("account", userService.getAccountDetail(userId));
            RequestDispatcher rd = request.getRequestDispatcher("Doctor/PatientDetail.jsp");
            rd.forward(request, response);
        }
        
        if (request.getServletPath().equals("/doctor-appointment-detail")) {
            int userId = Integer.parseInt(request.getParameter("userId"));
            int appointID = Integer.parseInt(request.getParameter("appointId"));
            UserService userService = new UserService();
            AppointmentService appointmentService = new AppointmentService();
            request.setAttribute("account", userService.getAccountDetail(userId));
            request.setAttribute("appoints", appointmentService.getAppointmentDetail(appointID));
            RequestDispatcher rd = request.getRequestDispatcher("Doctor/AppointmentDetail.jsp");
            rd.forward(request, response);
        }
        
        if (request.getServletPath().equals("/doctor-appointment-list")) {
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }
            AppointmentService appointmentService = new AppointmentService();

            request.setAttribute("appoints", appointmentService.getListAccounts(page, 1));
            request.setAttribute("noOfPages", appointmentService.getNoOfPage(search));
            request.setAttribute("currentPage", page);
            RequestDispatcher rd = request.getRequestDispatcher("Doctor/AppointmentList.jsp");
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
