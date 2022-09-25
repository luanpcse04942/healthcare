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
@WebServlet(name="SearchAccountController", urlPatterns={"/account-search"})
public class SearchAccountController extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String search = request.getParameter("search");
        AccountDAO accDAO = new AccountDAO();
        ArrayList<Account> accounts = new ArrayList<>();
        int page = 1;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        int recordsPerPage = 2;
        accounts = accDAO.searchByNameOrEmail(search, (page - 1) * recordsPerPage, recordsPerPage);
        int noOfRecords = 0;
        noOfRecords = accDAO.getNoOfRecordSearchAccounts(search);
        
        //calculate number of page
        int noOfPages = noOfRecords / recordsPerPage;
        if (noOfRecords % recordsPerPage > 0) {
            noOfPages++;
        }
        
        request.setAttribute("accounts", accounts);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        request.setAttribute("nameSearch", search);
        request.setAttribute("isSearching", true);
        RequestDispatcher rd = request.getRequestDispatcher("Admin/Account/AccountList.jsp");
        rd.forward(request, response);
    } 
}
