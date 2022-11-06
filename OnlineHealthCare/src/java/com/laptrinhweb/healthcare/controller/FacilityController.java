package com.laptrinhweb.healthcare.controller;

import com.laptrinhweb.healthcare.model.MedicalFacility;
import com.laptrinhweb.healthcare.model.Time;
import com.laptrinhweb.healthcare.services.DoctorService;
import com.laptrinhweb.healthcare.services.FacilityService;
import com.laptrinhweb.healthcare.services.PatientService;
import com.laptrinhweb.healthcare.services.UserService;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 *
 * @author LuanPC
 */
@MultipartConfig
@WebServlet(name = "FacilityController", urlPatterns = {"/public-facility-list", "/public-facility-detail", "/facility-patient-list", "/facility-patient-detail", "/admin-facility-list", "/admin-facility-detail", "/edit-facility",
    "/admin-facility-search", "/admin-add-facility", "/booking-schedule", "/facility-home", "/facility-add-schedule", "/add-facility"})
public class FacilityController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int page = 1;
        String search = "";

        if (request.getServletPath().equals("/public-facility-list")) {
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }

            FacilityService facilityService = new FacilityService();

            request.setAttribute("facilities", facilityService.getListFacilities(page));
            request.setAttribute("noOfPages", facilityService.getNoOfPage(search));
            request.setAttribute("currentPage", page);

            RequestDispatcher rd = request.getRequestDispatcher("Public/MedicalFacilityListPublic.jsp");
            rd.forward(request, response);

        }

        if (request.getServletPath().equals("/public-facility-detail")) {
            int facilityId = Integer.parseInt(request.getParameter("facilityId"));

            FacilityService facilityService = new FacilityService();
            MedicalFacility facility = facilityService.getFacilityDetail(facilityId);
            request.setAttribute("facility", facility);

            RequestDispatcher rd = request.getRequestDispatcher("Public/FacilityDetail.jsp");
            rd.forward(request, response);
        }
        
        if (request.getServletPath().equals("/facility-patient-list")) {
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }
            UserService userService = new UserService();

            request.setAttribute("patients", userService.getListAccounts(page));
            request.setAttribute("noOfPages", userService.getNoOfPage(search));
            request.setAttribute("currentPage", page);
            RequestDispatcher rd = request.getRequestDispatcher("Medical Facility/Patient/PatientList.jsp");
            rd.forward(request, response);
        }

        if (request.getServletPath().equals("/facility-patient-detail")) {
            int userId = Integer.parseInt(request.getParameter("userId"));
            UserService userService = new UserService();
            request.setAttribute("account", userService.getAccountDetail(userId));
            RequestDispatcher rd = request.getRequestDispatcher("Medical Facility/Patient/PatientDetail.jsp");
            rd.forward(request, response);
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
//            int facilityId = Integer.parseInt(request.getParameter("facilityId"));
//            request.setAttribute("facilityId", facilityId);
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

        if (request.getServletPath().equals("/add-facility")) {
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String phonenumber = request.getParameter("phonenumber");
            String address = request.getParameter("address");
            Part filePart = request.getPart("file");
            String fileName = filePart.getSubmittedFileName();

            FileInputStream mFileInputStream = new FileInputStream("C:\\images\\Facility\\" + fileName);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int bytesRead = 0;
            while ((bytesRead = mFileInputStream.read(b)) != -1) {
                bos.write(b, 0, bytesRead);
            }
            byte[] ba = bos.toByteArray();
            byte[] encoded = Base64.encodeBase64(ba);

            FacilityService facilityService = new FacilityService();
            boolean addSpecSuccess = false;
            addSpecSuccess = facilityService.addFacility(name, description, email, password, phonenumber, address, encoded);
            if (addSpecSuccess) {
                request.setAttribute("messageResponse", "Thêm mới thành công !");
                request.setAttribute("alert", "success");
            } else {
                request.setAttribute("messageResponse", "Thêm mới không thành công !");
                request.setAttribute("alert", "danger");
            }
            RequestDispatcher rd = request.getRequestDispatcher("Admin/MedicalFacility/AddFacility.jsp");
            rd.forward(request, response);
        }
    }

}
