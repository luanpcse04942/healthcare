/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laptrinhweb.healthcare.services;

import com.laptrinhweb.healthcare.dao.FeedbackDAO;
import com.laptrinhweb.healthcare.model.dto.FeedbackSmall;
import java.util.List;

/**
 *
 * @author LuanPC
 */
public class FeedbackService {

    public Object getNoOfPage(String search) {
        FeedbackDAO feedbackDAO = new FeedbackDAO();
        int noOfRecords = 0;
        
        if (search.isEmpty()) {
            noOfRecords = feedbackDAO.getNoOfRecordAccounts();
        } 
        
        //calculate number of page
        int recordsPerPage = 6;
        int noOfPages = noOfRecords / recordsPerPage;
        if (noOfRecords % recordsPerPage > 0) {
            noOfPages++;
        }
        return noOfPages;    
    }

    public List<FeedbackSmall> getListFeedbacks(int page, int doctorID) {
        FeedbackDAO fd = new FeedbackDAO();
        int recordsPerPage = 6;
        return fd.findAllPatients((page - 1) * recordsPerPage, recordsPerPage, doctorID);
    }
    
}
