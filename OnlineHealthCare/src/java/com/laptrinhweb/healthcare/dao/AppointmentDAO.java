package com.laptrinhweb.healthcare.dao;

import com.laptrinhweb.healthcare.context.DBContext;
import com.laptrinhweb.healthcare.model.dto.AppointmentSmall;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppointmentDAO extends DBContext {


    public List<AppointmentSmall> findAllAppoints(int start, int total, int doctorID) {
                String sql = "SELECT Appointment.appointmentId, Appointment.userId, Appointment.reasonExamination, Appointment.bookingDate, \n"
                + "Status.statusName,  Users.firstName, Users.lastName\n"
                + "FROM     Appointment INNER JOIN\n"
                + "Doctor_Working_Info ON Appointment.doctorWorkingInfoId = Doctor_Working_Info.id INNER JOIN\n"
                + "Status ON Appointment.statusId = Status.statusId INNER JOIN\n"
                + "Users ON Appointment.userId = Users.id\n"
                + "WHERE doctorId =  " + doctorID + "\n" 
                + "ORDER BY Appointment.appointmentId OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        ArrayList<AppointmentSmall> listAccount = new ArrayList<>();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, total);
            rs = ps.executeQuery();
            while (rs.next()) {
                AppointmentSmall acc = new AppointmentSmall();
                acc.setAppointmentId(rs.getInt(1));
                acc.setUserID(rs.getInt(2));
                acc.setReasonExamination(rs.getNString(3));
                acc.setBookingDate(rs.getDate(4));
                acc.setStatus(rs.getNString(5));
                acc.setUserFname(rs.getNString(6));
                acc.setUserLname(rs.getNString(7));
                listAccount.add(acc);
            }
        } catch (SQLException e) {
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
            }
        }
        return listAccount;
    }

    public int getNoOfRecordAccounts() {
                String query = "SELECT Count(*)\n" +
                                "FROM   Appointment INNER JOIN\n" +
                                "Doctor_Working_Info ON Appointment.doctorWorkingInfoId = Doctor_Working_Info.id\n" +
                                "where doctorId = 1";
        DBContext db = new DBContext();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DoctorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DoctorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DoctorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return count;
    }

    public int getNoOfRecordAccountsSearch(String search) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static void main(String[] args) {
        AppointmentDAO patientDAO = new AppointmentDAO();
        int recordsPerPage = 4;
        List<AppointmentSmall> a = patientDAO.findAllAppoints(0, recordsPerPage, 1);
        for (AppointmentSmall patientSmall : a) {
            System.out.println(patientSmall);
        }
    }
}
