package com.laptrinhweb.healthcare.controller;

import com.laptrinhweb.healthcare.model.MedicalFacility;
import com.laptrinhweb.healthcare.model.Time;
import com.laptrinhweb.healthcare.model.User;
import com.laptrinhweb.healthcare.services.DoctorService;
import com.laptrinhweb.healthcare.services.FacilityService;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author LuanPC
 */
@MultipartConfig
@WebServlet(name = "FacilityController", urlPatterns = {"/public-facility-list", "/admin-facility-list",
    "/admin-facility-detail", "/edit-facility", "/admin-facility-search",
    "/admin-add-facility", "/booking-schedule", "/facility-home", "/facility-add-schedule"})
public class FacilityController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int page = 1;
        String search = "";

        if (request.getServletPath().equals("/public-facility-list") || request.getServletPath().equals("/admin-specialty")) {
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }

            FacilityService facilityService = new FacilityService();

            request.setAttribute("facilities", facilityService.getListFacilities(page));
            request.setAttribute("noOfPages", facilityService.getNoOfPage(search));
            request.setAttribute("currentPage", page);

            if (request.getServletPath().equals("/public-facility-list")) {
                RequestDispatcher rd = request.getRequestDispatcher("Public/MedicalFacilityListPublic.jsp");
                rd.forward(request, response);
            }

        }

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

            MedicalFacility facility = facilityService.getFacilityDetail(facilityId);
            request.setAttribute("facility", facility);
            RequestDispatcher rd = request.getRequestDispatcher("Admin/MedicalFacility/FacilityDetail.jsp");
            rd.forward(request, response);
        }

        if (request.getServletPath().equals("/admin-add-facility")) {
            RequestDispatcher rd = request.getRequestDispatcher("Admin/MedicalFacility/AddFacility.jsp");
            rd.forward(request, response);
        }

        if (request.getServletPath().equals("/booking-schedule")) {
            int facilityId = Integer.parseInt(request.getParameter("facilityId"));
            DoctorService ds = new DoctorService();
            FacilityService fs = new FacilityService();
            request.setAttribute("times", fs.getAllTimes());
            request.setAttribute("doctors", ds.getDoctorsOfFacility(facilityId));
            request.setAttribute("facilityId", facilityId);
            RequestDispatcher rd = request.getRequestDispatcher("Medical Facility/BookingSchedule.jsp");
            rd.forward(request, response);
        }

        if (request.getServletPath().equals("/facility-home")) {
            HttpSession session = request.getSession();
            User u = (User) session.getAttribute("User");
            int facilityId = u.getId();
            request.setAttribute("facilityId", facilityId);
            RequestDispatcher rd = request.getRequestDispatcher("Medical Facility/HomeFacility.jsp");
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

        if (request.getServletPath().equals("/facility-add-schedule")) {

            //get value from ajax in BookingSchedule.jsp
            int doctorId = Integer.parseInt(request.getParameter("doctorId"));
            String scheduleDate = request.getParameter("selectedDate");

            //Json -> List object
            List times = Arrays.asList(request.getParameter("listTimeId").split("[\\p{Punct}\\s]+"));

            // Convert to List<Time>
            ArrayList<Time> listTime = new ArrayList<>();
            for (Object time : times) {
                Time t = new Time();
                if (!time.equals("")) {
                    t.setId(Integer.parseInt(String.valueOf(time)));
                    listTime.add(t);
                }
            }
            Date convertedCurrentDate = null;
            FacilityService fs = new FacilityService();

            java.util.Date d = new java.util.Date(scheduleDate);
            convertedCurrentDate = new java.sql.Date(d.getTime());

            int doctorWorkingInfoId = fs.getDoctorWorkingInfoId(doctorId);
            fs.addSchedule(doctorWorkingInfoId, convertedCurrentDate);
            int scheduleID = fs.getScheduleID(doctorWorkingInfoId, convertedCurrentDate);
            fs.addScheduleTime(scheduleID, listTime);
        }
    }

}
