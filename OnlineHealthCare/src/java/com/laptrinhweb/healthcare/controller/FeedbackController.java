package com.laptrinhweb.healthcare.controller;

import com.laptrinhweb.healthcare.services.DoctorService;
import com.laptrinhweb.healthcare.services.FeedbackService;
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
@WebServlet(name = "FeedbackController", urlPatterns = {"/doctor-feedback", "/medical-facility-feedback"})
public class FeedbackController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int page = 1;
        String search = "";
        if (request.getServletPath().equals("/doctor-feedback")) {
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }
            FeedbackService feedbackService = new FeedbackService();

            request.setAttribute("feedbacks", feedbackService.getListFeedbacks(page, 1));
            request.setAttribute("noOfPages", feedbackService.getNoOfPage(search));
            request.setAttribute("currentPage", page);
            RequestDispatcher rd = request.getRequestDispatcher("Doctor/DoctorFeedback.jsp");
            rd.forward(request, response);
        }
        if (request.getServletPath().equals("/medical-facility-feedback")) {
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }
            FeedbackService feedbackService = new FeedbackService();

            request.setAttribute("feedbacks", feedbackService.getListFeedbacks(page, 1));
            request.setAttribute("noOfPages", feedbackService.getNoOfPage(search));
            request.setAttribute("currentPage", page);
            RequestDispatcher rd = request.getRequestDispatcher("Medical Facility/DoctorFeedback.jsp");
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
