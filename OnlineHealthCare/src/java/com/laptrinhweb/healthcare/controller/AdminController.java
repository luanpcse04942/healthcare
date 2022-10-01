package com.laptrinhweb.healthcare.controller;

import com.laptrinhweb.healthcare.services.AdminService;
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
@WebServlet(name = "AdminController", urlPatterns = {"/admin-account", "/admin-account-detail",
    "/admin-add-account", "/admin-account-search", "/admin-home", "/add-account"})
public class AdminController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int page = 1;
        String search = "";

        if (request.getServletPath().equals("/admin-home")) {
            RequestDispatcher rd = request.getRequestDispatcher("Admin/HomeAdmin.jsp");
            rd.forward(request, response);
        }

        if (request.getServletPath().equals("/admin-account")) {
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }
            AdminService adminService = new AdminService();

            request.setAttribute("accounts", adminService.getListAccounts(page));
            request.setAttribute("noOfPages", adminService.getNoOfPage(search));
            request.setAttribute("currentPage", page);
            RequestDispatcher rd = request.getRequestDispatcher("Admin/Account/AccountList.jsp");
            rd.forward(request, response);
        }

        if (request.getServletPath().equals("/admin-account-detail")) {
            int userId = Integer.parseInt(request.getParameter("userId"));
            AdminService adminService = new AdminService();
            request.setAttribute("account", adminService.getAccountDetail(userId));
            RequestDispatcher rd = request.getRequestDispatcher("Admin/Account/AccountDetail.jsp");
            rd.forward(request, response);
        }

        if (request.getServletPath().equals("/admin-add-account")) {
            RequestDispatcher rd = request.getRequestDispatcher("Admin/Account/AddAccount.jsp");
            rd.forward(request, response);
        }

        if (request.getServletPath().equals("/admin-account-search")) {
            search = request.getParameter("search");

            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }

            AdminService adminService = new AdminService();

            request.setAttribute("accounts", adminService.getAccountsSearchByNameOrEmail(page, search));
            request.setAttribute("noOfPages", adminService.getNoOfPage(search));
            request.setAttribute("currentPage", page);
            request.setAttribute("nameSearch", search);
            request.setAttribute("isSearching", true);
            RequestDispatcher rd = request.getRequestDispatcher("Admin/Account/AccountList.jsp");
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
        if (request.getServletPath().equals("/add-account")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            int roleId = Integer.parseInt(request.getParameter("role"));

            Part filePart = request.getPart("file");
            String fileName = filePart.getSubmittedFileName();

            String path = request.getServletContext().getRealPath("/static/images/avatars/" + fileName);
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
            AdminService adminService = new AdminService();
            adminService.addUser(email, password, firstName, lastName, fileName, roleId);
            RequestDispatcher rd = request.getRequestDispatcher("Admin/Account/AddAccount.jsp");
            rd.forward(request, response);
        }

    }
}
