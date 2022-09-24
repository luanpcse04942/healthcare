package com.laptrinhweb.healthcare.controller.publicFeature;

import com.laptrinhweb.healthcare.dao.publicFeature.UserDAO;
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
@WebServlet(urlPatterns = {"/dang-nhap"})
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("Public/Login.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO userDao = new UserDAO();
        Account acc = userDao.checkUserExist(username, password);
        if (acc == null) {
            doGet(request, response);
        }
        
        else switch (acc.getRoleId()) {
            case 1:
                {
                    RequestDispatcher rd = request.getRequestDispatcher("Admin/HomeAdmin.jsp");
                    rd.forward(request, response);
                    break;
                }
            case 2:
                {
                    RequestDispatcher rd = request.getRequestDispatcher("Doctor/HomeDoctor.jsp");
                    rd.forward(request, response);
                    break;
                }
            case 3:
                {
                    RequestDispatcher rd = request.getRequestDispatcher("Patient/HomePatient.jsp");
                    rd.forward(request, response);
                    break;
                }
            case 4:
                {
                    RequestDispatcher rd = request.getRequestDispatcher("Medical Facility/HomeFacility.jsp");
                    rd.forward(request, response);
                    break;
                }
            default:
                doGet(request, response);
                break;
        }
    }

}
