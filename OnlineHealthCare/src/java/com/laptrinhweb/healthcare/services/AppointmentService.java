/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laptrinhweb.healthcare.services;

import com.laptrinhweb.healthcare.dao.AppointmentDAO;
import com.laptrinhweb.healthcare.model.dto.AppointmentSmall;
import java.util.List;

public class AppointmentService {

    public List<AppointmentSmall> getListAccounts(int page, int doctorID) {
        AppointmentDAO appDAO = new AppointmentDAO();
        int recordsPerPage = 6;
        return appDAO.findAllAppoints((page - 1) * recordsPerPage, recordsPerPage, doctorID);
    }

    public int getNoOfPage(String search) {
        AppointmentDAO appointmentDAO = new AppointmentDAO();
        int noOfRecords = 0;

        if (search.isEmpty()) {
            noOfRecords = appointmentDAO.getNoOfRecordAccounts();
        } else {
            noOfRecords = appointmentDAO.getNoOfRecordAccountsSearch(search);
        }

        //calculate number of page
        int recordsPerPage = 6;
        int noOfPages = noOfRecords / recordsPerPage;
        if (noOfRecords % recordsPerPage > 0) {
            noOfPages++;
        }
        
        return noOfPages;
    }

}
