package com.laptrinhweb.healthcare.services;

import com.laptrinhweb.healthcare.dao.FacilityDAO;
import com.laptrinhweb.healthcare.model.MedicalFacility;
import com.laptrinhweb.healthcare.model.Time;
import java.sql.Date;
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
            noOfRecords = facilityDAO.getNoOfRecordFacilities();
        } else {
            noOfRecords = facilityDAO.getNoOfRecordSearchFacilities(search);
        }

        //calculate number of page
        int recordsPerPage = 4;
        int noOfPages = noOfRecords / recordsPerPage;
        if (noOfRecords % recordsPerPage > 0) {
            noOfPages++;
        }
        return noOfPages;
    }

    public MedicalFacility getFacilityDetail(int facilityId) {
        FacilityDAO facDAO = new FacilityDAO();
        MedicalFacility facility = facDAO.getFacilityDetail(facilityId);
        return facility;
    }

    public ArrayList<MedicalFacility> getFacilitiesSearchByName(int page, String search) {
        FacilityDAO facDAO = new FacilityDAO();
        ArrayList<MedicalFacility> facilities = new ArrayList<>();
        int recordsPerPage = 4;
        facilities = facDAO.getFacilitiesSearchByName(search, (page - 1) * recordsPerPage, recordsPerPage);
        return facilities;
    }

    public ArrayList<Time> getAllTimes() {
        FacilityDAO facDAO = new FacilityDAO();
        return facDAO.getAllTimes();
    }

    public int getDoctorWorkingInfoId(int doctorId) {
        FacilityDAO facDAO = new FacilityDAO();
        return facDAO.getDoctorWorkingInfoId(doctorId);
    }

    public void addSchedule(int doctorWorkingInfoId, Date scheduleDate) {
        FacilityDAO facDAO = new FacilityDAO();
        facDAO.addSchedule(doctorWorkingInfoId, scheduleDate);
    }

    public int getScheduleID(int doctorWorkingInfoId, Date scheduleDate) {
        FacilityDAO facDAO = new FacilityDAO();
        return facDAO.getScheduleID(doctorWorkingInfoId, scheduleDate); 
    }

    public void addScheduleTime(int scheduleID, ArrayList<Time> listTime) {
        FacilityDAO facDAO = new FacilityDAO();
        facDAO.addScheduleTime(scheduleID, listTime);
    }

}
