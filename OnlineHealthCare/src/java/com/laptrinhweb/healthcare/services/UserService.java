package com.laptrinhweb.healthcare.services;

import com.laptrinhweb.healthcare.dao.UserDAO;
import com.laptrinhweb.healthcare.model.Province;
import com.laptrinhweb.healthcare.model.User;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author LuanPC
 */
public class UserService {

    public ArrayList<User> getListAccounts(int page) {
        UserDAO userDAO = new UserDAO();
        ArrayList<User> users = new ArrayList<>();
        int recordsPerPage = 4;
        users = userDAO.findAll((page - 1) * recordsPerPage, recordsPerPage);
        return users;
    }

    public int getNoOfPage(String search) {
        UserDAO userDAO = new UserDAO();
        int noOfRecords = 0;
        if (search.isEmpty()) {
            noOfRecords = userDAO.getNoOfRecordAccounts();
        } else {
            noOfRecords = userDAO.getNoOfRecordSearchAccounts(search);
        }

        //calculate number of page
        int recordsPerPage = 4;
        int noOfPages = noOfRecords / recordsPerPage;
        if (noOfRecords % recordsPerPage > 0) {
            noOfPages++;
        }
        return noOfPages;
    }

    public User getAccountDetail(int userId) {
        UserDAO userDao = new UserDAO();
        User user = userDao.getAccountDetail(userId);
        return user;
    }

    public ArrayList<User> getAccountsSearchByNameOrEmail(int page, String search) {
        UserDAO userDAO = new UserDAO();
        ArrayList<User> users = new ArrayList<>();
        int recordsPerPage = 4;
        users = userDAO.searchByNameOrEmail(search, (page - 1) * recordsPerPage, recordsPerPage);
        return users;
    }

    public boolean addUser(String email, String password, String firstName, String lastName, byte[] imageName, int roleId, int provinceId) throws FileNotFoundException, IOException {
   
        UserDAO userDAO = new UserDAO();
        boolean addSuccess = userDAO.addUser(email, password, firstName, lastName);
        int userId = userDAO.getUserId(email);
        userDAO.addUserProvince(userId, provinceId);
        userDAO.addUserProfile(userId, imageName);
        userDAO.addUserRole(userId, roleId);
        //userDAO.addMedicalFacilityInfo(userDAO.getUserId(email));
        return addSuccess;
    }

    public ArrayList<Province> getAllProvinces() {
        UserDAO userDAO = new UserDAO();
        return userDAO.getAllProvinces();
    }
}
