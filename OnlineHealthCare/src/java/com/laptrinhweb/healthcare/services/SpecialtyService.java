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
        }else{
             noOfRecords = specDAO.getNoOfRecordSearchSpecialty(search);
        }

        //calculate number of page
        int recordsPerPage = 6;
        int noOfPages = noOfRecords / recordsPerPage;
        if (noOfRecords % recordsPerPage > 0) {
            noOfPages++;
        }
        return noOfPages;
    }

    public ArrayList<Specialty> getSpecialtySearchByName(int page, String search) {
        SpecialtyDAO specialtyDAO = new SpecialtyDAO();
        ArrayList<Specialty> specialties = new ArrayList<>();
        int recordsPerPage = 6;
        specialties = specialtyDAO.searchByNameOrEmail(search, (page - 1) * recordsPerPage, recordsPerPage);
        return specialties;
    }

    public boolean addSpecialty(String name, String description, String fileName) {
        SpecialtyDAO specialtyDAO = new SpecialtyDAO();
        boolean addSpecSuccess = false;
        addSpecSuccess = specialtyDAO.addSpecialty(name, description, fileName);
        return addSpecSuccess;
    }

    public Specialty getSpecialtyInfo(int specialtyId) {
        SpecialtyDAO specialtyDAO = new SpecialtyDAO();
        Specialty spec = specialtyDAO.getSpecialtyInfo(specialtyId);
        return spec;
    }

    public boolean updateSpecialty(int id, String name, String description, String fileName) {
        SpecialtyDAO specialtyDAO = new SpecialtyDAO();
        boolean editSpecSuccess = false;
        editSpecSuccess = specialtyDAO.updateSpecialty(id, name, description, fileName);
        return editSpecSuccess;
    }
}
