package com.laptrinhweb.healthcare.controller;

import com.laptrinhweb.healthcare.model.Handbook;
import com.laptrinhweb.healthcare.services.HandbookService;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author LuanPC
 */
@WebServlet(name="HandbookController", urlPatterns={"/HandbookController", "/handbook-list-admin"})
public class HandbookController extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int page = 1;
        String search = "";

        if (request.getServletPath().equals("/handbook-list-admin")) {
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }
            HandbookService hanbookService = new HandbookService();
            ArrayList<Handbook> u = new ArrayList<>();
            request.setAttribute("handbooks", hanbookService.getListHandbook(page));

            request.setAttribute("currentPage", page);
            RequestDispatcher rd = request.getRequestDispatcher("Admin/Handbook/HandbookList.jsp");
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
