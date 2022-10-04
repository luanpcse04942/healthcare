package com.laptrinhweb.healthcare.controller;

import com.laptrinhweb.healthcare.model.User;
import com.laptrinhweb.healthcare.services.DoctorService;
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
@WebServlet(name = "DoctorController", urlPatterns = {"/doctor-list-public", "/public-doctor-search"})
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
