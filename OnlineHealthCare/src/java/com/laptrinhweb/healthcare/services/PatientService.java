/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laptrinhweb.healthcare.services;

import com.laptrinhweb.healthcare.dao.PatientDAO;
import com.laptrinhweb.healthcare.model.dto.PatientSmall;
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
        if(search.isEmpty()) 
        {
            noOfRecords = patientDAO.getNoOfRecordAccounts();
        }else {
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
}
