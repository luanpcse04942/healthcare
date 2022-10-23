package com.laptrinhweb.healthcare.dao;

import com.laptrinhweb.healthcare.context.DBContext;
import com.laptrinhweb.healthcare.model.Feedback;
import com.laptrinhweb.healthcare.model.dto.FeedbackSmall;
import com.laptrinhweb.healthcare.model.dto.PatientSmall;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LuanPC
 */
public class FeedbackDAO extends DBContext {

    public List<FeedbackSmall> findAllPatients(int start, int total, int id) {
        String sql = "SELECT Users.firstName, Users.lastName, User_Profile.phoneNumber, Doctor_Working_Info.createdAt, Feedbacks.[content], Feedbacks.feedBackId\n"
                + "FROM Doctor_Working_Info INNER JOIN\n"
                + "                  Feedbacks ON Doctor_Working_Info.id = Feedbacks.doctorWorkingInfoId INNER JOIN\n"
                + "                  User_Profile ON Doctor_Working_Info.id = User_Profile.id INNER JOIN\n"
                + "                  Users ON patientId = Users.id \n"
                + "				  WHERE doctorId = " + id + "\n"
                + "				  ORDER BY feedBackId OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        List<FeedbackSmall> listFeedbacks = new ArrayList<>();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, total);
            rs = ps.executeQuery();
            while (rs.next()) {
                FeedbackSmall f = new FeedbackSmall();
                f.setFname(rs.getNString(1));
                f.setLname(rs.getNString(2));
                f.setPhoneNumber(rs.getString(3));
                f.setCreatedAt(rs.getDate(4));
                f.setContent(rs.getNString(5));
                listFeedbacks.add(f);
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
                e.printStackTrace();
            }
        }
        return listFeedbacks;
    }

    public int getNoOfRecordAccounts() {
        String query = "SELECT COUNT(*)\n"
                + "FROM     Doctor_Working_Info INNER JOIN\n"
                + "                  Feedbacks ON Doctor_Working_Info.id = Feedbacks.doctorWorkingInfoId\n"
                + "				  AND doctorId = 1";
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

    public int getNoOfRecordAccountsSearch(String str) {
        String query = "select count(*) \n"
                + "from Users u, User_Profile up, Appointment a\n"
                + "where up.userId = u.id \n"
                + "and a.statusId = 3 \n"
                + "and a.userId = u.id \n"
                + "and doctorWorkingInfoId = 1"
                + "CONCAT(firstName, ' ', lastName) like '%" + str + "%'\n";

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

    public List<PatientSmall> searchPatientOfDoctor(int doctorID, String codeSearch, int start, int total) {
        String sql = "select u.id, firstName, lastName, phoneNumber, a.bookingDate \n"
                + "from Users u, User_Profile up, Appointment a\n"
                + "where up.userId = u.id\n"
                + "and a.statusId = 3 \n"
                + "and a.userId = u.id \n"
                + "and doctorWorkingInfoId = " + doctorID + "\n"
                + "and CONCAT(firstName, ' ', lastName) like ? \n"
                + "ORDER BY a.userId OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        List<PatientSmall> listAccount = new ArrayList<>();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setNString(1, "%" + codeSearch + "%");
            ps.setInt(2, start);
            ps.setInt(3, total);
            rs = ps.executeQuery();
            while (rs.next()) {
                PatientSmall acc = new PatientSmall();
                acc.setId(rs.getInt(1));
                acc.setFirstName(rs.getNString(2));
                acc.setLastName(rs.getNString(3));
                acc.setPhoneNumber(rs.getString(4));
                acc.setBookingDate(rs.getDate(5));
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

    public static void main(String[] args) {
        FeedbackDAO feedbackDAO = new FeedbackDAO();
        int recordsPerPage = 4;
        List<FeedbackSmall> a = feedbackDAO.findAllPatients(0, 4, 1);
        for (FeedbackSmall feedbackSmall : a) {
            System.out.println(feedbackSmall);
        }
    }
}
