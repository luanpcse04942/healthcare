package com.laptrinhweb.healthcare.controller.adminFeature;
import com.laptrinhweb.healthcare.dao.adminFeature.AccountDAO;
import com.laptrinhweb.healthcare.model.Account;
import com.laptrinhweb.healthcare.paging.PageRequest;
import com.laptrinhweb.healthcare.paging.Pageble;
import com.laptrinhweb.healthcare.sort.Sorter;
import com.laptrinhweb.healthcare.utils.FormUtil;
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
@WebServlet(urlPatterns = {"/admin-account"})
public class AccountController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccountDAO accDAO = new AccountDAO();
        Account model = FormUtil.toModel(Account.class, request);
        Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
                new Sorter(model.getSortName(), model.getSortBy()));
        model.setListResult(accDAO.findAll(pageble));
        model.setTotalItem(accDAO.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
        request.setAttribute("model", model);
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
        processRequest(request, response);
    }
}
