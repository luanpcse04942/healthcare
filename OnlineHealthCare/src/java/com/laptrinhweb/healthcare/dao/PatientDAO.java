package com.laptrinhweb.healthcare.dao;

import com.laptrinhweb.healthcare.context.DBContext;
import com.laptrinhweb.healthcare.model.User;
import com.laptrinhweb.healthcare.model.dto.PatientSmall;
import dto.AppointmentPatient;
import java.sql.Date;
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
public class PatientDAO extends DBContext {

    public List<User> getListPatient(int id) {
        String sql = "select u.id, firstName, lastName, gender, phoneNumber, address \n"
                + "from Users u, User_Profile up, Appointment a\n"
                + "where up.userId = u.id \n"
                + "and a.statusId = 3 \n"
                + "and a.userId = u.id \n"
                + "and doctorWorkingInfoId = " + id;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        ArrayList<User> listAccount = new ArrayList<>();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                User acc = new User();
                acc.setId(rs.getInt(1));
                acc.setFirstName(rs.getNString(2));
                acc.setLastName(rs.getNString(3));
                acc.setPhoneNumber(rs.getString(4));
                acc.setAddress(rs.getNString(5));
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

    public Date getAppDate(int id) {
        String sql = "select select bookingDate\n"
                + "from Appointment\n"
                + "where  userId = " + id;
        PreparedStatement ps;
        ResultSet rs;
        DBContext db = new DBContext();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            return rs.getDate(1);
        } catch (SQLException e) {
        }
        return null;
    }

    public List<PatientSmall> findAllPatients(int start, int total, int id) {
        String sql = "select u.id, firstName, lastName, phoneNumber, a.bookingDate\n"
                + "from Users u, User_Profile up, Appointment a\n"
                + "where up.userId = u.id \n"
                + "and a.statusId = 3 \n"
                + "and a.userId = u.id \n"
                + "and doctorWorkingInfoId = " + id + "\n"
                + "ORDER BY a.userId OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        List<PatientSmall> listAccount = new ArrayList<>();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, total);
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
                e.printStackTrace();
            }
        }
        return listAccount;
    }

    public int getNoOfRecordAccounts() {
        String query = "select count(*) \n"
                + "from Users u, User_Profile up, Appointment a\n"
                + "where up.userId = u.id \n"
                + "and a.statusId = 3 \n"
                + "and a.userId = u.id \n"
                + "and doctorWorkingInfoId = 1";
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

    public ArrayList<AppointmentPatient> getAllAppointmentPatient(int start, int total) {
        StringBuilder sql = new StringBuilder("select a.appointmentId,d.fullName,a.reasonExamination,addr.address,a.bookingDate,s.statusName from Appointment a ");
        sql.append(" join Users b on b.id = a.userId ");
        sql.append(" join Doctor_Working_Info c on c.id = a.doctorWorkingInfoId ");
        sql.append("  join (select id,CONCAT(firstName,' ',lastName) as fullName from Users) d on d.id = c.doctorId");
        sql.append(" join ( select m.id,p.address from Users u join MedicalFacilityInfo m on m.medicalFacilityId = u.id join User_Profile p on p.userId = u.id) addr on addr.id = c.medicalFacilityInfoId ");
        sql.append(" join Status s on s.statusId = a.statusId ORDER BY b.id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        ArrayList<AppointmentPatient> listAppointment = new ArrayList<>();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql.toString());
            ps.setInt(1, start);
            ps.setInt(2, total);
            rs = ps.executeQuery();
            while (rs.next()) {
                AppointmentPatient app = new AppointmentPatient();
                app.setAppoitmentId(rs.getInt(1));
                app.setFullName(rs.getString(2));
                app.setReason(rs.getString(3));
                app.setAddress(rs.getString(4));
                app.setBookingDate(rs.getDate(5));
                app.setStatus(rs.getString(6));
                listAppointment.add(app);
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
        return listAppointment;
    }

    public int getNoOfRecordAppointment() {
        String query = "SELECT count(*) FROM Appointment";
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
                    Logger.getLogger(PatientDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PatientDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PatientDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return count;
    }

    public int getNoOfRecordAppointmentSeach(String search) {
        String query = "SELECT count(*) FROM Appointment a join (select u.id ,(convert(VARCHAR(255), firstName)+' '+convert(VARCHAR(255), lastName)) as name from Users u) t on t.id = a.userId where t.name like '%" + search + "%'";
        DBContext db = new DBContext();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(query);
            ps.setString(1, search);
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
                    Logger.getLogger(PatientDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PatientDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PatientDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return count;
    }
    
    public ArrayList<AppointmentPatient> searchAppointmentPatient(String codeSearch,int start, int total) {
        StringBuilder sql = new StringBuilder("select a.appointmentId,d.fullName,a.reasonExamination,addr.address,a.bookingDate,s.statusName from Appointment a ");
        sql.append(" join Users b on b.id = a.userId ");
        sql.append(" join Doctor_Working_Info c on c.id = a.doctorWorkingInfoId ");
        sql.append("  join (select id,CONCAT(firstName,' ',lastName) as fullName from Users) d on d.id = c.doctorId");
        sql.append(" join ( select m.id,p.address from Users u join MedicalFacilityInfo m on m.medicalFacilityId = u.id join User_Profile p on p.userId = u.id) addr on addr.id = c.medicalFacilityInfoId ");
        sql.append(" join Status s on s.statusId = a.statusId where convert(VARCHAR(255), d.fullName) like '%" + codeSearch + "%' ORDER BY b.id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        ArrayList<AppointmentPatient> listAppointment = new ArrayList<>();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql.toString());
            ps.setInt(1, start);
            ps.setInt(2, total);
            rs = ps.executeQuery();
            while (rs.next()) {
                AppointmentPatient app = new AppointmentPatient();
                app.setAppoitmentId(rs.getInt(1));
                app.setFullName(rs.getString(2));
                app.setReason(rs.getString(3));
                app.setAddress(rs.getString(4));
                app.setBookingDate(rs.getDate(5));
                app.setStatus(rs.getString(6));
                listAppointment.add(app);
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
        return listAppointment;
    }
    
    public static void main(String[] args) {
        PatientDAO patientDAO = new PatientDAO();
        int recordsPerPage = 4;
        List<PatientSmall> a = patientDAO.searchPatientOfDoctor(1, "N", 0, recordsPerPage);
        for (PatientSmall patientSmall : a) {
            System.out.println(patientSmall);
        }
    }
}
