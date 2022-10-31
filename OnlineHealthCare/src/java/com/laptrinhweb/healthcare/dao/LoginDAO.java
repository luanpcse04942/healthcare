package com.laptrinhweb.healthcare.dao;

import com.laptrinhweb.healthcare.context.DBContext;
import com.laptrinhweb.healthcare.model.User;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class LoginDAO extends DBContext {

    public User login(String email, String password) {
        String sql = "SELECT * FROM Users u, User_Profile p\n"
                + "where email like ? and password like ?\n"
                + "and u.id = p.userId";
        PreparedStatement ps;
        ResultSet rs;
        DBContext db = new DBContext();
        User acc = null;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                acc = new User();
                acc.setId(rs.getInt(1));
                acc.setFirstName(rs.getNString(2));
                acc.setLastName(rs.getNString(3));
                acc.setEmail(rs.getString(4));
                acc.setPassword(rs.getString(5));
                acc.setOnlineStatus(rs.getBoolean(6));
                acc.setActivedStatus(rs.getInt(7));
                acc.setCreatedAt(rs.getDate(8));
                acc.setUpdatedAt(rs.getDate(9));
                acc.setGender(rs.getString(12));
                acc.setPhoneNumber(rs.getString(13));
                acc.setAddress(rs.getNString(14));
                acc.setImages(rs.getString(15));
            }
        } catch (SQLException e) {
        }
        return acc;
    }

    public boolean register(String email, String password, String fname, String lname) {
        String sql = "INSERT INTO Users(firstName, lastName, email, password, "
                + "onlineStatus, activedStatus, createdAt, updatedAt)\n"
                + "VALUES (?, ?, ?, ?, ?, 5, GETDATE(), GETDATE())\n"
                + "Insert into User_Roles(userId, roleId)\n"
                + "select SCOPE_IDENTITY(), 3 as roleID";
        
        PreparedStatement ps;
        DBContext db = new DBContext();
        try {
            conn = db.getConn();
            
            ps = conn.prepareStatement(sql);
            ps.setNString(1, fname);
            ps.setNString(2, lname);
            ps.setString(3, email);
            ps.setString(4, password);
            ps.setBoolean(5, true);
            ps.executeUpdate();

        } catch (SQLException e) {
            return false;
        }
        return true;
    }
    
    public void findRole(User u) {
        String sql = "select id, roleName from user_roles \n" +
                        "inner join roles on roleId = id\n" +
                        "where userId = " + u.getId();
        PreparedStatement ps;
        ResultSet rs;
        DBContext db = new DBContext();
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                u.setRoleId(rs.getInt(1));
                u.setRoleName(rs.getNString(2));
            }
        } catch (SQLException e) {
        }
    }

}
