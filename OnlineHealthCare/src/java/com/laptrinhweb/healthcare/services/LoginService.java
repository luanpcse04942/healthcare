package com.laptrinhweb.healthcare.services;

import com.laptrinhweb.healthcare.dao.LoginDAO;
import com.laptrinhweb.healthcare.model.User;

public class LoginService {

    public User LoginWithEmail(String email, String password) {
        LoginDAO loginDAO = new LoginDAO();
        return loginDAO.login(email, password);
    }
    
    public boolean SimpleRegister(String email, String password, String fname, String lname){
        LoginDAO loginDAO = new LoginDAO();
        return loginDAO.register(email, password, fname, lname);
    }
}
