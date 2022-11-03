package com.laptrinhweb.healthcare.services;

import com.laptrinhweb.healthcare.dao.DoctorDAO;
import com.laptrinhweb.healthcare.dao.UserDAO;
import com.laptrinhweb.healthcare.model.User;
import com.laptrinhweb.healthcare.model.dto.DoctorFacility;
import com.laptrinhweb.healthcare.model.dto.DoctorInfoDTO;
import com.laptrinhweb.healthcare.model.dto.ScheduleDTO;
import com.laptrinhweb.healthcare.model.dto.ScheduleTimesDTO;
import java.util.ArrayList;

/**
 *
 * @author LuanPC
 */
public class DoctorService {

    public ArrayList<User> getListAccounts(int page) {
        UserDAO doctorDAO = new UserDAO();
        ArrayList<User> doctors = new ArrayList<>();
        int recordsPerPage = 6;
        doctors = doctorDAO.findAllDoctor((page - 1) * recordsPerPage, recordsPerPage);
        return doctors;
    }

    public ArrayList<DoctorFacility> getListDoctorFacility(int page) {
        DoctorDAO doctorDAO = new DoctorDAO();
        ArrayList<DoctorFacility> doctors = new ArrayList<>();
        int recordsPerPage = 6;
        doctors = doctorDAO.getAllDoctorFacility((page - 1) * recordsPerPage, recordsPerPage);
        return doctors;
    }

    public int getNoOfPage(String search) {
        DoctorDAO doctorDAO = new DoctorDAO();
        int noOfRecords = 0;
        if (search.isEmpty()) {
            noOfRecords = doctorDAO.getNoOfRecordAccounts();
        } else {
            noOfRecords = doctorDAO.getNoOfRecordAccountsSeach(search);
        }

        //calculate number of page
        int recordsPerPage = 6;
        int noOfPages = noOfRecords / recordsPerPage;
        if (noOfRecords % recordsPerPage > 0) {
            noOfPages++;
        }
        return noOfPages;
    }

    public ArrayList<User> getDoctorsSearchByName(int page, String search) {
        DoctorDAO doctorDAO = new DoctorDAO();
        ArrayList<User> doctors = new ArrayList<>();
        int recordsPerPage = 4;
        page = 1;
        doctors = doctorDAO.searchDoctor(search, (page - 1) * recordsPerPage, recordsPerPage);
        return doctors;
    }

    public ArrayList<User> getDoctorsOfFacility(int facilityId) {
        DoctorDAO doctorDAO = new DoctorDAO();
        return doctorDAO.getDoctorsOfFacility(facilityId);
    }

    public ArrayList<DoctorInfoDTO> getDoctorsForSpecialtyDetail(int specialtyId) {
        DoctorDAO doctorDAO = new DoctorDAO();
        return doctorDAO.getDoctorsForSpecialtyDetail(specialtyId);
    }

    public ArrayList<ScheduleDTO> getDoctorScheduleDates(int specialtyId) {
        DoctorDAO doctorDAO = new DoctorDAO();
        return doctorDAO.getDoctorScheduleDates(specialtyId);
    }

    public ArrayList<ScheduleTimesDTO> getScheduleTimes(int specialtyId) {
        DoctorDAO doctorDAO = new DoctorDAO();
        return doctorDAO.getScheduleTimes(specialtyId);
    }

    public ArrayList<DoctorFacility> getDoctorsFacilitySearchByName(int page, String search) {
        DoctorDAO doctorDAO = new DoctorDAO();
        ArrayList<DoctorFacility> doctors = new ArrayList<>();
        int recordsPerPage = 4;
        page = 1;
        doctors = doctorDAO.searchDoctorFacility(search, (page - 1) * recordsPerPage, recordsPerPage);
        return doctors;
    }

    public DoctorFacility getDoctorsDetailFacility(int doctorId) {
        DoctorDAO doctorDAO = new DoctorDAO();
        DoctorFacility doctorFacility = doctorDAO.getDoctorDetailFacility(doctorId);

        return doctorFacility;
    }
}
