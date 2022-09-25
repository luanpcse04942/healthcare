package com.laptrinhweb.healthcare.controller.adminFeature.account;

import com.laptrinhweb.healthcare.dao.adminFeature.AccountDAO;
import com.laptrinhweb.healthcare.model.Account;
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
@WebServlet(urlPatterns = {"/admin-account"})
public class AccountController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccountDAO accDAO = new AccountDAO();
        ArrayList<Account> accounts = new ArrayList<>();
        
        int page = 1;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        
        int recordsPerPage = 4;
        accounts = accDAO.findAll((page - 1) * recordsPerPage, recordsPerPage);
        
        int noOfRecords = 0;
        noOfRecords = accDAO.getNoOfRecordAccounts();
        
        //calculate number of page
        int noOfPages = noOfRecords / recordsPerPage;
        if (noOfRecords % recordsPerPage > 0) {
            noOfPages++;
        }
        
        request.setAttribute("accounts", accounts);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        RequestDispatcher rd = request.getRequestDispatcher("Admin/Account/AccountList.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
