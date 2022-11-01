package com.laptrinhweb.healthcare.dao;

import com.laptrinhweb.healthcare.context.DBContext;
import com.laptrinhweb.healthcare.model.Status;
import com.laptrinhweb.healthcare.model.dto.AppointmentDetailFacility;
import dto.ApointmentFacility;
import java.io.UnsupportedEncodingException;
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
    
        public AppointmentDetailFacility getDetailAppointmentFacility(int appointmentId) {
        StringBuilder sql = new StringBuilder("select a.appointmentId,concat(u.firstName,' ',u.lastName) fullName,concat(user_doc.firstName,' ',user_doc.lastName) fullNameDoc, pro.gender, ");
        sql.append(" pro.phoneNumber phonePatient,a.bookingDate,p.priceValue,spec.name,concat(user_fac.firstName,' ',user_fac.lastName) fullNameFac, ");
        sql.append(" pro_doctor.phoneNumber phoneDoctor,pro_fac.phoneNumber phoneFac,t.timeValue,s.statusName,pro.image,pro_doctor.image from Appointment a  ");
        sql.append(" join Users u on u.id = a.userId ");
        sql.append(" join User_Profile pro on pro.userId = a.userId ");
        sql.append(" join Status s on s.statusId = a.statusId ");
        sql.append(" join Times t on t.timeId = a.timeId ");
        sql.append(" join Doctor_Working_Info doc on doc.id = a.doctorWorkingInfoId ");
        sql.append(" join Prices p on p.priceId = doc.priceId ");
        sql.append(" join Users user_doc on user_doc.id = doc.doctorId ");
        sql.append(" join Specialties spec on spec.specialtyId = doc.specialtyId ");
        sql.append(" join MedicalFacilityInfo fac on fac.id = doc.medicalFacilityInfoId ");
        sql.append(" join Users user_fac on user_fac.id = fac.medicalFacilityId ");
        sql.append(" join User_Profile pro_doctor on pro_doctor.userId = doc.doctorId ");
        sql.append(" join User_Profile pro_fac on pro_fac.userId = fac.medicalFacilityId ");
        sql.append(" where a.appointmentId = ? ");
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        AppointmentDetailFacility appointment = new AppointmentDetailFacility();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql.toString());
            ps.setInt(1, appointmentId);
            rs = ps.executeQuery();
            while (rs.next()) {
                appointment.setId(rs.getInt(1));
                appointment.setNamePatient(rs.getString(2));
                appointment.setNameDoctor(rs.getString(3));
                appointment.setGender(rs.getString(4));
                appointment.setPhonePatient(rs.getString(5));
                appointment.setBookingDate(rs.getDate(6));
                appointment.setPrice(rs.getInt(7));
                appointment.setSpecName(rs.getString(8));
                appointment.setNameFac(rs.getString(9));
                appointment.setPhoneDoctor(rs.getString(10));
                appointment.setPhoneFac(rs.getString(11));
                appointment.setTimeValue(rs.getString(12));
                appointment.setStatus(rs.getString(13));
                String base64StringImage = new String(rs.getBytes(14), "UTF-8");
                appointment.setImagePatient(base64StringImage);
                String base64StringImage2 = new String(rs.getBytes(15), "UTF-8");
                appointment.setImageDoctor(base64StringImage2);
            }
        } catch (SQLException e) {
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(AppointmentDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        return appointment;
    }

    public ArrayList<Status> getAllStatusFacility() {
        String sql = "select * from Status where statusId in (1,2,3,4) ";

        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        ArrayList<Status> listStatus = new ArrayList<>();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Status status = new Status();
                status.setStatusId(rs.getInt(1));
                status.setStatusName(rs.getString(2));
                listStatus.add(status);
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
        return listStatus;
    }

    public boolean updateStatus(int statusId, int appointmentId) {
        boolean editSpecSuccess = false;

        String sql = "UPDATE Appointment SET statusId = ? where appointmentId = ?";

        DBContext db = new DBContext();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, statusId);
            ps.setInt(2, appointmentId);
            ps.executeUpdate();
            editSpecSuccess = true;
        } catch (SQLException e) {
            e.printStackTrace();
            editSpecSuccess = false;
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
        return editSpecSuccess;
    }
}
