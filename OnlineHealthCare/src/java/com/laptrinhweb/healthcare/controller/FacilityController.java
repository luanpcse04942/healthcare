package com.laptrinhweb.healthcare.controller;

import com.laptrinhweb.healthcare.services.FacilityService;
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
@WebServlet(name="FacilityController", urlPatterns={"/admin-facility-list"})
public class FacilityController extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int page = 1;
        String search = "";

        if (request.getServletPath().equals("/admin-facility-list")) {
             if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }
            FacilityService facilityService = new FacilityService();

            request.setAttribute("facilities", facilityService.getListFacilities(page));
            request.setAttribute("noOfPages", facilityService.getNoOfPage(search));
            request.setAttribute("currentPage", page);
            RequestDispatcher rd = request.getRequestDispatcher("Admin/MedicalFacility/FacilityList.jsp");
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
