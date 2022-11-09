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

    public List<FeedbackSmall> getFeedbacksSearchByNameDoctor(String search, int start, int total, int id) {
        String sql = "SELECT Users.firstName, Users.lastName, User_Profile.phoneNumber, Feedbacks.createdAt, Feedbacks.[content], Feedbacks.feedBackId\n"
                + "                FROM Doctor_Working_Info INNER JOIN\n"
                + "                                  Feedbacks ON Doctor_Working_Info.doctorId = Feedbacks.doctorWorkingInfoId INNER JOIN\n"
                + "                                  User_Profile ON Doctor_Working_Info.doctorId = User_Profile.id INNER JOIN\n"
                + "                                  Users ON Feedbacks.patientId = Users.id \n"
                + "					where doctorId = " + id + "  and convert(VARCHAR(255),Users.firstName)+' '+convert(VARCHAR(255), Users.lastName) like  '%" + search.trim() + "%'\n"
                + "				ORDER BY feedBackId OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
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

    public List<FeedbackSmall> getPatientFeedbacksSearch(String search, int start, int total, int id) {
        String sql = "SELECT Users.firstName , Users.lastName ,Specialties.name, User_Profile.[address], Feedbacks.createdAt, Feedbacks.[content], Feedbacks.feedBackId\n"
                + "                FROM Doctor_Working_Info INNER JOIN\n"
                + "                 Feedbacks ON Feedbacks.doctorWorkingInfoId = Doctor_Working_Info.doctorId INNER JOIN\n"
                + "                 User_Profile ON Doctor_Working_Info.doctorId = User_Profile.id INNER JOIN\n"
                + "			Specialties ON Specialties.specialtyId = Doctor_Working_Info.specialtyId JOIN\n"
                + "			Users ON User_Profile.id = Users.id \n"
                + "			where patientId = " + id + " and convert(VARCHAR(255),Users.firstName)+' '+convert(VARCHAR(255), Users.lastName) like  '%" + search.trim() + "%'\n"
                + "			order by feedBackId OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
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
                f.setSpecialties(rs.getString(3));
                f.setAddress(rs.getString(4));
                f.setCreatedAt(rs.getDate(5));
                f.setContent(rs.getNString(6));
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

    public List<FeedbackSmall> getFeedbacksSearchByName(String search, int start, int total) {
        String sql = "SELECT Users.firstName, Users.lastName, User_Profile.phoneNumber, Feedbacks.createdAt, Feedbacks.[content], Feedbacks.feedBackId\n"
                + "                FROM Doctor_Working_Info INNER JOIN\n"
                + "                                  Feedbacks ON Doctor_Working_Info.doctorId = Feedbacks.doctorWorkingInfoId INNER JOIN\n"
                + "                                  User_Profile ON Doctor_Working_Info.doctorId = User_Profile.id INNER JOIN\n"
                + "                                  Users ON Feedbacks.patientId = Users.id \n"
                + "					and convert(VARCHAR(255),Users.firstName)+' '+convert(VARCHAR(255), Users.lastName) like  '%" + search.trim() + "%'\n"
                + "				ORDER BY feedBackId OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
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

    public List<FeedbackSmall> findFeedbackofDoctor(int start, int total, int id) {
        String sql = "SELECT Users.firstName, Users.lastName, User_Profile.phoneNumber, Feedbacks.createdAt, Feedbacks.[content], Feedbacks.feedBackId\n"
                + "                FROM Doctor_Working_Info INNER JOIN\n"
                + "                                  Feedbacks ON Doctor_Working_Info.doctorId = Feedbacks.doctorWorkingInfoId INNER JOIN\n"
                + "                                  User_Profile ON Doctor_Working_Info.doctorId = User_Profile.id INNER JOIN\n"
                + "                                  Users ON Feedbacks.patientId = Users.id \n"
                + "				     where doctorId = " + id + "\n"
                + "								   ORDER BY feedBackId OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
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

    public List<FeedbackSmall> findFeedbackofPatient(int start, int total, int id) {
        String sql = "SELECT Users.firstName , Users.lastName ,Specialties.name, User_Profile.[address], Feedbacks.createdAt, Feedbacks.[content], Feedbacks.feedBackId\n"
                + "                FROM Doctor_Working_Info INNER JOIN\n"
                + "                 Feedbacks ON Feedbacks.doctorWorkingInfoId = Doctor_Working_Info.doctorId INNER JOIN\n"
                + "                 User_Profile ON Doctor_Working_Info.doctorId = User_Profile.id INNER JOIN\n"
                + "			Specialties ON Specialties.specialtyId = Doctor_Working_Info.specialtyId JOIN\n"
                + "			Users ON User_Profile.id = Users.id \n"
                + "			where patientId = " + id + "\n"
                + "			order by feedBackId OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
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
                f.setSpecialties(rs.getString(3));
                f.setAddress(rs.getString(4));
                f.setCreatedAt(rs.getDate(5));
                f.setContent(rs.getNString(6));
                f.setId(rs.getInt(7));
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

    public List<FeedbackSmall> findAllFeedback(int start, int total) {
        String sql = "SELECT Users.firstName, Users.lastName, User_Profile.phoneNumber, Feedbacks.createdAt, Feedbacks.[content], Feedbacks.feedBackId\n"
                + "FROM Doctor_Working_Info INNER JOIN\n"
                + "                  Feedbacks ON Doctor_Working_Info.doctorId = Feedbacks.doctorWorkingInfoId INNER JOIN\n"
                + "                  User_Profile ON Doctor_Working_Info.doctorId = User_Profile.id INNER JOIN\n"
                + "                  Users ON patientId = Users.id \n"
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
        String query = "SELECT COUNT(*) \n"
                + "                FROM Doctor_Working_Info INNER JOIN\n"
                + "                                  Feedbacks ON Doctor_Working_Info.doctorId = Feedbacks.doctorWorkingInfoId INNER JOIN\n"
                + "                                  User_Profile ON Doctor_Working_Info.doctorId = User_Profile.id INNER JOIN\n"
                + "                                Users ON patientId = Users.id \n"
                + "                				  ";
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

    public int getNoOfRecordPatients(int id) {
        String query = "SELECT COUNT(*)\n"
                + "     FROM Doctor_Working_Info INNER JOIN\n"
                + "     Feedbacks ON Feedbacks.doctorWorkingInfoId = Doctor_Working_Info.doctorId INNER JOIN\n"
                + "     User_Profile ON Doctor_Working_Info.doctorId = User_Profile.id INNER JOIN\n"
                + "	Specialties ON Specialties.specialtyId = Doctor_Working_Info.specialtyId JOIN\n"
                + "	Users ON User_Profile.id = Users.id \n"
                + "	where patientId = "+ id +"";
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

    public int getNoOfRecordPatientsSearch(String str) {
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
    
    public int getNoOfRecordSearchFeedbackPatient(String str,int id) {
        String query = "SELECT COUNT(*)\n" +
"                FROM Doctor_Working_Info INNER JOIN\n" +
"                Feedbacks ON Feedbacks.doctorWorkingInfoId = Doctor_Working_Info.doctorId INNER JOIN\n" +
"                User_Profile ON Doctor_Working_Info.doctorId = User_Profile.id INNER JOIN\n" +
"		Specialties ON Specialties.specialtyId = Doctor_Working_Info.specialtyId JOIN\n" +
"		Users ON User_Profile.id = Users.id \n" +
"		where patientId = "+ id +" and convert(VARCHAR(255),Users.firstName)+' '+convert(VARCHAR(255), Users.lastName) like  '%" + str + "%'";

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

    public int getNoOfRecordSearchFeedback(String search) {
        StringBuilder sql = new StringBuilder("SELECT COUNT(*)\n"
                + "                FROM Doctor_Working_Info INNER JOIN\n"
                + "                                  Feedbacks ON Doctor_Working_Info.doctorId = Feedbacks.doctorWorkingInfoId INNER JOIN\n"
                + "                                  User_Profile ON Doctor_Working_Info.doctorId = User_Profile.id INNER JOIN\n"
                + "                                  Users ON Feedbacks.patientId = Users.id \n"
                + "					and convert(VARCHAR(255),Users.firstName)+' '+convert(VARCHAR(255), Users.lastName) like '%" + search.trim() + "%'");
        DBContext db = new DBContext();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql.toString());
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
                    Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return count;
    }
    
    public void deleteFeedback(String id) {
        String query = "delete from Feedbacks where feedBackId = ?";
        DBContext db = new DBContext();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(query);
            ps.setString(1, id );
           
            ps.executeUpdate();
        } catch (SQLException e) {
        } 
    }

    public static void main(String[] args) {
        FeedbackDAO feedbackDAO = new FeedbackDAO();
        int recordsPerPage = 4;
        List<FeedbackSmall> a = feedbackDAO.findFeedbackofDoctor(0, 4, 3);
        for (FeedbackSmall feedbackSmall : a) {
            System.out.println(feedbackSmall);
        }
    }
}
