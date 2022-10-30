/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laptrinhweb.healthcare.services;

import com.laptrinhweb.healthcare.dao.DoctorDAO;
import com.laptrinhweb.healthcare.dao.HandbookDAO;
import com.laptrinhweb.healthcare.dao.SpecialtyDAO;
import com.laptrinhweb.healthcare.dao.UserDAO;
import com.laptrinhweb.healthcare.model.Handbook;
import com.laptrinhweb.healthcare.model.User;
import java.util.ArrayList;

/**
 *
 * @author LuanPC
 */
public class HandbookService {

    public ArrayList<Handbook> getListHandbook(int page) {
        HandbookDAO handbookDAO = new HandbookDAO();
        ArrayList<Handbook> hanbooks = new ArrayList<>();
        int recordsPerPage = 6;
        hanbooks = handbookDAO.findAll((page - 1) * recordsPerPage, recordsPerPage);
        return hanbooks;
    }

    public Handbook getHandbook(int id) {
        HandbookDAO handbookDAO = new HandbookDAO();
        Handbook hanbook = handbookDAO.getHanbookDetail(id);
        return hanbook;
    }

    public boolean addHandbook(String name, byte[] fileName, String content) {
        HandbookDAO handbookDAO = new HandbookDAO();
        boolean addSpecSuccess = false;
        addSpecSuccess = handbookDAO.addSpecialty(name, fileName, content);
        return addSpecSuccess;
    }

    public boolean updateHandbook(int id, String name, String description, byte[] fileName) {
        HandbookDAO handbookDAO = new HandbookDAO();
        boolean editSpecSuccess = false;
        editSpecSuccess = handbookDAO.updateHandbook(id, name, description, fileName);
        return editSpecSuccess;
    }
    
    public int getNoOfPage(String search) {
        HandbookDAO handbookDAO = new HandbookDAO();
        int noOfRecords = 0;
        if (search.isEmpty()) {
            noOfRecords = handbookDAO.getNoOfRecordHandbook();
        }else{
             noOfRecords = handbookDAO.getNoOfRecordSearchHandbook(search);
        }

        //calculate number of page
        int recordsPerPage = 6;
        int noOfPages = noOfRecords / recordsPerPage;
        if (noOfRecords % recordsPerPage > 0) {
            noOfPages++;
        }
        return noOfPages;
    }
    
    public ArrayList<Handbook> getHandbookByName(int page, String search) {
        HandbookDAO handbookDAO = new HandbookDAO();
        ArrayList<Handbook> handbooks = new ArrayList<>();
        int recordsPerPage = 6;
        page = 1;
        handbooks = handbookDAO.searchByNameHandbook(search, (page - 1) * recordsPerPage, recordsPerPage);
        return handbooks;

    }
}
