package com.laptrinhweb.healthcare.dao;

import com.laptrinhweb.healthcare.context.DBContext;
import com.laptrinhweb.healthcare.model.MedicalFacility;
import com.laptrinhweb.healthcare.model.Time;
import java.sql.Date;
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
public class FacilityDAO extends DBContext {

    //get all facility for HomePage
    public ArrayList<MedicalFacility> getAllFacility() {
        StringBuilder sql = new StringBuilder("SELECT TOP 4 u.id, u.firstName, u.lastName, u.email, u.onlineStatus, u.activedStatus, up.phoneNumber, p.provinceId, p.name, ");
        sql.append(" up.address, up.image, r.id, r.roleName, mfi.established, mfi.description FROM Users u ");
        sql.append(" join MedicalFacilityInfo mfi on mfi.medicalFacilityId = u.id ");
        sql.append(" join  User_Profile up on u.id = up.id ");
        sql.append(" join User_Roles ur on ur.userId = u.id ");
        sql.append(" join Roles r on ur.roleId = r.id ");
        sql.append(" join User_Province upr on upr.userId = u.id ");
        sql.append(" join Provinces p on p.provinceId = upr.provinceId ");
        sql.append(" where ur.roleId = 4 ORDER BY u.id");
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        ArrayList<MedicalFacility> listFacility = new ArrayList<>();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                MedicalFacility mf = new MedicalFacility();
                mf.setId(rs.getInt(1));
                mf.setFirstName(rs.getString(2));
                mf.setLastName(rs.getString(3));
                mf.setEmail(rs.getString(4));
                mf.setOnlineStatus(rs.getBoolean(5));
                mf.setActivedStatus(rs.getInt(6));
                mf.setPhoneNumber(rs.getString(7));
                mf.setProvinceId(rs.getInt(8));
                mf.setProvinceName(rs.getString(9));
                mf.setAddress(rs.getString(10));
                String base64StringImage = new String(rs.getBytes(11), "UTF-8");
                mf.setImages(base64StringImage);
                mf.setRoleId(rs.getInt(12));
                mf.setRoleName(rs.getString(13));
                //mf.setEstablishedAt(rs.getDate(14));
                mf.setDescription(rs.getString(15));
                listFacility.add(mf);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        return listFacility;
    }

    public ArrayList<MedicalFacility> findAll(int start, int total) {
        StringBuilder sql = new StringBuilder("SELECT u.id, u.firstName, u.lastName, u.email, u.onlineStatus, u.activedStatus, up.phoneNumber, p.provinceId, p.name, ");
        sql.append(" up.address, up.image, r.id, r.roleName, mfi.established, mfi.description FROM Users u ");
        sql.append(" join MedicalFacilityInfo mfi on mfi.medicalFacilityId = u.id ");
        sql.append(" join  User_Profile up on u.id = up.id ");
        sql.append(" join User_Roles ur on ur.userId = u.id ");
        sql.append(" join Roles r on ur.roleId = r.id ");
        sql.append(" join User_Province upr on upr.userId = u.id ");
        sql.append(" join Provinces p on p.provinceId = upr.provinceId ");
        sql.append(" where ur.roleId = 4 ORDER BY u.id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        ArrayList<MedicalFacility> listFacility = new ArrayList<>();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql.toString());
            ps.setInt(1, start);
            ps.setInt(2, total);
            rs = ps.executeQuery();
            while (rs.next()) {
                MedicalFacility mf = new MedicalFacility();
                mf.setId(rs.getInt(1));
                mf.setFirstName(rs.getString(2));
                mf.setLastName(rs.getString(3));
                mf.setEmail(rs.getString(4));
                mf.setOnlineStatus(rs.getBoolean(5));
                mf.setActivedStatus(rs.getInt(6));
                mf.setPhoneNumber(rs.getString(7));
                mf.setProvinceId(rs.getInt(8));
                mf.setProvinceName(rs.getString(9));
                mf.setAddress(rs.getString(10));
                 String base64StringImage = new String(rs.getBytes(11), "UTF-8");
                mf.setImages(base64StringImage);
                mf.setRoleId(rs.getInt(12));
                mf.setRoleName(rs.getString(13));
                //mf.setEstablishedAt(rs.getDate(14));
                mf.setDescription(rs.getString(15));
                listFacility.add(mf);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        return listFacility;
    }

    public int getNoOfRecordFacilities() {
        String query = "SELECT count(*) FROM Users u join User_Roles ur on u.id = ur.userId where ur.roleId = 4";
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

    public int getNoOfRecordSearchFacilities(String search) {
        StringBuilder sql = new StringBuilder("SELECT count(*) FROM Users u join User_Roles ur on u.id = ur.userId ");
        sql.append(" join (select t.id ,CONCAT(t.[firstName],' ',t.[lastName]) as name from Users t) n ");
        sql.append(" on n.id = u.id and  n.name like ? and ur.roleId = 4");
        DBContext db = new DBContext();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql.toString());
            ps.setString(1, '%' + search.trim() + '%');
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

    public MedicalFacility getFacilityDetail(int facilityId) {
        StringBuilder sql = new StringBuilder("SELECT u.id, u.firstName, u.lastName, u.email, u.onlineStatus, u.activedStatus, up.phoneNumber, p.provinceId, p.name, ");
        sql.append(" up.address, up.image, r.id, r.roleName, mfi.established, mfi.description FROM Users u ");
        sql.append(" join MedicalFacilityInfo mfi on mfi.medicalFacilityId = u.id ");
        sql.append(" join  User_Profile up on u.id = up.id ");
        sql.append(" join User_Roles ur on ur.userId = u.id ");
        sql.append(" join Roles r on ur.roleId = r.id ");
        sql.append(" join User_Province upr on upr.userId = u.id ");
        sql.append(" join Provinces p on p.provinceId = upr.provinceId ");
        sql.append(" where u.id = ?");
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        MedicalFacility mf = new MedicalFacility();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql.toString());
            ps.setInt(1, facilityId);
            rs = ps.executeQuery();
            while (rs.next()) {
                mf.setId(rs.getInt(1));
                mf.setFirstName(rs.getString(2));
                mf.setLastName(rs.getString(3));
                mf.setEmail(rs.getString(4));
                mf.setOnlineStatus(rs.getBoolean(5));
                mf.setActivedStatus(rs.getInt(6));
                mf.setPhoneNumber(rs.getString(7));
                mf.setProvinceId(rs.getInt(8));
                mf.setProvinceName(rs.getString(9));
                mf.setAddress(rs.getString(10));
                String base64StringImage = new String(rs.getBytes(11), "UTF-8");
                mf.setImages(base64StringImage);
                mf.setRoleId(rs.getInt(12));
                mf.setRoleName(rs.getString(13));
                //mf.setEstablishedAt(rs.getDate(14));
                mf.setDescription(rs.getString(15));
            }
        } catch (Exception e) {
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
        return mf;
    }

    public ArrayList<MedicalFacility> getFacilitiesSearchByName(String search, int start, int total) {
        StringBuilder sql = new StringBuilder("SELECT u.id, u.firstName, u.lastName, u.email, u.onlineStatus, u.activedStatus, up.phoneNumber, p.provinceId, p.name, ");
        sql.append(" up.address, up.image, r.id, r.roleName, mfi.established, mfi.description FROM Users u ");
        sql.append(" join MedicalFacilityInfo mfi on mfi.medicalFacilityId = u.id ");
        sql.append(" join  User_Profile up on u.id = up.id ");
        sql.append(" join User_Roles ur on ur.userId = u.id ");
        sql.append(" join Roles r on ur.roleId = r.id ");
        sql.append(" join User_Province upr on upr.userId = u.id ");
        sql.append(" join Provinces p on p.provinceId = upr.provinceId ");
        sql.append(" where convert(VARCHAR(255), u.firstName)+' '+convert(VARCHAR(255), u.lastName) like '%"+search+"%' and ur.roleId = 4 ORDER BY u.id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        ArrayList<MedicalFacility> listFacility = new ArrayList<>();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql.toString());
            ps.setString(1, '%' + search.trim() + '%');
            ps.setInt(1, start);
            ps.setInt(2, total);
            rs = ps.executeQuery();
            while (rs.next()) {
                MedicalFacility mf = new MedicalFacility();
                mf.setId(rs.getInt(1));
                mf.setFirstName(rs.getString(2));
                mf.setLastName(rs.getString(3));
                mf.setEmail(rs.getString(4));
                mf.setOnlineStatus(rs.getBoolean(5));
                mf.setActivedStatus(rs.getInt(6));
                mf.setPhoneNumber(rs.getString(7));
                mf.setProvinceId(rs.getInt(8));
                mf.setProvinceName(rs.getString(9));
                mf.setAddress(rs.getString(10));
                 String base64StringImage = new String(rs.getBytes(11), "UTF-8");
                mf.setImages(base64StringImage);
                mf.setRoleId(rs.getInt(12));
                mf.setRoleName(rs.getString(13));
                //mf.setEstablishedAt(rs.getDate(14));
                mf.setDescription(rs.getString(15));
                listFacility.add(mf);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        return listFacility;
    }

    public ArrayList<Time> getAllTimes() {
        String sql = "SELECT * FROM Times";
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        ArrayList<Time> times = new ArrayList<>();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Time time = new Time();
                time.setId(rs.getInt("timeId"));
                time.setValue(rs.getString("timeValue"));
                times.add(time);
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
        return times;
    }

    public int getDoctorWorkingInfoId(int doctorId) {
        String sql = "SELECT id FROM Doctor_Working_Info WHERE doctorId = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        int doctorWorkingInfo = 0;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, doctorId);
            rs = ps.executeQuery();
            while (rs.next()) {
                doctorWorkingInfo = rs.getInt("id");
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
        return doctorWorkingInfo;
    }

    public void addSchedule(int doctorWorkingInfoId, Date scheduleDate) {
        String sql = "INSERT INTO Schedules(doctorWorkingInfoId, scheduleDate) VALUES(?,?);";
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, doctorWorkingInfoId);
            ps.setDate(2, scheduleDate);
            ps.executeUpdate();
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
    }

    public int getScheduleID(int doctorWorkingInfoId, Date scheduleDate) {
        String sql = "SELECT scheduleId FROM Schedules WHERE doctorWorkingInfoId = ? and scheduleDate = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        int scheduleID = 0;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, doctorWorkingInfoId);
            ps.setDate(2, scheduleDate);
            rs = ps.executeQuery();
            while (rs.next()) {
                scheduleID = rs.getInt("scheduleId");
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
        return scheduleID;
    }

    public void addScheduleTime(int scheduleID, ArrayList<Time> listTime) {
        String sql = "INSERT INTO Schedule_Time(scheduleId, timeId) VALUES(?,?);";
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            for (Time time : listTime) {
                ps.setInt(1, scheduleID);
                ps.setInt(2, time.getId());
                ps.executeUpdate();
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
    }

}
