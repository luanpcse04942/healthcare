/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laptrinhweb.healthcare.services;

import com.laptrinhweb.healthcare.dao.DoctorDAO;
import com.laptrinhweb.healthcare.dao.PatientDAO;
import com.laptrinhweb.healthcare.model.User;
import com.laptrinhweb.healthcare.model.dto.PatientSmall;
import dto.AppointmentPatient;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LuanPC
 */
public class PatientService {

    public List<PatientSmall> getListAccounts(int page, int doctorID) {
        PatientDAO patientDAO = new PatientDAO();
        int recordsPerPage = 6;
        return patientDAO.findAllPatients((page - 1) * recordsPerPage, recordsPerPage, doctorID);
    }

    public int getNoOfPage(String search) {
        PatientDAO patientDAO = new PatientDAO();
        int noOfRecords = 0;
        
        if (search.isEmpty()) {
            noOfRecords = patientDAO.getNoOfRecordAccounts();
        } else {
            noOfRecords = patientDAO.getNoOfRecordAccountsSearch(search);
        }

        //calculate number of page
        int recordsPerPage = 6;
        int noOfPages = noOfRecords / recordsPerPage;
        if (noOfRecords % recordsPerPage > 0) {
            noOfPages++;
        }
        return noOfPages;
    }

    public List<PatientSmall> getPatientsSearchByName(int doctorID, int page, String search) {
        PatientDAO patientDAO = new PatientDAO();
        int recordsPerPage = 4;
        page = 1;
        return patientDAO.searchPatientOfDoctor(doctorID,search, (page - 1) * recordsPerPage, recordsPerPage);
    }
    
    public ArrayList<AppointmentPatient> getListAppointment(int page) {
        PatientDAO patientDAO = new PatientDAO();
        ArrayList<AppointmentPatient> patients = new ArrayList<>();
        int recordsPerPage = 2;
        patients = patientDAO.getAllAppointmentPatient((page - 1) * recordsPerPage, recordsPerPage);
        return patients;
    }

    
    public ArrayList<AppointmentPatient> searchListAppointment(int page,String search) {
        PatientDAO patientDAO = new PatientDAO();
        ArrayList<AppointmentPatient> patients = new ArrayList<>();
        int recordsPerPage = 2;
        patients = patientDAO.searchAppointmentPatient(search,(page - 1) * recordsPerPage, recordsPerPage);
        return patients;
    }
    
    public int getNoOfPageAppointment(String search) {
        PatientDAO patientDAO = new PatientDAO();
        int noOfRecords = 0;
        if (search.isEmpty()) {
            noOfRecords = patientDAO.getNoOfRecordAppointment();
        } else {
            noOfRecords = patientDAO.getNoOfRecordAppointmentSeach(search);
        }

        //calculate number of page
        int recordsPerPage = 2;
        int noOfPages = noOfRecords / recordsPerPage;
        if (noOfRecords % recordsPerPage > 0) {
            noOfPages++;
        }
        return noOfPages;
    }
    
}
