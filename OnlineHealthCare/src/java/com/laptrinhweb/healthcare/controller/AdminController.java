package com.laptrinhweb.healthcare.controller;

import com.laptrinhweb.healthcare.services.UserService;
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
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 *
 * @author LuanPC
 */
@MultipartConfig
@WebServlet(name = "AdminController", urlPatterns = {"/admin-account", "/admin-account-detail",
    "/admin-add-account", "/admin-account-search", "/admin-home", "/add-account", "/admin-dashboard"})
public class AdminController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int page = 1;
        String search = "";

        if (request.getServletPath().equals("/admin-home")) {
            RequestDispatcher rd = request.getRequestDispatcher("Admin/HomeAdmin.jsp");
            rd.forward(request, response);
        }
        
        if (request.getServletPath().equals("/admin-dashboard")) {
            RequestDispatcher rd = request.getRequestDispatcher("Admin/Dashboard.jsp");
            rd.forward(request, response);
        }
        if (request.getServletPath().equals("/admin-account")) {
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }
            UserService userService = new UserService();

            request.setAttribute("accounts", userService.getListAccounts(page));
            request.setAttribute("noOfPages", userService.getNoOfPage(search));
            request.setAttribute("currentPage", page);
            RequestDispatcher rd = request.getRequestDispatcher("Admin/Account/AccountList.jsp");
            rd.forward(request, response);
        }

        if (request.getServletPath().equals("/admin-account-detail")) {
            int userId = Integer.parseInt(request.getParameter("userId"));
            UserService userService = new UserService();
            request.setAttribute("account", userService.getAccountDetail(userId));
            RequestDispatcher rd = request.getRequestDispatcher("Admin/Account/AccountDetail.jsp");
            rd.forward(request, response);
        }

        if (request.getServletPath().equals("/admin-add-account")) {
            UserService userService = new UserService();
            request.setAttribute("provinces", userService.getAllProvinces());
            RequestDispatcher rd = request.getRequestDispatcher("Admin/Account/AddAccount.jsp");
            rd.forward(request, response);
        }

        if (request.getServletPath().equals("/admin-account-search")) {
            search = request.getParameter("search");

            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }

            UserService userService = new UserService();

            request.setAttribute("accounts", userService.getAccountsSearchByNameOrEmail(page, search));
            request.setAttribute("noOfPages", userService.getNoOfPage(search));
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
            int provinceId = Integer.parseInt(request.getParameter("province"));
            Part filePart = request.getPart("file");
            String fileName = filePart.getSubmittedFileName();

            FileInputStream mFileInputStream = new FileInputStream("C:\\images\\avatars\\" + fileName);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int bytesRead = 0;
            while ((bytesRead = mFileInputStream.read(b)) != -1) {
                bos.write(b, 0, bytesRead);
            }
            byte[] ba = bos.toByteArray();
            byte[] encoded = Base64.encodeBase64(ba);
            
            UserService userService = new UserService();
            boolean addSuccess = userService.addUser(email, password, firstName, lastName, encoded, roleId, provinceId);
            if(addSuccess) {
                request.setAttribute("messageResponse", "Thêm mới thành công !");
                request.setAttribute("alert", "success");
            }else {
                request.setAttribute("messageResponse", "Thêm mới không thành công !");
                request.setAttribute("alert", "danger");
            }
            request.setAttribute("provinces", userService.getAllProvinces());
            RequestDispatcher rd = request.getRequestDispatcher("Admin/Account/AddAccount.jsp");
            rd.forward(request, response);
        }

    }
}
