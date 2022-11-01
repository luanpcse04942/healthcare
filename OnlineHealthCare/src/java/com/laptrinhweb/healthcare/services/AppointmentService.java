/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laptrinhweb.healthcare.services;

import com.laptrinhweb.healthcare.dao.AppointmentDAO;
import com.laptrinhweb.healthcare.model.Status;
import com.laptrinhweb.healthcare.model.dto.AppointmentDetailFacility;
import dto.ApointmentFacility;
import java.util.ArrayList;

/**
 *
 * @author LuanPC
 */
public class AppointmentService {
    public ArrayList<ApointmentFacility> getListAppointment(int page) {
        AppointmentDAO appointmentDAO = new AppointmentDAO();
        ArrayList<ApointmentFacility> patients = new ArrayList<>();
        int recordsPerPage = 2;
        patients = appointmentDAO.getAllAppointmentFacility((page - 1) * recordsPerPage, recordsPerPage);
        return patients;
    }

    public int getNoOfPageAppointment(String search) {
        AppointmentDAO appointmentDAO = new AppointmentDAO();
        int noOfRecords = 0;
        if (search.isEmpty()) {
            noOfRecords = appointmentDAO.getNoOfRecordAppointment();
        } else {
            noOfRecords = appointmentDAO.getNoOfRecordAppointmentSeach(search);
        }

        //calculate number of page
        int recordsPerPage = 2;
        int noOfPages = noOfRecords / recordsPerPage;
        if (noOfRecords % recordsPerPage > 0) {
            noOfPages++;
        }
        return noOfPages;
    }

    public ArrayList<ApointmentFacility> getAppointmentSearchByPatient(int page, String search) {
        AppointmentDAO appointmentDAO = new AppointmentDAO();
        ArrayList<ApointmentFacility> facilitys = new ArrayList<>();
        int recordsPerPage = 4;
        page = 1;
        facilitys = appointmentDAO.searchAppointmentFacility(search, (page - 1) * recordsPerPage, recordsPerPage);
        return facilitys;
    }
    
    public AppointmentDetailFacility getAppointmentDetail(int id) {
        AppointmentDAO appointmentDAO = new AppointmentDAO();
        AppointmentDetailFacility appointment = appointmentDAO.getDetailAppointmentFacility(id);
        return appointment;
    }

    public ArrayList<Status> getStatus() {
        AppointmentDAO appointmentDAO = new AppointmentDAO();
        ArrayList<Status> status = new ArrayList<>();
        status = appointmentDAO.getAllStatusFacility();
        return status;
    }

    public boolean updateStatusById(int statusId, int appointmentId) {
        AppointmentDAO appointmentDAO = new AppointmentDAO();
        boolean editSpecSuccess = false;
        editSpecSuccess = appointmentDAO.updateStatus(statusId, appointmentId);
        return editSpecSuccess;
    }
    
}
