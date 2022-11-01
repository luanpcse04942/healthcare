package com.laptrinhweb.healthcare.controller;

import com.laptrinhweb.healthcare.services.AppointmentService;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author LuanPC
 */
@WebServlet(name="AppointmentController", urlPatterns={"/AppointmentController", "/facility-appointment-search", "/Facility-Appointment-List"})
public class AppointmentController extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int page = 1;
        String search = "";
        if (request.getServletPath().equals("/Facility-Appointment-List")) {
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }
            AppointmentService appointmentService = new AppointmentService();
            request.setAttribute("appointment", appointmentService.getListAppointment(page));
            request.setAttribute("noOfPages", appointmentService.getNoOfPageAppointment(search));
            request.setAttribute("currentPage", page);
            RequestDispatcher rd = request.getRequestDispatcher("Medical Facility/Appointment/AppointmentFacility.jsp");
            rd.forward(request, response);
        }

        if (request.getServletPath().equals("/facility-appointment-search")) {
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }
            search = request.getParameter("codeSearch").trim();
            search = search.replaceAll("\\s+", " ");
            AppointmentService appointmentService = new AppointmentService();
            request.setAttribute("appointment", appointmentService.getAppointmentSearchByPatient(page, search));
            request.setAttribute("noOfPages", appointmentService.getNoOfPageAppointment(search));
            request.setAttribute("currentPage", page);
            request.setAttribute("nameSearch", search);
            request.setAttribute("isSearching", true);
            RequestDispatcher rd = request.getRequestDispatcher("Medical Facility/Appointment/AppointmentFacility.jsp");
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
