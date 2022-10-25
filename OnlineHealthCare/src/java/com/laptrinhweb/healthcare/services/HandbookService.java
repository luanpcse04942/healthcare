/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laptrinhweb.healthcare.services;

import com.laptrinhweb.healthcare.dao.HandbookDAO;
import com.laptrinhweb.healthcare.model.Handbook;
import java.util.ArrayList;

/**
 *
 * @author LuanPC
 */
public class HandbookService {
    public ArrayList<Handbook> getListHandbook(int page) {
        HandbookDAO handbookDAO = new HandbookDAO();
        ArrayList<Handbook> hanbooks = new ArrayList<>();
        int recordsPerPage = 4;
        hanbooks = handbookDAO.findAll((page - 1) * recordsPerPage, recordsPerPage);
        return hanbooks;
    }
    
        public ArrayList<Handbook> getHandbook() {
        HandbookDAO handbookDAO = new HandbookDAO();
        ArrayList<Handbook> hanbooks = new ArrayList<>();
        hanbooks = handbookDAO.getHanbookDetail();
        return hanbooks;
    }
}
