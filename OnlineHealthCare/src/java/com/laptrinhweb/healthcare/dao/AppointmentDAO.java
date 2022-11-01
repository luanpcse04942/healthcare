package com.laptrinhweb.healthcare.dao;

import com.laptrinhweb.healthcare.context.DBContext;
import dto.ApointmentFacility;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LuanPC
 */
public class AppointmentDAO extends DBContext{
    public ArrayList<ApointmentFacility> getAllAppointmentFacility(int start, int total) {
        StringBuilder sql = new StringBuilder("select a.appointmentId,b.fullNamePatient,a.reasonExamination,e.phoneNumber,d.fullName,a.bookingDate,s.statusName from Appointment a ");
        sql.append(" join (select id,CONCAT(firstName,' ',lastName) as fullNamePatient from Users) b on b.id = a.userId ");
        sql.append(" join Doctor_Working_Info c on c.id = a.doctorWorkingInfoId  ");
        sql.append(" join (select id,CONCAT(firstName,' ',lastName) as fullName from Users) d on d.id = c.doctorId");
        sql.append("  join Status s on s.statusId = a.statusId ");
        sql.append("join User_Profile e on e.userId = b.id ORDER BY b.id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        ArrayList<ApointmentFacility> listAppointment = new ArrayList<>();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql.toString());
            ps.setInt(1, start);
            ps.setInt(2, total);
            rs = ps.executeQuery();
            while (rs.next()) {
                ApointmentFacility app = new ApointmentFacility();
                app.setAppoitmentId(rs.getInt(1));
                app.setFullNamePatient(rs.getString(2));
                app.setReason(rs.getString(3));
                app.setPhoneNumber(rs.getString(4));
                app.setFullNameDoctor(rs.getString(5));
                app.setBookingDate(rs.getDate(6));
                app.setStatus(rs.getString(7));
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
                    Logger.getLogger(AppointmentDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AppointmentDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AppointmentDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(AppointmentDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AppointmentDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AppointmentDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return count;
    }
    
    public ArrayList<ApointmentFacility> searchAppointmentFacility(String codeSearch, int start, int total) {
        StringBuilder sql = new StringBuilder("select a.appointmentId,b.fullNamePatient,a.reasonExamination,e.phoneNumber,d.fullName,a.bookingDate,s.statusName from Appointment a ");
        sql.append(" join (select id,CONCAT(firstName,' ',lastName) as fullNamePatient from Users) b on b.id = a.userId ");
        sql.append(" join Doctor_Working_Info c on c.id = a.doctorWorkingInfoId  ");
        sql.append(" join (select id,CONCAT(firstName,' ',lastName) as fullName from Users) d on d.id = c.doctorId");
        sql.append("  join Status s on s.statusId = a.statusId ");
        sql.append("join User_Profile e on e.userId = b.id  where convert(VARCHAR(255), b.fullNamePatient) like '%" + codeSearch + "%' ORDER BY b.id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        ArrayList<ApointmentFacility> listAppointment = new ArrayList<>();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql.toString());

            ps.setInt(1, start);
            ps.setInt(2, total);
            rs = ps.executeQuery();
            while (rs.next()) {
                ApointmentFacility app = new ApointmentFacility();
                app.setAppoitmentId(rs.getInt(1));
                app.setFullNamePatient(rs.getString(2));
                app.setReason(rs.getString(3));
                app.setPhoneNumber(rs.getString(4));
                app.setFullNameDoctor(rs.getString(5));
                app.setBookingDate(rs.getDate(6));
                app.setStatus(rs.getString(7));
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
}
