package com.laptrinhweb.healthcare.controller;

import com.laptrinhweb.healthcare.model.MedicalFacility;
import com.laptrinhweb.healthcare.services.FacilityService;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 *
 * @author LuanPC
 */
@MultipartConfig
@WebServlet(name="FacilityController", urlPatterns={"/admin-facility-list", "/admin-facility-detail", "/edit-facility",
            "/admin-facility-search", "/admin-add-facility"})
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
        
        if (request.getServletPath().equals("/admin-facility-search")) {
              search = request.getParameter("search");

            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }

            FacilityService facilityService = new FacilityService();

            request.setAttribute("facilities", facilityService.getFacilitiesSearchByName(page, search));
            request.setAttribute("noOfPages", facilityService.getNoOfPage(search));
            request.setAttribute("currentPage", page);
            request.setAttribute("nameSearch", search);
            request.setAttribute("isSearching", true);
            RequestDispatcher rd = request.getRequestDispatcher("Admin/MedicalFacility/FacilityList.jsp");
            rd.forward(request, response);
         }
        
        if (request.getServletPath().equals("/admin-facility-detail")) {
            
            int facilityId = Integer.parseInt(request.getParameter("facilityId"));
            FacilityService facilityService = new FacilityService();
            
            MedicalFacility facility =  facilityService.getFacilityDetail(facilityId);
            request.setAttribute("facility", facility);
            RequestDispatcher rd = request.getRequestDispatcher("Admin/MedicalFacility/FacilityDetail.jsp");
            rd.forward(request, response);
        }
        
        if (request.getServletPath().equals("/admin-add-facility")) {
            RequestDispatcher rd = request.getRequestDispatcher("Admin/MedicalFacility/AddFacility.jsp");
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
         if (request.getServletPath().equals("/edit-facility")) {
             int facilityId = Integer.parseInt(request.getParameter("facilityId"));
            String name = request.getParameter("name");
            String phoneNumber = request.getParameter("phoneNumber");
            String description = request.getParameter("description");
            String address = request.getParameter("address");
            
            Part filePart = request.getPart("file");
            String fileName = filePart.getSubmittedFileName();
            
            String path = request.getServletContext().getRealPath("/static/images/avatars/" + fileName);
            FileOutputStream fops = new FileOutputStream(path);
            InputStream is = filePart.getInputStream();
            try {
                byte[] byt = new byte[is.available()];
                is.read();
                fops.write(byt);
                fops.close();
                System.out.println(path);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
         }
         
         
    }
    
}
