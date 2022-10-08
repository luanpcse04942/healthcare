/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laptrinhweb.healthcare.services;

import com.laptrinhweb.healthcare.dao.FacilityDAO;
import com.laptrinhweb.healthcare.model.MedicalFacility;
import java.util.ArrayList;

/**
 *
 * @author LuanPC
 */
public class FacilityService {

    public ArrayList<MedicalFacility> getListFacilities(int page) {
        FacilityDAO facilityDAO = new FacilityDAO();
        ArrayList<MedicalFacility> facilities = new ArrayList<>();
        int recordsPerPage = 4;
        facilities = facilityDAO.findAll((page - 1) * recordsPerPage, recordsPerPage);
        return facilities;
    }

    public int getNoOfPage(String search) {
        FacilityDAO facilityDAO = new FacilityDAO();
        int noOfRecords = 0;
        if (search.isEmpty()) {
            noOfRecords = facilityDAO.getNoOfRecordAccounts();
        } else {
            noOfRecords = facilityDAO.getNoOfRecordSearchAccounts(search);
        }

        //calculate number of page
        int recordsPerPage = 4;
        int noOfPages = noOfRecords / recordsPerPage;
        if (noOfRecords % recordsPerPage > 0) {
            noOfPages++;
        }
        return noOfPages;
    }
    
}
