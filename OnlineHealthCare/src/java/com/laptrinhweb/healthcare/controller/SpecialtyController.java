package com.laptrinhweb.healthcare.controller;

import com.laptrinhweb.healthcare.model.Specialty;
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
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 *
 * @author LuanPC
 */
@MultipartConfig
@WebServlet(name = "SpecialtyController", urlPatterns = {"/public-specialty-list", "/admin-specialty", "/admin-specialty-search",
                                                        "/admin-add-specialty", "/add-specialty", "/admin-specialty-detail",
                                                        "/edit-specialty"})
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

            String path = request.getServletContext().getRealPath("/static/images/Specialty/" + fileName);
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
            
            SpecialtyService specialtyService = new SpecialtyService();
            boolean addSpecSuccess = false;
            addSpecSuccess = specialtyService.addSpecialty(name, description, fileName);
            if(addSpecSuccess) {
                request.setAttribute("messageResponse", "Thêm mới thành công !");
                request.setAttribute("alert", "success");
            }else {
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

            String path = request.getServletContext().getRealPath("/static/images/Specialty/" + fileName);
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
            
            SpecialtyService specialtyService = new SpecialtyService();
            boolean editSpecSuccess = false;
            editSpecSuccess = specialtyService.updateSpecialty(id, name, description, fileName);
            if(editSpecSuccess) {
                request.setAttribute("messageResponse", "Thêm mới thành công !");
                request.setAttribute("alert", "success");
            }else {
                request.setAttribute("messageResponse", "Thêm mới không thành công !");
                request.setAttribute("alert", "danger");
            }
            RequestDispatcher rd = request.getRequestDispatcher("Admin/Specialty/AddSpecialty.jsp");
            rd.forward(request, response);
            
        }
    }
}
