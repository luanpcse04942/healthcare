package com.laptrinhweb.healthcare.controller;

import com.laptrinhweb.healthcare.dao.FeedbackDAO;
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
@WebServlet(name = "FeedbackController", urlPatterns = {"/doctor-feedback", "/doctor-feedback-search", "/admin-feedback", "/admin-feedback-search"
,"/patient-feedback","/patient-feedback-search"})
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

            request.setAttribute("feedbacks", feedbackService.getListFeedbacks(page, 3));
            request.setAttribute("noOfPages", feedbackService.getNoOfPage(search));
            request.setAttribute("currentPage", page);
            RequestDispatcher rd = request.getRequestDispatcher("Doctor/DoctorFeedback.jsp");
            rd.forward(request, response);
        }

        if (request.getServletPath().equals("/doctor-feedback-search")) {
            search = request.getParameter("search");

            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }

            FeedbackService fbService = new FeedbackService();

            request.setAttribute("feedbacks", fbService.getFeedbacksSearchByNameDoctor(page, search, 3));
            request.setAttribute("noOfPages", fbService.getNoOfPage(search));
            request.setAttribute("currentPage", page);
            request.setAttribute("nameSearch", search);
            request.setAttribute("isSearching", true);
            RequestDispatcher rd = request.getRequestDispatcher("Doctor/DoctorFeedback.jsp");
            rd.forward(request, response);
        }

        if (request.getServletPath().equals("/admin-feedback")) {
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }
            FeedbackService feedbackService = new FeedbackService();

            request.setAttribute("feedbacks", feedbackService.getAllFeedbacks(page));
            request.setAttribute("noOfPages", feedbackService.getNoOfPage(search));
            request.setAttribute("currentPage", page);
            RequestDispatcher rd = request.getRequestDispatcher("Admin/FeedbackList.jsp");
            rd.forward(request, response);
        }

        if (request.getServletPath().equals("/admin-feedback-search")) {
            search = request.getParameter("search");

            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }

            FeedbackService fbService = new FeedbackService();

            request.setAttribute("feedbacks", fbService.getFeedbacksSearchByName(page, search));
            request.setAttribute("noOfPages", fbService.getNoOfPage(search));
            request.setAttribute("currentPage", page);
            request.setAttribute("nameSearch", search);
            request.setAttribute("isSearching", true);
            RequestDispatcher rd = request.getRequestDispatcher("Admin/FeedbackList.jsp");
            rd.forward(request, response);
        }
        
        if (request.getServletPath().equals("/patient-feedback")) {
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }
            FeedbackService feedbackService = new FeedbackService();

            request.setAttribute("feedbacks", feedbackService.getPatientFeedbacks(page,7));
            request.setAttribute("noOfPages", feedbackService.getNoOfPageforPatient(search,7));
            request.setAttribute("currentPage", page);
            RequestDispatcher rd = request.getRequestDispatcher("Patient/PatientFeedbackList.jsp");
            rd.forward(request, response);
        }

        if (request.getServletPath().equals("/patient-feedback-search")) {
            search = request.getParameter("search");

            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }

            FeedbackService fbService = new FeedbackService();

            request.setAttribute("feedbacks", fbService.getPatientFeedbacksSearch(page, search,7));
            request.setAttribute("noOfPages", fbService.getNoOfPageforPatient(search,7));
            request.setAttribute("currentPage", page);
            request.setAttribute("nameSearch", search);
            request.setAttribute("isSearching", true);
            RequestDispatcher rd = request.getRequestDispatcher("Patient/PatientFeedbackList.jsp");
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
