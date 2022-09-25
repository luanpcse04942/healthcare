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

/**
 *
 * @author LuanPC
 */
@WebServlet(name = "AccountDetailController", urlPatterns = {"/admin-account-detail"})
public class AccountDetailController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        AccountDAO accDao = new AccountDAO();
        Account acc = accDao.getAccountDetail(userId);
        request.setAttribute("account", acc);
        RequestDispatcher rd = request.getRequestDispatcher("Admin/Account/AccountDetail.jsp");
        rd.forward(request, response);
    }
}
