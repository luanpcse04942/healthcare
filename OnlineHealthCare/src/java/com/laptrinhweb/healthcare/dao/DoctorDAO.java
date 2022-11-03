package com.laptrinhweb.healthcare.dao;

import com.laptrinhweb.healthcare.context.DBContext;
import com.laptrinhweb.healthcare.model.User;
import com.laptrinhweb.healthcare.model.dto.DoctorFacility;
import com.laptrinhweb.healthcare.model.dto.DoctorInfoDTO;
import com.laptrinhweb.healthcare.model.dto.ScheduleDTO;
import com.laptrinhweb.healthcare.model.dto.ScheduleTimesDTO;
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
public class DoctorDAO extends DBContext {
    
    //Function for display in HomePage
    public ArrayList<User> getAllDoctorPublic() {
        StringBuilder sql = new StringBuilder("SELECT TOP 4 u.id, u.firstName, u.lastName, u.email, u.onlineStatus, u.activedStatus, up.phoneNumber, ");
        sql.append(" up.address, up.image, r.id, r.roleName, up.gender FROM Users u ");
        sql.append(" join  User_Profile up on u.id = up.id ");
        sql.append(" join User_Roles ur on ur.userId = u.id ");
        sql.append(" join Roles r on ur.roleId = r.id ");
        sql.append(" where ur.roleId = 2 ORDER BY u.id");
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        ArrayList<User> listAccount = new ArrayList<>();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                User acc = new User();
                acc.setId(rs.getInt(1));
                acc.setRoleId(rs.getInt(10));
                acc.setRoleName(rs.getString(11));
                acc.setFirstName(rs.getString(2));
                acc.setLastName(rs.getString(3));
                acc.setEmail(rs.getString(4));
                acc.setGender(rs.getString(12));
                acc.setPhoneNumber(rs.getString(7));
                acc.setAddress(rs.getString(8));
                String base64StringImage = new String(rs.getBytes(9), "UTF-8");
                acc.setImages(base64StringImage);
                acc.setOnlineStatus(rs.getBoolean(5));
                acc.setActivedStatus(rs.getInt(6));
                listAccount.add(acc);
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
        return listAccount;
    }
    
    public ArrayList<User> findAllDoctor(int start, int total) {
        String sql = "SELECT * FROM Users where roleId like 2 ORDER BY userId OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        ArrayList<User> listAccount = new ArrayList<>();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, total);
            rs = ps.executeQuery();
            while (rs.next()) {
                User acc = new User();
                acc.setId(rs.getInt("userId"));
                acc.setRoleId(rs.getInt("roleId"));
                acc.setFirstName(rs.getString("firstName"));
                acc.setLastName(rs.getString("lastName"));
                acc.setEmail(rs.getString("email"));
                acc.setGender(rs.getString("gender"));
                acc.setPhoneNumber(rs.getString("phoneNumber"));
                acc.setAddress(rs.getString("address"));
                String base64StringImage = new String(rs.getBytes("image"), "UTF-8");
                acc.setImages(base64StringImage);
                listAccount.add(acc);
            }
        } catch (Exception e) {
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
    
    public ArrayList<User> searchDoctor(String codeSearch,int start, int total) {
        String sql = "select * from [Users] a join User_Roles b on b.userId = a.id join Roles c on c.id = b.roleId join User_Profile d on d.userId = a.id where (convert(VARCHAR(255), a.firstName)+' '+convert(VARCHAR(255), a.lastName)) like '%" + codeSearch + "%' and b.roleId like 2 ORDER BY a.id OFFSET " + start + " ROWS FETCH NEXT " + total + " ROWS ONLY";
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
                acc.setId(rs.getInt("userId"));
                acc.setRoleId(rs.getInt("roleId"));
                acc.setFirstName(rs.getString("firstName"));
                acc.setLastName(rs.getString("lastName"));
                acc.setEmail(rs.getString("email"));
                acc.setGender(rs.getString("gender"));
                acc.setPhoneNumber(rs.getString("phoneNumber"));
                acc.setAddress(rs.getString("address"));
                String base64StringImage = new String(rs.getBytes("image"), "UTF-8");
                acc.setImages(base64StringImage);
                listAccount.add(acc);
            }
        } catch (Exception e) {
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
        String query = "select count(*) from Users a join User_Roles b on b.userId = a.id where b.roleId = 2";
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
    
    public int getNoOfRecordAccountsSeach(String search) {
        String query = "SELECT count(*) FROM Users a join (select u.id ,CONCAT(u.[firstName],' ',u.[lastName]) as name from Users u) t on t.id = a.id join User_Roles b on b.userId = a.id where t.name like '%" + search + "%' and b.roleId like 2";
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

    public ArrayList<User> getDoctorsOfFacility(int facilityId) {
        StringBuilder sql = new StringBuilder("SELECT dwi.doctorId, n.firstName, n.lastName FROM Doctor_Working_Info dwi ");
        sql.append(" JOIN [MedicalFacilityInfo] mfi ON dwi.medicalFacilityInfoId = mfi.id ");
        sql.append(" JOIN Users u ON u.id = mfi.medicalFacilityId ");
        sql.append(" JOIN (SELECT t.id AS id ,t.firstName ,t.lastName FROM Users t) n ");
        sql.append(" ON n.id = dwi.doctorId and u.id = ? ");
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        ArrayList<User> doctors = new ArrayList<>();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql.toString());
            ps.setInt(1, facilityId);
            rs = ps.executeQuery();
            while (rs.next()) {
                User acc = new User();
                acc.setId(rs.getInt("doctorId"));
                acc.setFirstName(rs.getString("firstName"));
                acc.setLastName(rs.getString("lastName"));
                doctors.add(acc);
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
        return doctors;
    }

    public ArrayList<DoctorInfoDTO> getDoctorsForSpecialtyDetail(int specialtyId) {
        StringBuilder sql = new StringBuilder(" SELECT dwi.doctorId, u.firstName, u.lastName, upr.image, upr.address ,p.name, pro.name, pr.priceValue FROM Doctor_Working_Info dwi ");
        sql.append(" JOIN  Specialties sp ON sp.specialtyId = dwi.specialtyId ");
        sql.append(" JOIN Positions p ON dwi.positionId = p.positionId ");
        sql.append(" JOIN Users u ON dwi.doctorId = u.id ");
        sql.append(" JOIN User_Province up ON u.id = up.userId ");
        sql.append(" JOIN User_Profile upr ON u.id = upr.id ");
        sql.append(" JOIN Provinces pro ON up.provinceId = pro.provinceId ");
        sql.append(" JOIN Prices pr ON dwi.priceId = pr.priceId ");
        sql.append(" WHERE sp.specialtyId = ? ");
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        ArrayList<DoctorInfoDTO> doctors = new ArrayList<>();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql.toString());
            ps.setInt(1, specialtyId);
            rs = ps.executeQuery();
            while (rs.next()) {
                DoctorInfoDTO di = new DoctorInfoDTO();
                di.setDoctorId(rs.getInt(1));
                di.setDoctorName(rs.getString(2) + " " + rs.getString(3));
                di.setImage(new String(rs.getBytes(4)));
                di.setAddress(rs.getString(5));
                di.setPositionName(rs.getString(6));
                di.setProvinceName(rs.getString(7));
                di.setPrice(rs.getInt(8));
                doctors.add(di);
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
        return doctors;
    }

    public ArrayList<ScheduleDTO> getDoctorScheduleDates(int specialtyId) {
        StringBuilder sql = new StringBuilder(" SELECT d.doctorId, s.scheduleDate, s.scheduleId  FROM Schedules s ");
        sql.append(" JOIN Doctor_Working_Info d ON s.doctorWorkingInfoId = d.id ");
        sql.append(" WHERE d.specialtyId = ? and s.scheduleDate >= cast(getdate() as date) ORDER BY s.scheduleDate");
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        ArrayList<ScheduleDTO> schedules = new ArrayList<>();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql.toString());
            ps.setInt(1, specialtyId);
            rs = ps.executeQuery();
            while (rs.next()) {
                ScheduleDTO s = new ScheduleDTO();
                s.setDoctorID(rs.getInt(1));
                s.setScheduleDate(rs.getDate(2));
                s.setScheduleID(rs.getInt(3));
                schedules.add(s);
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
        return schedules;
    }

    public ArrayList<ScheduleTimesDTO> getScheduleTimes(int specialtyId) {
        StringBuilder sql = new StringBuilder("  SELECT st.scheduleId, st.timeId, t.timeValue FROM Schedule_Time st ");
        sql.append(" JOIN Times t ON st.timeId = t.timeId ");
        sql.append(" JOIN Schedules s ON s.scheduleId = st.scheduleId ");
        sql.append(" JOIN Doctor_Working_Info dwi ON dwi.id = s.doctorWorkingInfoId ");
        sql.append(" WHERE dwi.specialtyId = ? and s.scheduleDate >= cast(getdate() as date) ORDER BY st.timeId");
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        ArrayList<ScheduleTimesDTO> times = new ArrayList<>();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql.toString());
            ps.setInt(1, specialtyId);
            rs = ps.executeQuery();
            while (rs.next()) {
                ScheduleTimesDTO s = new ScheduleTimesDTO();
                s.setScheduleID(rs.getInt(1));
                s.setTimeID(rs.getInt(2));
                s.setTimeValue(rs.getString(3));
                times.add(s);
            }
        } catch (SQLException e) {
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
        return times;
    }
    
        public ArrayList<DoctorFacility> getAllDoctorFacility(int start, int total) {
        StringBuilder sql = new StringBuilder("select a.id,CONCAT(firstName,' ',lastName) fullname,s.statusName,e.gender,a.email,e.phoneNumber,d.name,e.image from Users a ");
        sql.append("join User_Roles b on b.userId = a.id ");
        sql.append(" join User_Province c on c.userId = a.id ");
        sql.append("join Provinces d on d.provinceId = c.provinceId ");
        sql.append(" join User_Profile e on e.userId = a.id ");
        sql.append(" join Status s on s.statusId = a.activedStatus where b.roleId = '2' ORDER BY a.id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        ArrayList<DoctorFacility> listAccount = new ArrayList<>();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql.toString());
            ps.setInt(1, start);
            ps.setInt(2, total);
            rs = ps.executeQuery();
            while (rs.next()) {
                DoctorFacility acc = new DoctorFacility();
                acc.setId(rs.getInt(1));
                acc.setFullname(rs.getString(2));
                acc.setStatusName(rs.getString(3));
                acc.setGender(rs.getString(4));
                acc.setEmail(rs.getString(5));
                acc.setPhoneNumber(rs.getString(6));
                acc.setAddress(rs.getString(7));
                String base64StringImage = new String(rs.getBytes(8), "UTF-8");
                acc.setImage(base64StringImage);
                listAccount.add(acc);
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
        return listAccount;
    }
    
    public ArrayList<DoctorFacility> searchDoctorFacility(String codeSearch, int start, int total) {
        StringBuilder sql = new StringBuilder("select a.id,CONCAT(firstName,' ',lastName) fullname,s.statusName,e.gender,a.email,e.phoneNumber,d.name,e.image from Users a ");
        sql.append("join User_Roles b on b.userId = a.id ");
        sql.append(" join User_Province c on c.userId = a.id ");
        sql.append("join Provinces d on d.provinceId = c.provinceId ");
        sql.append(" join User_Profile e on e.userId = a.id ");
        sql.append(" join Status s on s.statusId = a.activedStatus where (convert(VARCHAR(255), a.firstName)+' '+convert(VARCHAR(255), a.lastName)) like '%" + codeSearch + "%' and b.roleId = '2' ORDER BY a.id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        ArrayList<DoctorFacility> listAccount = new ArrayList<>();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql.toString());
            ps.setInt(1, start);
            ps.setInt(2, total);
            rs = ps.executeQuery();
            while (rs.next()) {
                DoctorFacility acc = new DoctorFacility();
                acc.setId(rs.getInt(1));
                acc.setFullname(rs.getString(2));
                acc.setStatusName(rs.getString(3));
                acc.setGender(rs.getString(4));
                acc.setEmail(rs.getString(5));
                acc.setPhoneNumber(rs.getString(6));
                acc.setAddress(rs.getString(7));
                String base64StringImage = new String(rs.getBytes(8), "UTF-8");
                acc.setImage(base64StringImage);
                listAccount.add(acc);
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
        return listAccount;
    }
    
            public DoctorFacility getDoctorDetailFacility(int userId) {
        StringBuilder sql = new StringBuilder("select a.id,CONCAT(firstName,' ',lastName) fullname,s.statusName,e.gender,a.email,e.phoneNumber,d.name,e.image,spec.name from Users a ");
        sql.append("join User_Roles b on b.userId = a.id ");
        sql.append(" join User_Province c on c.userId = a.id ");
        sql.append("join Provinces d on d.provinceId = c.provinceId ");
        sql.append(" join User_Profile e on e.userId = a.id ");
        sql.append(" join (select a.id,a.doctorId,b.name from Doctor_Working_Info a join Specialties b on b.specialtyId = a.specialtyId) spec on spec.doctorId = a.id ");
        sql.append(" join Status s on s.statusId = a.activedStatus where a.id = ? ");
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        DoctorFacility acc = new DoctorFacility();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql.toString());
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                acc.setId(rs.getInt(1));
                acc.setFullname(rs.getString(2));
                acc.setStatusName(rs.getString(3));
                acc.setGender(rs.getString(4));
                acc.setEmail(rs.getString(5));
                acc.setPhoneNumber(rs.getString(6));
                acc.setAddress(rs.getString(7));
                String base64StringImage = new String(rs.getBytes(8), "UTF-8");
                acc.setImage(base64StringImage);
                acc.setSpecName(rs.getString(9));
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
        return acc;
    }
}
