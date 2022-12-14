package com.laptrinhweb.healthcare.controller;

import com.laptrinhweb.healthcare.model.User;
import com.laptrinhweb.healthcare.model.dto.PatientSmall;
import com.laptrinhweb.healthcare.services.DoctorService;
import com.laptrinhweb.healthcare.services.PatientService;
import com.laptrinhweb.healthcare.services.UserService;
import dto.AppointmentPatient;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LuanPC
 */
@WebServlet(name = "PatientController", urlPatterns = {"/public-booking-appointment", "/Patient-Appointment-List", "/appointment-patient-home","/Patient-Appointment-search"})
public class PatientController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int page = 1;
        String search = "";

        if (request.getServletPath().equals("/public-booking-appointment")) {
            RequestDispatcher rd = request.getRequestDispatcher("Public/BookingAppointment.jsp");
            rd.forward(request, response);
        }

        if (request.getServletPath().equals("/appointment-patient-home")) {
            RequestDispatcher rd = request.getRequestDispatcher("Patient/HomePatient.jsp");
            rd.forward(request, response);
        }

        if (request.getServletPath().equals("/Patient-Appointment-List")) {
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }
            PatientService patientService = new PatientService();
            List<AppointmentPatient> a = new ArrayList<>();
            a = patientService.getListAppointment(page);
            request.setAttribute("appointment", patientService.getListAppointment(page));
            request.setAttribute("noOfPages", patientService.getNoOfPageAppointment(search));
            request.setAttribute("currentPage", page);
            request.setAttribute("isSearching", true);
            RequestDispatcher rd = request.getRequestDispatcher("Patient/AppointmentPatient.jsp");
            rd.forward(request, response);
        }

        if (request.getServletPath().equals("/Patient-Appointment-search")) {
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }
            
            search = request.getParameter("codeSearch").trim();
            search = search.replaceAll("\\s+", " ");
            PatientService patientService = new PatientService();
            List<AppointmentPatient> a = new ArrayList<>();
            a = patientService.getListAppointment(page);
            request.setAttribute("appointment", patientService.searchListAppointment(page,search));
            request.setAttribute("noOfPages", patientService.getNoOfPageAppointment(search));
            request.setAttribute("currentPage", page);
            request.setAttribute("isSearching", true);
            RequestDispatcher rd = request.getRequestDispatcher("Patient/AppointmentPatient.jsp");
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
