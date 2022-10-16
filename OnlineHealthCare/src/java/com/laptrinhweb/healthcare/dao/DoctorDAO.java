package com.laptrinhweb.healthcare.dao;

import com.laptrinhweb.healthcare.context.DBContext;
import com.laptrinhweb.healthcare.model.User;
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
                acc.setImages(rs.getString(9));
                acc.setOnlineStatus(rs.getBoolean(5));
                acc.setActivedStatus(rs.getBoolean(6));
                listAccount.add(acc);
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
                acc.setImages(rs.getString("image"));
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
                acc.setImages(rs.getString("image"));
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
}
