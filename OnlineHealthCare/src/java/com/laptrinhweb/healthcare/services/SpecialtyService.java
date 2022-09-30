package com.laptrinhweb.healthcare.services;

import com.laptrinhweb.healthcare.dao.SpecialtyDAO;
import com.laptrinhweb.healthcare.model.Specialty;
import java.util.ArrayList;

/**
 *
 * @author LuanPC
 */
public class SpecialtyService {

    public ArrayList<Specialty> getListSpecialty(int page) {
        SpecialtyDAO specDAO = new SpecialtyDAO();
        ArrayList<Specialty> specialties = new ArrayList<>();
        int recordsPerPage = 6;
        specialties = specDAO.getAllSpecialtyPublic((page - 1) * recordsPerPage, recordsPerPage);
        return specialties;
    }

    public int getNoOfPage(String search) {
        SpecialtyDAO specDAO = new SpecialtyDAO();
        int noOfRecords = 0;
        if (search.isEmpty()) {
            noOfRecords = specDAO.getNoOfRecordAccounts();
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
