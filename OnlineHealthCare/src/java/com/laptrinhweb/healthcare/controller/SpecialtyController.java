package com.laptrinhweb.healthcare.controller;

import com.laptrinhweb.healthcare.model.Specialty;
import com.laptrinhweb.healthcare.model.dto.ScheduleTimesDTO;
import com.laptrinhweb.healthcare.services.DoctorService;
import com.laptrinhweb.healthcare.services.SpecialtyService;
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
import java.io.PrintWriter;
import java.util.ArrayList;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.tomcat.util.codec.binary.Base64;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.laptrinhweb.healthcare.services.UserService;

/**
 *
 * @author LuanPC
 */
@MultipartConfig
@WebServlet(name = "SpecialtyController", urlPatterns = {"/public-specialty-list", "/public-specialty-detail", "/admin-specialty", "/admin-specialty-search",
    "/admin-add-specialty", "/add-specialty", "/admin-specialty-detail",
    "/edit-specialty", "/get-time-schedule", "/get-time", "/search-doctor-by-province"})
public class SpecialtyController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int page = 1;
        String search = "";

        if (request.getServletPath().equals("/public-specialty-list") || request.getServletPath().equals("/admin-specialty")) {
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }

            SpecialtyService specService = new SpecialtyService();

            request.setAttribute("specialties", specService.getListSpecialty(page));
            request.setAttribute("noOfPages", specService.getNoOfPage(search));
            request.setAttribute("currentPage", page);

            if (request.getServletPath().equals("/public-specialty-list")) {
                RequestDispatcher rd = request.getRequestDispatcher("Public/SpecialtyListPublic.jsp");
                rd.forward(request, response);
            }

            if (request.getServletPath().equals("/admin-specialty")) {
                RequestDispatcher rd = request.getRequestDispatcher("Admin/Specialty/SpecialtyList.jsp");
                rd.forward(request, response);
            }
        }
        if (request.getServletPath().equals("/admin-specialty-search")) {
            search = request.getParameter("search");

            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }
            SpecialtyService specialtyService = new SpecialtyService();

            request.setAttribute("specialties", specialtyService.getSpecialtySearchByName(page, search));
            request.setAttribute("noOfPages", specialtyService.getNoOfPage(search));
            request.setAttribute("currentPage", page);
            request.setAttribute("nameSearch", search);
            request.setAttribute("isSearching", true);
            RequestDispatcher rd = request.getRequestDispatcher("Admin/Specialty/SpecialtyList.jsp");
            rd.forward(request, response);
        }

        if (request.getServletPath().equals("/admin-add-specialty")) {
            RequestDispatcher rd = request.getRequestDispatcher("Admin/Specialty/AddSpecialty.jsp");
            rd.forward(request, response);
        }

        if (request.getServletPath().equals("/admin-specialty-detail")) {
            int specialtyId = Integer.parseInt(request.getParameter("specialtyId"));
            SpecialtyService specialtyService = new SpecialtyService();
            Specialty spec = specialtyService.getSpecialtyInfo(specialtyId);

            request.setAttribute("specialty", spec);
            RequestDispatcher rd = request.getRequestDispatcher("Admin/Specialty/SpecialtyDetail.jsp");
            rd.forward(request, response);
        }

        if (request.getServletPath().equals("/public-specialty-detail")) {
            DoctorService ds = new DoctorService();
            SpecialtyService ss = new SpecialtyService();
            UserService userService = new UserService();
            int specialtyId = Integer.parseInt(request.getParameter("specialtyId"));
            int provinceId = 0;
            request.setAttribute("scheduleDates", ds.getDoctorScheduleDates(specialtyId));
            request.setAttribute("doctors", ds.getDoctorsForSpecialtyDetail(specialtyId, provinceId));
            request.setAttribute("spec", ss.getSpecialtyInfo(specialtyId));
            request.setAttribute("provinces", userService.getAllProvinces());
            RequestDispatcher rd = request.getRequestDispatcher("Public/SpecialtyDetail.jsp");
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

        // Add specialty
        if (request.getServletPath().equals("/add-specialty")) {
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            Part filePart = request.getPart("file");
            String fileName = filePart.getSubmittedFileName();

            FileInputStream mFileInputStream = new FileInputStream("C:\\images\\Specialty\\" + fileName);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int bytesRead = 0;
            while ((bytesRead = mFileInputStream.read(b)) != -1) {
                bos.write(b, 0, bytesRead);
            }
            byte[] ba = bos.toByteArray();
            byte[] encoded = Base64.encodeBase64(ba);

            SpecialtyService specialtyService = new SpecialtyService();
            boolean addSpecSuccess = false;
            addSpecSuccess = specialtyService.addSpecialty(name, description, encoded);
            if (addSpecSuccess) {
                request.setAttribute("messageResponse", "Thêm mới thành công !");
                request.setAttribute("alert", "success");
            } else {
                request.setAttribute("messageResponse", "Thêm mới không thành công !");
                request.setAttribute("alert", "danger");
            }
            RequestDispatcher rd = request.getRequestDispatcher("Admin/Specialty/AddSpecialty.jsp");
            rd.forward(request, response);
        }

        // Update specialty info
        if (request.getServletPath().equals("/edit-specialty")) {
            int id = Integer.parseInt(request.getParameter("specialtyId"));
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            Part filePart = request.getPart("file");
            String fileName = filePart.getSubmittedFileName();
            boolean editSpecSuccess = false;
            SpecialtyService specialtyService = new SpecialtyService();

            if (fileName != "") {
                FileInputStream mFileInputStream = new FileInputStream("C:\\images\\Specialty\\" + fileName);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] b = new byte[1024];
                int bytesRead = 0;
                while ((bytesRead = mFileInputStream.read(b)) != -1) {
                    bos.write(b, 0, bytesRead);
                }
                byte[] ba = bos.toByteArray();
                byte[] encoded = Base64.encodeBase64(ba);
                editSpecSuccess = specialtyService.updateSpecialty(id, name, description, encoded);
            } else {
                editSpecSuccess = specialtyService.updateSpecialty(id, name, description, null);
            }
            if (editSpecSuccess) {
                request.setAttribute("messageResponse", "Update thành công !");
                request.setAttribute("alert", "success");
            } else {
                request.setAttribute("messageResponse", "Update không thành công !");
                request.setAttribute("alert", "danger");
            }

            Specialty spec = specialtyService.getSpecialtyInfo(id);
            request.setAttribute("specialty", spec);
            RequestDispatcher rd = request.getRequestDispatcher("Admin/Specialty/SpecialtyDetail.jsp");
            rd.forward(request, response);
        }
        
        if (request.getServletPath().equals("/get-time-schedule")) {
            int specialtyId = Integer.parseInt(request.getParameter("specialtyId"));
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            response.setHeader("Cache-control", "no-cache, no-store");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Expires", "-1");

            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "POST");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type");
            response.setHeader("Access-Control-Max-Age", "86400");
            Gson gson = new Gson();
            JsonObject myObj = new JsonObject();

            DoctorService ds = new DoctorService();
            ArrayList<ScheduleTimesDTO> arrs = ds.getScheduleTimes(specialtyId);
            JsonElement timeObj = gson.toJsonTree(arrs);
            myObj.add("listTime", timeObj);
            out.println(myObj.toString());
            out.close();
        }
        
        if (request.getServletPath().equals("/get-time")) {
            int scheduleId = Integer.parseInt(request.getParameter("scheduleID"));
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            response.setHeader("Cache-control", "no-cache, no-store");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Expires", "-1");

            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "POST");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type");
            response.setHeader("Access-Control-Max-Age", "86400");
            Gson gson = new Gson();
            JsonObject myObj = new JsonObject();

            DoctorService ds = new DoctorService();
            ArrayList<ScheduleTimesDTO> arrs = ds.getScheduleTimesOnChange(scheduleId);
            JsonElement timeObj = gson.toJsonTree(arrs);
            myObj.add("listTime", timeObj);
            out.println(myObj.toString());
            out.close();
        }
        
        if (request.getServletPath().equals("/search-doctor-by-province")) {
            DoctorService ds = new DoctorService();
            SpecialtyService ss = new SpecialtyService();
            UserService userService = new UserService();
            int specialtyId = Integer.parseInt(request.getParameter("specialtyID"));
            int provinceId = Integer.parseInt(request.getParameter("provinceID"));
            
            request.setAttribute("scheduleDates", ds.getDoctorScheduleDates(specialtyId));
            request.setAttribute("doctors", ds.getDoctorsForSpecialtyDetail(specialtyId, provinceId));
            request.setAttribute("spec", ss.getSpecialtyInfo(specialtyId));
            request.setAttribute("provinces", userService.getAllProvinces());
            RequestDispatcher rd = request.getRequestDispatcher("Public/SpecialtyDetail.jsp");
            rd.forward(request, response);
        }
    }
}
