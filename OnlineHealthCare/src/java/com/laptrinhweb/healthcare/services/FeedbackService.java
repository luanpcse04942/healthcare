/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laptrinhweb.healthcare.services;

import com.laptrinhweb.healthcare.dao.FeedbackDAO;
import com.laptrinhweb.healthcare.model.dto.FeedbackSmall;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LuanPC
 */
public class FeedbackService {

    public int getNoOfPage(String search) {
        FeedbackDAO feedbackDAO = new FeedbackDAO();
        int noOfRecords = 0;

        if (search.isEmpty()) {
            noOfRecords = feedbackDAO.getNoOfRecordAccounts();

        } else {
            noOfRecords = feedbackDAO.getNoOfRecordSearchFeedback(search);
        }

        //calculate number of page
        int recordsPerPage = 4;
        int noOfPages = noOfRecords / recordsPerPage;
        if (noOfRecords % recordsPerPage > 0) {
            noOfPages++;
        }
        return noOfPages;
    }
    
    public int getNoOfPageforPatient(String search,int patientId) {
        FeedbackDAO feedbackDAO = new FeedbackDAO();
        int noOfRecords = 0;

        if (search.isEmpty()) {
            noOfRecords = feedbackDAO.getNoOfRecordPatients(patientId);

        } else {
            noOfRecords = feedbackDAO.getNoOfRecordSearchFeedbackPatient(search,patientId);
        }

        //calculate number of page
        int recordsPerPage = 4;
        int noOfPages = noOfRecords / recordsPerPage;
        if (noOfRecords % recordsPerPage > 0) {
            noOfPages++;
        }
        return noOfPages;
    }

    public List<FeedbackSmall> getListFeedbacks(int page, int doctorID) {
        FeedbackDAO fd = new FeedbackDAO();
        int recordsPerPage = 4;
        return fd.findFeedbackofDoctor((page - 1) * recordsPerPage, recordsPerPage, doctorID);
    }
    
    public List<FeedbackSmall> getPatientFeedbacks(int page, int patientId) {
        FeedbackDAO fd = new FeedbackDAO();
        int recordsPerPage = 4;
        return fd.findFeedbackofPatient((page - 1) * recordsPerPage, recordsPerPage, patientId);
    }

    public List<FeedbackSmall> getAllFeedbacks(int page) {
        FeedbackDAO fd = new FeedbackDAO();
        int recordsPerPage = 5;
        return fd.findAllFeedback((page - 1) * recordsPerPage, recordsPerPage);
    }

    public List<FeedbackSmall> getFeedbacksSearchByName(int page, String search) {
        FeedbackDAO fd = new FeedbackDAO();
        List<FeedbackSmall> users = new ArrayList<>();
        int recordsPerPage = 5;
        users = fd.getFeedbacksSearchByName(search, (page - 1) * recordsPerPage, recordsPerPage);
        return users;
    }

    public List<FeedbackSmall> getFeedbacksSearchByNameDoctor(int page, String search, int doctorID) {
        FeedbackDAO fd = new FeedbackDAO();
        List<FeedbackSmall> users = new ArrayList<>();
        int recordsPerPage = 4;
        users = fd.getFeedbacksSearchByNameDoctor(search, (page - 1) * recordsPerPage, recordsPerPage, doctorID);
        return users;
    }
    
    public List<FeedbackSmall> getPatientFeedbacksSearch(int page, String search, int patientId) {
        FeedbackDAO fd = new FeedbackDAO();
        List<FeedbackSmall> users = new ArrayList<>();
        int recordsPerPage = 4;
        users = fd.getPatientFeedbacksSearch(search, (page - 1) * recordsPerPage, recordsPerPage, patientId);
        return users;
    }

}
